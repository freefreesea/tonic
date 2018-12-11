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
			//连接服务器端
			Socket s = new Socket("127.0.0.1", 9999);
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			InputStreamReader isr2 = new InputStreamReader(s.getInputStream());
			BufferedReader br2 = new BufferedReader(isr2);
			
			while(true)
			{
				System.out.println("请输入你想对服务器说的话:");
				//客户端先从控制台接受
				String info = br.readLine();
				//然后发送给服务器
				pw.println(info);
				if(info.equals("bye"))
				{
					System.out.println("对话结束!");
					s.close();
					break;
				}
				//接受从服务器发来的话
				String res = br2.readLine();
				System.out.println("服务器说:"+res);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
	
