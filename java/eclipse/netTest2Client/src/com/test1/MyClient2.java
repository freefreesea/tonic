package com.test1;
import java.io.*;
import java.net.*;

public class MyClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient2 mc2 = new MyClient2();
	}
	public MyClient2()
	{
		try {
			//���ӷ�������
			Socket s = new Socket("127.0.0.1", 9999);
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
			BufferedReader br2 = new BufferedReader(isr2);
			
			while(true)
			{
				System.out.println("����������Է�����˵�Ļ�:");
				//�ͻ����ȴӿ���̨����
				String info = br.readLine();
				//Ȼ���͸�������
				pw.println(info);
				if(info.equals("bye"))
				{
					System.out.println("�Ի�����!");
					s.close();
					break;
				}
				//���ܴӷ����������Ļ�
				String res = br2.readLine();
				System.out.println("������˵:"+res);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
	
