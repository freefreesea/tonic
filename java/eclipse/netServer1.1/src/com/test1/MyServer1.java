/**
 * ���ǵ�һ����������������,������9999�Ŷ˿ڼ���
 * ���Խ��ܴӿͻ��˷�������Ϣ
 * 
 */
package com.test1;

import java.io.*;
import java.net.*;

public class MyServer1 {
	
	public static void main(String []args)
	{
		MyServer1 myServer1 = new MyServer1();
	}

	public MyServer1()
	{
		try {
			//��9999�Ŷ˿ڼ���
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("���Ƿ�����,����9999�˿ڼ���...");
				
			//�ȴ�ĳ���ͻ���������,�ú����᷵��һ��Socket����
			Socket s = ss.accept();
			
			//Ҫ��ȡs�д��ݵ�ֵ
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);	
			String rl = br.readLine();
			System.out.println(rl);
			
			//��s������
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("asdasd");
			//PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			//pw.println("���,���Ƿ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	