/*
 * ��ʾͨ���̳�Thread�������߳�
 */
package com.test7;

public class Demo10_1 {
	public static void main(String[] args) {
		//����һ��cat����
		Cat cat=new Cat();
		//�����߳�,�ᵼ��run��������
		cat.run();
	}
}


class Cat extends Thread
{
	int times=0;
	//��дrun����
	public void run()
	{
		while(true)
		{
			System.out.println("hello world"+(times+1));
			//����1s   sleep���ø��߳̽��뵽blocked״̬,���ͷ���Դ
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