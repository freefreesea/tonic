/**
 * �����߳�ͬʱ���еİ���
 */
package com.test9;

public class Demo10_3 {
	public static void main(String[] args) {
		Pig pig = new Pig(10);
		
	}
}

//��ӡ
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
			System.out.println("����һ���߳�,������� "+times+" ��hello wolrd");
			
			if(times==n)
			{
				break;
			}
		}
	}
}

//����ѧ��
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
			System.out.println("��ǰ�����"+res);
			if(times==n)
			{
				System.out.println("�������"+res);
				break;
			}
		}
	}
}