package com.test8;

public class Demo10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		Thread t=new Thread(dog);
		t.start();
	}

}


class Dog implements Runnable
{
	public void run()
	{
		int times=0;
		while(true)
		{
			//–›√ﬂ“ª√Î
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			times++;
			System.out.println("hello world"+times);
			if(times==10)
			{
				break;
			}
		}
	}
}