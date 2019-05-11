package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;



public class IOUtilUsing {

    public static void main(String[] args) throws Exception {
    	
        IOUtils.closeQuietly(new FileReader(""));    //优雅的关闭 Reader InputStream selector等
        
        InputStream in =new FileInputStream("");
        IOUtils.toBufferedInputStream(in);                      //将流转换成buffered流
        IOUtils.buffer(in); 
        
        IOUtils.toByteArray(in);                     //将流转成字节数组、字符数组、字符串
        IOUtils.toCharArray(in,"utf-8");
        IOUtils.toString(in,"utf-8");
        
        byte[] bt = new byte[111];
        IOUtils.toString(bt,"utf-8");                //字节和字符串转换
        IOUtils.toByteArray("");
        
        OutputStream out = new FileOutputStream("");
        IOUtils.copy(in,out);                        //拷贝文件
        
        IOUtils.write(bt, out);                      //将字节数组、字符数组、字符串写入到流中

        
        IOUtils.toInputStream("","utf-8");           //字符串转换成流

        IOUtils.copyLarge(in,out);                   //大文件拷贝
        
//        readLines ( )
//        lineIterator ( )
//        readFully ( )
    }
}
