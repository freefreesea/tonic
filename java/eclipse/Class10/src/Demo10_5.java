

public class Demo10_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����������Ʊ����
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

//��Ʊ������
class TicketWindow implements Runnable
{
	//һ��2000��Ʊ
	private int nums=2000;

	
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//���ж��Ƿ���Ʊ
			//��Ϊ if  elseҪ��֤��ԭ����[ͬ�������]
			synchronized(this)
			{
			
			if(nums>0)
			{
				//��ʾ��Ʊ��Ϣ
				//Thread.currentThread().getName()  ��ǰ�̵߳�����
				System.out.println(Thread.currentThread().getName()+"�����۳��� "+nums+" Ʊ");
				
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