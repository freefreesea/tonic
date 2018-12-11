/**
 * 演示FileInputStream类的使用
 */
package com.test1;
import java.io.*;

public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("d:\\aa.txt");
		FileInputStream fis=null;
		
		//因为file没有读写能力,所以需要使用inputstream流
		try {
			fis = new FileInputStream(f);
			
			//定义一个字节数组
			byte []bytes=new byte[1024];
			int n;
			while((n=fis.read(bytes))!=-1)
			{
				String s = new String(bytes, 0, n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭文件流必须放这里
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
