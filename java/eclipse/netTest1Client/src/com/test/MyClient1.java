/**
 * ����һ���ͻ���,�������ӷ�����
 */
package com.test;

import java.net.*;
import java.io.*;
public class MyClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient1 mc = new MyClient1();
	}
	
	public MyClient1()
	{
		try {
			//Socket()����ȥ����ĳ����������,127.0.0.1��ʾ��������ip
			//9999�Ƕ˿ں�
			Socket s = new Socket("127.0.0.1", 9999);
			
			//���s���ӳɹ�,�ͷ������ݸ�������
			//����ͨ��pw,��sд����,true��ʾ��ʹˢ��
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("������ǿͻ���");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String res = br.readLine();
			
			System.out.println("���ǿͻ���,�յ�"+res);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
