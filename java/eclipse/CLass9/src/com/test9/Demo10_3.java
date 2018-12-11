/**
 * 两个线程同时运行的案例
 */
package com.test9;

public class Demo10_3 {
	public static void main(String[] args) {
		Pig pig = new Pig(10);
		
	}
}

//打印
class Pig 
{
	int n=10;
	int times=0;
	public Pig(int n)
	{
		this.n=n;

		
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
			}
			times++;
			System.out.println("我是一个线程,在输出第 "+times+" 哥hello wolrd");
			
			if(times==n)
			{
				break;
			}
		}
	}
}

//算数学题
class Bird implements Runnable
{
	
	int n;
	int res=0;
	int times=0;
	public Bird(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
			}
			
			res+=(++times);
			System.out.println("当前结果是"+res);
			if(times==n)
			{
				System.out.println("最后结果是"+res);
				break;
			}
		}
	}
}