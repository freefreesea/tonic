/**
 * file类
 */
package com.test1;
import java.io.*;

public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个文件对象
		/*File f = new File("D:\\aa.txt");
		
		//得到文件的路径
		System.out.println("文件路径"+f.getAbsolutePath());
		//得到文件的大小,字节大小
		System.out.println("文件大小"+f.length());
		System.out.println("可读"+f.canRead());*/
		
		//创建文件和创建文件夹
		
		
		
	/*	File f=new File("d:\\ff\\sd.txt");
		
		
		
		
				//File f=new File("d:\\ff");
				
				if(f.isDirectory())
				{
					System.out.println("文件夹存在");
				}
				else
				{
					//
					f.mkdirs();
				}
				if(!f.exists())
				{
					//可以创建
					try {
						f.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("有文件,不能创建");
				}*/
		
		
		//列出一个文件夹下面的所有文件
		File f= new File("D:\\PanData");
		
		if(f.isDirectory())
		{
			File lists[] = f.listFiles();
			for(int i=0;i<lists.length;i++)
			{
				System.out.println("文件名是"+lists[i].getName());
			}
		}
		
	}

}
