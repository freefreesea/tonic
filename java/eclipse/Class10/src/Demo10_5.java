

public class Demo10_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义三个售票窗口
		TicketWindow tw1=new TicketWindow();
		//TicketWindow tw2=new TicketWindow();
		//TicketWindow tw3=new TicketWindow();
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		t1.start();
		t2.start();
		t3.start();
	}

}

//售票窗口类
class TicketWindow implements Runnable
{
	//一共2000张票
	private int nums=2000;

	
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//先判断是否还有票
			//认为 if  else要保证其原子性[同步代码块]
			synchronized(this)
			{
			
			if(nums>0)
			{
				//显示售票信息
				//Thread.currentThread().getName()  当前线程的名字
				System.out.println(Thread.currentThread().getName()+"正在售出第 "+nums+" 票");
				
				nums--;
			}
			else
				break;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	
}
}