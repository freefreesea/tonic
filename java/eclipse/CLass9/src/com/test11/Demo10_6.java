package com.test11;

public class Demo10_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow tw = new TicketWindow();
		Thread t1 = new Thread(tw);
		Thread t2 = new Thread(tw);
		Thread t3 = new Thread(tw);
		t1.start();
		t2.start();
		t3.start();
	}

}


class TicketWindow implements Runnable
{
	private int nums=2000;
	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			synchronized(this)
			{
				if(nums>0)
				{
					System.out.println(Thread.currentThread().getName()+"正在售出 " + nums+" 张票");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.getStackTrace();
						// TODO: handle exception
					}
					nums--;
				}
				else
				{
					break;
				}
				
			}
		}
	}
	
}