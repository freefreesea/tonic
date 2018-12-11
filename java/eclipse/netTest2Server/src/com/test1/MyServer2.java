/**
 * 功能:是一个服务器端,9999端口监听
 * 可以通过控制台收
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
			System.out.println("服务器在9999监听");
			ServerSocket ss = new ServerSocket(9999);
			Socket s= ss.accept();
			
			//先接受客户端发来的信息
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			
			//接受从控制台输入的信息
			InputStreamReader isr2= new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			while(true)
			{
				String infoFromClient=br.readLine();
				System.out.println("客户端发来"+infoFromClient);
				
				if(infoFromClient.equals("bye"))
				{
					System.out.println("对话结束!");
					s.close();
					break;
				}
				//接受从控制台输入的信息
				System.out.println("输入你希望对客户端说的话:");
				String res=br2.readLine();
				
				//把从控制台接受的信息,回送给客户端
				pw.println(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
