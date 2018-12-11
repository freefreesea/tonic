/**
 * 这是第一个服务器监听程序,让他在9999号端口监听
 * 可以接受从客户端发来的信息
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
			//在9999号端口监听
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("我是服务器,我在9999端口监听...");
				
			//等待某个客户端来连接,该函数会返回一个Socket连接
			Socket s = ss.accept();
			
			//要读取s中传递的值
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);	
			String rl = br.readLine();
			System.out.println(rl);
			
			//向s中输入
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("asdasd");
			//PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			//pw.println("你好,我是服务器");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	