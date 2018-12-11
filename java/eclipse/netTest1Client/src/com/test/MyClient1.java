/**
 * 这是一个客户端,可以连接服务器
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
			//Socket()就是去连接某个服务器端,127.0.0.1表示服务器的ip
			//9999是端口号
			Socket s = new Socket("127.0.0.1", 9999);
			
			//如果s连接成功,就发送数据给服务器
			//我们通过pw,向s写数据,true表示即使刷新
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("你好我是客户端");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String res = br.readLine();
			
			System.out.println("我是客户端,收到"+res);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
