/**
 * ����:������,��9999�˿ڼ���
 * ����ͨ������̨,������͵���Ϣ
 */
package com.test1;
import java.io.*;
import java.net.*;

public class MyServer1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyServer1 ms = new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			//�ͻ��˽���socket�׽��ֲ���
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("���������ڼ���...");
			Socket s = ss.accept();
			
			//����socket�е���Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("�ͻ���˵:"+str);
			
			//����̨���뷵�ص���Ϣ
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = br2.readLine();
			
			//���ص���Ϣ��socket
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println(str2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
