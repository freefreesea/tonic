/**
 * �����ַ���
 */
package com.test1;
import java.io.*;

public class Demo1_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		try {
			//�ȴ���filereader����,������Ϊbufferedreader
			FileReader fr=new FileReader("f:\\aa.txt");
			br=new BufferedReader(fr);
			
			//����filewriter
			FileWriter fw= new FileWriter("e:\\������.txt");
			bw=new BufferedWriter(fw);
			
			//ѭ����ȡ�ļ�
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
