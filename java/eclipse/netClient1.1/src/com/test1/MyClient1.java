/**
 * ����һ���ͻ��˳���,�������ӷ�������
 * 
 */
package com.test1;

import java.net.Socket;
import java.io.*;

public class MyClient1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyClient1 mc = new MyClient1();
	}
	
	public MyClient1()
	{
		try {
			//Scoket()����ȥ����ĳ��������
			Socket s = new Socket("127.0.0.1",9999);
			
			//socket���ӳɹ�,�Ϳ��Ը���������������
			//����ͨ��printwriter,��sд����,true��ʱˢ��
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("���,���ǿͻ���");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String rl = br.readLine();
			System.out.println(rl);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
