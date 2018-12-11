/**
 * 功能:服务器,在9999端口监听
 * 可以通过控制台,输入回送的信息
 */
package com.test1;
import java.io.*;
import java.net.*;

public class MyServer1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyServer1 ms = new MyServer1();
	}
	
	public MyServer1()
	{
		try {
			//客户端进来socket套接字产生
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("服务器正在监听...");
			Socket s = ss.accept();
			
			//接收socket中的信息
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = br.readLine();
			System.out.println("客户端说:"+str);
			
			//控制台输入返回的信息
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = br2.readLine();
			
			//返回的信息给socket
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println(str2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
