/**
 * file��
 */
package com.test1;
import java.io.*;

public class Demo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���ļ�����
		/*File f = new File("D:\\aa.txt");
		
		//�õ��ļ���·��
		System.out.println("�ļ�·��"+f.getAbsolutePath());
		//�õ��ļ��Ĵ�С,�ֽڴ�С
		System.out.println("�ļ���С"+f.length());
		System.out.println("�ɶ�"+f.canRead());*/
		
		//�����ļ��ʹ����ļ���
		
		
		
	/*	File f=new File("d:\\ff\\sd.txt");
		
		
		
		
				//File f=new File("d:\\ff");
				
				if(f.isDirectory())
				{
					System.out.println("�ļ��д���");
				}
				else
				{
					//
					f.mkdirs();
				}
				if(!f.exists())
				{
					//���Դ���
					try {
						f.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("���ļ�,���ܴ���");
				}*/
		
		
		//�г�һ���ļ�������������ļ�
		File f= new File("D:\\PanData");
		
		if(f.isDirectory())
		{
			File lists[] = f.listFiles();
			for(int i=0;i<lists.length;i++)
			{
				System.out.println("�ļ�����"+lists[i].getName());
			}
		}
		
	}

}
