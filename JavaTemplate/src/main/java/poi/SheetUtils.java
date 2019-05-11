package poi;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;

public class SheetUtils extends XSSFWorkbook {

        public static XSSFSheet cloneSheet(XSSFWorkbook srcExcel,String srcSheetName,XSSFWorkbook distExcel, String newName) throws Exception {

            XSSFSheet srcSheet = srcExcel.getSheet(srcSheetName);

            if (newName == null) {
                String srcName = srcSheet.getSheetName();
            } else {
                if(distExcel.getSheet(newName)!=null){
                    throw new Exception("newName在目标excel中已存在");
                }
            }

            XSSFSheet clonedSheet = distExcel.createSheet(newName);

            // copy sheet's relations
            List<RelationPart> rels = srcSheet.getRelationParts();
            // if the sheet being cloned has a drawing then remember it and re-create it too
            XSSFDrawing dg = null;
            for(POIXMLDocumentPart.RelationPart rp : rels) {
                POIXMLDocumentPart r = rp.getDocumentPart();
                // do not copy the drawing relationship, it will be re-created
                if(r instanceof XSSFDrawing) {
                    dg = (XSSFDrawing)r;
                    continue;
                }
                addRelation(rp, clonedSheet);
            }

            try {
                for(PackageRelationship pr : srcSheet.getPackagePart().getRelationships()) {
                    if (pr.getTargetMode() == TargetMode.EXTERNAL) {
                        clonedSheet.getPackagePart().addExternalRelationship
                                (pr.getTargetURI().toASCIIString(), pr.getRelationshipType(), pr.getId());
                    }
                }
            } catch (InvalidFormatException e) {
                throw new POIXMLException("Failed to clone sheet", e);
            }



                ByteArrayOutputStream out = new ByteArrayOutputStream();
                Method[] methods = srcSheet.getClass().getDeclaredMethods();
                for(Method method:methods){
                    if(method.getName().equals("write")){
                        method.setAccessible(true);
                        method.invoke(srcSheet,out);
                    }
                }
            for(Method method:methods){
                if(method.getName().equals("read")){
                    method.setAccessible(true);
                    method.invoke(clonedSheet,new ByteArrayInputStream(out.toByteArray()));
                }
            }
                //srcSheet.write(out);
                //clonedSheet.read(new ByteArrayInputStream(out.toByteArray()));

            CTWorksheet ct = clonedSheet.getCTWorksheet();
            if(ct.isSetLegacyDrawing()) {
                ct.unsetLegacyDrawing();
            }
            if (ct.isSetPageSetup()) {
                ct.unsetPageSetup();
            }

            clonedSheet.setSelected(false);

            // clone the sheet drawing along with its relationships
            if (dg != null) {
                if(ct.isSetDrawing()) {
                    // unset the existing reference to the drawing,
                    // so that subsequent call of clonedSheet.createDrawingPatriarch() will create a new one
                    ct.unsetDrawing();
                }
                XSSFDrawing clonedDg = clonedSheet.createDrawingPatriarch();
                // copy drawing contents
                clonedDg.getCTDrawing().set(dg.getCTDrawing());

                clonedDg = clonedSheet.createDrawingPatriarch();

                // Clone drawing relations
                List<POIXMLDocumentPart.RelationPart> srcRels = srcSheet.createDrawingPatriarch().getRelationParts();
                for (POIXMLDocumentPart.RelationPart rp : srcRels) {
                    addRelation(rp, clonedDg);
                }
            }
            return clonedSheet;
        }


    private static void addRelation(RelationPart rp, POIXMLDocumentPart target) {
        PackageRelationship rel = rp.getRelationship();
        if (rel.getTargetMode() == TargetMode.EXTERNAL) {
            target.getPackagePart().addRelationship(
                    rel.getTargetURI(), rel.getTargetMode(), rel.getRelationshipType(), rel.getId());
        } else {
            XSSFRelation xssfRel = XSSFRelation.getInstance(rel.getRelationshipType());
            if (xssfRel == null) {
                // Don't copy all relations blindly, but only the ones we know about
                throw new POIXMLException("Can't clone sheet - unknown relation type found: "+rel.getRelationshipType());
            }
            target.addRelation(rel.getId(), xssfRel, rp.getDocumentPart());
        }
    }
}

