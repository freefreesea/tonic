/**
 * ��ʾFileInputStream���ʹ��
 */
package com.test1;
import java.io.*;

public class Demo1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("d:\\aa.txt");
		FileInputStream fis=null;
		
		//��Ϊfileû�ж�д����,������Ҫʹ��inputstream��
		try {
			fis = new FileInputStream(f);
			
			//����һ���ֽ�����
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
			//�ر��ļ������������
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
