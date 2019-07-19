package jaxb.demo1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JaxbTest {

    public static void main(String[] args) {
            String str="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<root xmlns=\"demo1\">\n" +
                    "        <MsgHeader>\n" +
                    "            <MsgId>31310000001311</MsgId>\n" +
                    "            <MsgType>11</MsgType>\n" +
                    "            <SignSN>313100000013</SignSN>\n" +
                    "        </MsgHeader>\n" +
                    "        <MsgBody>\n" +
                    "            <InstgAcctNm>客户备付金</InstgAcctNm>\n" +
                    "            <ResfdAcctIssrId>C1010511003703</ResfdAcctIssrId>\n" +
                    "        </MsgBody>\n" +
                    "</root>";
            Root rootinfo = xmlToBean(str);
        System.out.println(rootinfo.getMsgHeader().getMsgId());
    }


    public static Root xmlToBean(String string) {
        Root rootInfo=new Root();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            rootInfo=(Root)unmarshaller.unmarshal(new StringReader(string));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rootInfo;
    }
    public Root xmlToBeanByFile( String filePath) {
        Root rootInf=new Root();
        File file=new File(filePath);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            rootInf = (Root) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rootInf;
    }

    public String beanToXml(Root rootInf) {
        String result = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//格式化输出
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//编码格式
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//去掉默认报文头
            StringWriter writer = new StringWriter();
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");//重写报文头
            writer.write("\n");
            marshaller.marshal(rootInf, writer);
            result = writer.toString();
            //写入到xml文件中
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File("要写入的xml文件位置")));
            bufferedWriter.write(result);
            bufferedWriter.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
