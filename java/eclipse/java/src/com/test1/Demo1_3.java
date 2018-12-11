/**
 * FileOutoutStream
 */
package com.test1;
import java.io.*;

public class Demo1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("d:\\sss.txt");
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(f);
			String s="asdasda\r\n";
			String s2="asdasdasdas";
			
			//byte []bytes=new byte[1024];
			fos.write(s.getBytes());
			fos.write(s2.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			try {
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}

	}

}
