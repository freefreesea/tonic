/*
 * 演示通过继承Thread来开发线程
 */
package com.test7;

public class Demo10_1 {
	public static void main(String[] args) {
		//创建一个cat对象
		Cat cat=new Cat();
		//启动线程,会导致run函数运行
		cat.run();
	}
}


class Cat extends Thread
{
	int times=0;
	//重写run函数
	public void run()
	{
		while(true)
		{
			System.out.println("hello world"+(times+1));
			//休眠1s   sleep会让该线程进入到blocked状态,并释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			if(times==10)
			{
				break;
			}
		}
	}
		
}