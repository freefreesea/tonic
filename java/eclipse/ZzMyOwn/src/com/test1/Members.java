package com.test1;
import java.util.*;

//坦克类
//有坐标 速度 方向 子弹
//构造出来带五个参数
//有上下左右移动功能
//有开火功能 		开火功能:创建一个子弹对象放入集合 开启线程
class Tank   
{
	Vector<Bullet> vector = new Vector<Bullet>();
	Vector<Bullet> vector4 = new Vector<Bullet>();      
	Bullet bullet;
	//坐标 速度 方向 死活 
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
		//执行多遍函数 虽然名字一样 会产生多个
			bullet = new Bullet(this);
			vector.add(bullet);
			Thread thread = new Thread(bullet);
			thread.start();
			//System.out.println("我在fire里面");
	}
	
	public void enemyFire()
	{
		//执行多遍函数 虽然名字一样 会产生多个
			bullet = new Bullet(this);
			vector4.add(bullet);
			Thread thread = new Thread(bullet);
			thread.start();
			//System.out.println("我在fire里面");
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

//子弹类
//有坐标 速度 是谁的子弹 是否活着
//创建出来引用一个tank参数  自己的坐标 方向 速度
//有移动功能
class Bullet implements Runnable					
{
	Tank tank;
	int x;
	int y;
	int bulletSpeed = 1;
	boolean islive=true;
	int direct;
	

	//子弹打出来 (创建)就有了坐标
	public Bullet(Tank tank)
	{
		System.out.println("创建bullet");
		this.tank=tank;
		this.direct=tank.direct;
		switch(this.direct)
		{
		case 0:
			this.x=tank.x+10;
			this.y=tank.y;
			//System.out.println("创建一个"+x+"    "+y);
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
		System.out.println("运行了moveup");
		System.out.println("坐标是"+x+"   "+y);
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
			System.out.println("坐标x="+x+"  y="+y);
			
			//判断该子弹是否撞到边缘
			if(x<0||x>400||y<0||y>300)
			{
				this.islive=false;
				break;
			}
		}
	}
}

//炸弹类
//有坐标
//有爆炸功能
class Bomb
{
	int x;
	int y;
	//炸弹的生命
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
	//定义一个向量,可以存放敌人的子弹
	Vector<Bullet> ss= new Vector<Bullet>();
	//敌人添加子弹,应当在刚刚创建和子弹死亡后
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
			//膛坦克随机产生一个新的方向
			this.direct=(int)(Math.random()*4);
			
			//判断敌人坦克是否死亡
			if(this.isLive==false)
			{
				break;
			}
		
			
			this.fire();
		}
	}
	
}