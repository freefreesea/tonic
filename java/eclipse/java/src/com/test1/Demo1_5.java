/**
 * 文件字符流
 */
package com.test1;
import java.io.*;
public class Demo1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		
		FileWriter fw=null;
		
		try {
			//创建fr
			fr = new FileReader("f:\\aa.txt");
			fw = new FileWriter("e:\\aa.txt");
			int n=0;  //记录实际读取的字符数
			//读入到内存
			char c[]=new char[1024];
			while((n=fr.read(c))!=-1)
			{
				fw.write(c, 0, n);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			try {
				fr.close();
				fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}

}
