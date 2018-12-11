/**
 * 功能:演示使用线程的注意事项
 */
package com.test10;

public class Demo10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cat cat1=new Cat();
		cat1.start();
		cat1.start();*/
		/*Dog dog1=new Dog();
		Thread t=new Thread(dog1);
		Thread t2=new Thread(dog1);
		t.start();
		t2.start();*/
	}

}

class Cat extends Thread
{
	public void run()
	{
		System.out.println("11");
	}
}

class Dog implements Runnable
{
	public void run()
	{
		System.out.println("22");
	}
}