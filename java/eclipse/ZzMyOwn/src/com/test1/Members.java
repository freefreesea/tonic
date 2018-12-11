package com.test1;
import java.util.*;

//̹����
//������ �ٶ� ���� �ӵ�
//����������������
//�����������ƶ�����
//�п����� 		������:����һ���ӵ�������뼯�� �����߳�
class Tank   
{
	Vector<Bullet> vector = new Vector<Bullet>();
	Vector<Bullet> vector4 = new Vector<Bullet>();      
	Bullet bullet;
	//���� �ٶ� ���� ���� 
	int x;
	int y;
	int isHero;
	int speed;
	int direct;
	boolean isLive;
	
	public Tank(int x,int y,int speed,int direct,boolean isLive)
	{
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.direct=direct;
		this.isLive=isLive;
	}
	
	public void fire()
	{
		//ִ�ж�麯�� ��Ȼ����һ�� ��������
			bullet = new Bullet(this);
			vector.add(bullet);
			Thread thread = new Thread(bullet);
			thread.start();
			//System.out.println("����fire����");
	}
	
	public void enemyFire()
	{
		//ִ�ж�麯�� ��Ȼ����һ�� ��������
			bullet = new Bullet(this);
			vector4.add(bullet);
			Thread thread = new Thread(bullet);
			thread.start();
			//System.out.println("����fire����");
	}
	
	public void moveUp()
	{
		y-=speed;
	}
	public void moveDown()
	{
		y+=speed;
	}
	public void moveLeft()
	{
		x-=speed;
	}
	public void moveRight()
	{
		x+=speed;
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
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getIsHero() {
		return isHero;
	}

	public void setIsHero(int isHero) {
		this.isHero = isHero;
	}
	
	
	
}

//�ӵ���
//������ �ٶ� ��˭���ӵ� �Ƿ����
//������������һ��tank����  �Լ������� ���� �ٶ�
//���ƶ�����
class Bullet implements Runnable					
{
	Tank tank;
	int x;
	int y;
	int bulletSpeed = 1;
	boolean islive=true;
	int direct;
	

	//�ӵ������ (����)����������
	public Bullet(Tank tank)
	{
		System.out.println("����bullet");
		this.tank=tank;
		this.direct=tank.direct;
		switch(this.direct)
		{
		case 0:
			this.x=tank.x+10;
			this.y=tank.y;
			//System.out.println("����һ��"+x+"    "+y);
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

	public void moveUp()
	{
		y-=bulletSpeed;
		System.out.println("������moveup");
		System.out.println("������"+x+"   "+y);
	}
	public void moveDown()
	{
		y+=bulletSpeed;
	}
	public void moveLeft()
	{
		x-=bulletSpeed;
	}
	public void moveRight()
	{
		x+=bulletSpeed;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			switch(this.direct)
			{
			case 0:
				moveUp();
				break;
			case 1:
				moveLeft();
				break;
			case 2:
				moveDown();
				break;
			case 3:
				moveRight();
				break;
			}
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.getStackTrace();
			}
			System.out.println("����x="+x+"  y="+y);
			
			//�жϸ��ӵ��Ƿ�ײ����Ե
			if(x<0||x>400||y<0||y>300)
			{
				this.islive=false;
				break;
			}
		}
	}
}

//ը����
//������
//�б�ը����
class Bomb
{
	int x;
	int y;
	//ը��������
	int life=9;
	boolean isLive = true;
	
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void lifeDown()
	{
		if(life>0)
		{
			life-=2;		
		}
		else
		{
			this.isLive=false;
		}
	}
}



class Hero extends Tank
{
	public int getIsHero()
	{
		return 1;
	}
	public Hero(int x,int y,int speed,int direct,boolean isLive)
	{
		super(x,y,speed,direct,isLive);
	}
}


class Enemy extends Tank implements Runnable
{
	//����һ������,���Դ�ŵ��˵��ӵ�
	Vector<Bullet> ss= new Vector<Bullet>();
	//��������ӵ�,Ӧ���ڸոմ������ӵ�������
	int speed = 3;
	public int getIsHero()
	{
		return 0;
	}
	public Enemy(int x, int y, int speed, int direct, boolean isLive)
	{
		super(x, y, speed, direct, isLive);
	}
	@Override
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			
			this.direct=(int)(Math.random()*4);
			switch(this.direct)
			{
			case 0:
				for (int i = 0; i < 30; i++) {
					if (y>0) {
						this.moveUp();
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						} 
					}
				}
				break;
			case 2:
				for (int i = 0; i < 30; i++) {
					if (y<230) {
						this.moveDown();
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						} 
					}
				}
				break;
			case 1:
				for (int i = 0; i < 30; i++) {
					if (x>0) {
						this.moveLeft();
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						} 
					}
				}
				break;
			case 3:
				for (int i = 0; i < 30; i++) {
					if (x<350) {
						this.moveRight();
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						} 
					}
				}
				break;
			}
			//��̹���������һ���µķ���
			this.direct=(int)(Math.random()*4);
			
			//�жϵ���̹���Ƿ�����
			if(this.isLive==false)
			{
				break;
			}
		
			
			this.fire();
		}
	}
	
}