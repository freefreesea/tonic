package com.test3;

import java.util.Vector;

//ը����
class Bomb
{
	//����ը��������
	int x,y;
	//ը��������
	int life=9;
	boolean isLive = true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//��������ֵ
	public void lifeDowm()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive=false;
		}
	}
}


//�ӵ���
class Shot implements Runnable //�������һ��ʱ�����Ǳ仯��  ���Կ����߳�
{
	int x,y,direct;
	int speed=3;
	//�Ƿ񻹻���
	boolean isLive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
		
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(50);;
			} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
			}
			switch (direct) {
			case 0:
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			System.out.println(x+"   "+y);
			//�ӵ���ʱ����???
			//�жϸ��ӵ��Ƿ�������Ե
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
		}
	}
}





class Tank
{
	int x=0;//������

	int y=0;//������
	
	//̹�˷��� 0�� 1�� 2�� 3��
	int direct = 0;
	
	int color;
	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}

class EnemyTank extends Tank
{
	boolean isLive = true;
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}



//�ҵ�̹����
class Hero extends Tank
{
	
	//�ӵ�
	
	Vector<Shot> ss = new Vector<Shot>();
	Shot s=null;
	public Hero(int x,int y)
	{
		super(x, y);
	}
	
	//����
	public void shotEnemy()
	{
		
		switch(this.direct)
		{
		case 0:
			s=new Shot(x+10, y,0);
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30, y+10,1);
			ss.add(s);
			break;
		case 2:
			s=new Shot(x+10, y+30,2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x, y+10,3);
			ss.add(s);
			break;
			
		}
		//�����ӵ��߳�
		Thread t=new Thread(s);
		t.start();
	}
}