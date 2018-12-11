/**
 * 这是一个客户端程序,可以连接服务器端
 * 
 */
package com.test1;

import java.net.Socket;
import java.io.*;

public class MyClient1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyClient1 mc = new MyClient1();
	}
	
	public MyClient1()
	{
		try {
			//Scoket()就是去连接某个服务器
			Socket s = new Socket("127.0.0.1",9999);
			
			//socket连接成功,就可以给服务器发送数据
			//我们通过printwriter,向s写数据,true即时刷新
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("你好,我是客户端");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String rl = br.readLine();
			System.out.println(rl);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
