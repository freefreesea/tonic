package com.test2;
import java.util.*;

import javax.swing.*;


//̹���� 
//��Ϣ:����,�ٶ�,�Ƿ���,����,�Ƿ�Ӣ��
//���캯��:����һ��̹��,������,�����ṩ��Ϣ
//����:�ƶ�,����
class Tank
{
	int x;
	int y;
	int speed;
	boolean isLIve=true;
	int direct;
	int isHero;
	Vector<Bullet> bullets= new Vector<Bullet>();    //̹�˵ĵ���
	Bullet bullet;
	
	public Tank(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	
	
	public void hitWall()					//�жϺ���
	{
		for (int i = 0; i < this.bullets.size(); i++) {
			//����ǽ��
			int x= this.bullets.get(i).x;
			int y= this.bullets.get(i).y;
			System.out.println(i);
			if (x < 0 || x > 400 || y < 0 || y > 300) {
				this.bullets.remove(i);
			} 
		}
	}
	

	
	//���Ǵ���һ���ӵ�
	public void fire()
	{
		bullet = new Bullet(this);
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isLIve() {
		return isLIve;
	}

	public void setLIve(boolean isLIve) {
		this.isLIve = isLIve;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getIsHero() {
		return isHero;
	}

	public void setIsHero(int isHero) {
		this.isHero = isHero;
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
	int speed=2;
	boolean isLive=true;
	public Bullet(Tank tank)
	{
		this.direct=tank.direct;
		switch(direct)
		{
		case 0:
		{
			this.x=tank.getX()+10;
			this.y=tank.getY();
			break;
		}
		case 1:
		{
			this.x=tank.getX();
			this.y=tank.getY()+10;
			break;
		}
		case 2:
		{
			this.x=tank.getX()+10;
			this.y=tank.getY()+30;
			break;
		}
		case 3:
		{
			this.x=tank.getX()+30;
			this.y=tank.getY()+10;
			break;
		}
		}
	}
	
	
	@Override
	public void run() {
		while (true) {
			if (x<400&&x>0&&y>0&&y<300) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				switch (this.direct) {
				case 0:
					y -= speed;
					break;
				case 1:
					x -= speed;
					break;
				case 2:
					y += speed;
					break;
				case 3:
					x += speed;
					break;
				}
				System.out.println(x + "   " + y);
			}
		
		}
		
	}
}

//ը���� 
//��Ϣ:����,�Ƿ���
//���캯��:����һ��ը��,�������ṩ��Ϣ
//����:��ը
class Bomb
{

	int x;
	int y;
	int life=9;
	boolean isLive=true;
	public Bomb(Tank tank)
	{
		this.x=tank.getX();
		this.y=tank.getY();
		
	}
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive = false;
		}
	}

}

//Ӣ���� 
//��Ϣ:����,�ٶ�,�Ƿ���,����.�Ƿ�Ӣ��
//���캯��:����һ����ɫ,������,�����ṩ��Ϣ
//����:�ƶ�,����
class Hero extends Tank
{
	int speed = 5;
	int isHero=0;
	int maxBulletSize=5;
	public Hero(int x,int y,int direct)
	{
		super(x,y,direct);
	}
	public int getIsHero()
	{
		return isHero;
	}
	public int getMaxBulletSize() {
		return maxBulletSize;
	}
	public void setMaxBulletSize(int maxBulletSize) {
		this.maxBulletSize = maxBulletSize;
	}
}

//������ 
//��Ϣ:����,�ٶ�,�Ƿ���,����.�Ƿ�Ӣ��
//���캯��:����һ����ɫ,������,�����ṩ��Ϣ
//����:�ƶ�,����  �����Լ�����
class Enemy extends Tank
{
	int speed=3;
	int isHero=1;
	public Enemy(int x,int y,int direct)
	{
		super(x,y,direct);
	}
	public int getIsHero()
	{
		return isHero;
	}
}