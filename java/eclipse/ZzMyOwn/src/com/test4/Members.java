package com.test4;
import java.util.*;

//̹���� 
//��Ϣ:����,�ٶ�,�Ƿ���,����,�Ƿ�Ӣ��
//���캯��:����һ��̹��,������,�����ṩ��Ϣ
//����:�ƶ�,����
class Tank
{
	int x;
	int y;
	int direct;
	int speed;
	int isHero;
	boolean isLive=true;
	
	Vector<Bullet> bullets;

	public Tank(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
		bullets = new Vector<Bullet>();
	}
	
	public void fire()
	{
		Bullet bullet = new Bullet(this);
		bullets.add(bullet);
		Thread bulletThread = new Thread(bullet);
		bulletThread.start();
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getIsHero() {
		return isHero;
	}

	public void setIsHero(int isHero) {
		this.isHero = isHero;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
}


//�ӵ��� 
//��Ϣ:����,�ٶ�,�Ƿ���,����
//���캯��:����һ���ӵ�,������,�����ṩ��Ϣ
//����:�ƶ�,�����ж�
class Bullet implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=3;
	boolean isLive=true;
	
	public Bullet(Tank tank)
	{
		this.direct=tank.direct;
		switch(direct)
		{
		case 0:
			this.x=tank.x+10;
			this.y=tank.y;
			break;
		case 2:
			this.x=tank.x+10;
			this.y=tank.y+30;
			break;
		case 1:
			this.x=tank.x;
			this.y=tank.y+10;
			break;
		case 3:
			this.x=tank.x+30;
			this.y=tank.y+10;
			break;	
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			switch(direct)
			{
			case 0:
				y-=speed;
				break;
			case 1:
				x-=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x+=speed;
				break;
			}
			if(isLive==false)
			{
				break;
			}
			//System.out.println(x+"    "+y);
		}
	}
}

class Bomb
{
	int x;
	int y;
	int life=9;
	boolean isLive=true;
	
	public Bomb(Tank tank)
	{
		this.x=tank.x;
		this.y=tank.y;
	}
	
	public void lifeDown()
	{
	
			life-=1;
	
	}
}


//Ӣ���� 
//��Ϣ:����,�ٶ�,�Ƿ���,����.�Ƿ�Ӣ��
//���캯��:����һ����ɫ,������,�����ṩ��Ϣ
//����:�ƶ�,����
class Hero extends Tank
{
	int speed = 2;
	int isHero = 0;
	boolean isLive=true;
	public Hero(int x,int y,int direct)
	{
		super(x,y,direct);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getIsHero() {
		return isHero;
	}
	public void setIsHero(int isHero) {
		this.isHero = isHero;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
}


//������ 
//��Ϣ:����,�ٶ�,�Ƿ���,����.�Ƿ�Ӣ��
//���캯��:����һ����ɫ,������,�����ṩ��Ϣ
//����:�ƶ�,����  �����Լ�����
class Enemy extends Tank implements Runnable
{
	int speed = 3;
	int isHero = 1;
	boolean isLive=true;
	public Enemy(int x,int y,int direct)
	{
		super(x,y,direct);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getIsHero() {
		return isHero;
	}
	public void setIsHero(int isHero) {
		this.isHero = isHero;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			direct= (int)(Math.random()*4);
			switch(direct)
			{
			case 0:
				if (y>0) {
					for (int i = 0; i < 30; i++) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						y -= speed;
					} 
				}
				break;
			case 1:
				if (x>20) {
					for (int i = 0; i < 30; i++) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						x -= speed;
					} 
				}
				break;
			case 2:
				if (y<220) {
					for (int i = 0; i < 30; i++) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						y += speed;
					} 
				}
				break;
			case 3:
				if (x<310) {
					for (int i = 0; i < 30; i++) {
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						x += speed;
					} 
				}
				break;
				
			}
			this.fire();
		}
	}

}