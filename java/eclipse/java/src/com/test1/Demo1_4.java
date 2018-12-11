/**
 * 图片拷贝
 */
package com.test1;
import java.io.*;
public class Demo1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File f=new File();
		
		//输入流
		FileInputStream fis=null;
		//输出流
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("f:\\a.jpg");
			fos=new FileOutputStream("e:\\a.jpg");
			
			byte buf[]=new byte[512];
			//循环读取
			int n=0;//记录实际读取到的字节数
			
			
			while((n=fis.read(buf))!=-1)
			{
				//输出到指定文件
				fos.write(buf);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}

}
