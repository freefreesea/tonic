/**
 * ͼƬ����
 */
package com.test1;
import java.io.*;
public class Demo1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File f=new File();
		
		//������
		FileInputStream fis=null;
		//�����
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("f:\\a.jpg");
			fos=new FileOutputStream("e:\\a.jpg");
			
			byte buf[]=new byte[512];
			//ѭ����ȡ
			int n=0;//��¼ʵ�ʶ�ȡ�����ֽ���
			
			
			while((n=fis.read(buf))!=-1)
			{
				//�����ָ���ļ�
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
