/**
 * ����:��һ����������,9999�˿ڼ���
 * ����ͨ������̨��
 */
package com.test1;


import java.net.*;
import java.io.*;
public class MyServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer2 ms2 = new MyServer2();
	}

	
	public MyServer2()
	{
		try {
			System.out.println("��������9999����");
			ServerSocket ss = new ServerSocket(9999);
			Socket s= ss.accept();
			
			//�Ƚ��ܿͻ��˷�������Ϣ
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			//���ܴӿ���̨�������Ϣ
			InputStreamReader isr2= new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("�ͻ��˷���"+infoFromClient);
				
				if(infoFromClient.equals("bye"))
				{
					System.out.println("�Ի�����!");
					s.close();
					break;
				}
				//���ܴӿ���̨�������Ϣ
				System.out.println("������ϣ���Կͻ���˵�Ļ�:");
				String res=br2.readLine();
				
				//�Ѵӿ���̨���ܵ���Ϣ,���͸��ͻ���
				pw.println(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
