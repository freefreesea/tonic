/**
 * ���ǵ�һ���������˳���,������9999�˿ڼ���
 * ���Խ��ܴӿͻ��˷�������Ϣ
 */
package com.test1;
import java.net.*;
import java.io.*;

public class MyServer1 {
	
	public static void main(String[] args) {
		MyServer1 ms= new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			//��9999�Ŷ˿ڼ���
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("���Ƿ�����,��9999�˿ڼ���");
			//�ȴ�ĳ���ͻ�������,�ú����᷵��һ��Socket����
			Socket s = ss.accept();
			
			//Ҫ��ȡs�д��ݵ�����
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String info = br.readLine();
			System.out.println("�������յ�"+info);
			
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("���Ƿ�����,��Ҳ��");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
