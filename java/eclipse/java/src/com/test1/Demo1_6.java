/**
 * 缓冲字符流
 */
package com.test1;
import java.io.*;

public class Demo1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			//先创建filereader对象,再升级为bufferedreader
			FileReader fr=new FileReader("f:\\aa.txt");
			br=new BufferedReader(fr);
			
			//创建filewriter
			FileWriter fw= new FileWriter("e:\\还早云.txt");
			bw=new BufferedWriter(fw);
			
			//循环读取文件
			String s="";
			while((s=br.readLine())!=null)
			{
				bw.write(s+"\r\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			try {
				br.close();
				bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}

}
