package com.test5;
import java.util.*;


//记录类,同时可以保存玩家的设置
class Recorder
{
	//记录每关有多少敌人
	private static int enNum=20;
	//设置我有多少可以用的人
	private static int myLife=3;
	//记录总共消灭了多少敌人
	private static int allEnNum=0;
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	//减少敌人
	public static void reduceEnNum()
	{
		enNum--;
	}
	//消灭敌人
	public static void addEnNum()
	{
		allEnNum++;
	}
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
}


//坦克类 
//信息:坐标,速度,是否存活,方向,是否英雄
//构造函数:画出一个坦克,由坐标,方向提供信息
//功能:移动,开火
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


//子弹类 
//信息:坐标,速度,是否存活,方向
//构造函数:画出一个子弹,由坐标,方向提供信息
//功能:移动,击中判定
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


//英雄类 
//信息:坐标,速度,是否存活,方向.是否英雄
//构造函数:画出一个黄色,由坐标,方向提供信息
//功能:移动,开火
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


//敌人类 
//信息:坐标,速度,是否存活,方向.是否英雄
//构造函数:画出一个蓝色,由坐标,方向提供信息
//功能:移动,开火  出生自己乱跑
class Enemy extends Tank implements Runnable
{
	int speed = 3;
	int isHero = 1;
	boolean isLive=true;
	
	
	//定义一个向量,可以访问到MyPanel上所有敌人的tank
	Vector<Enemy> ets=new Vector<Enemy>();
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
	
	//得到MyPanel的敌人tank向量
	public void setEts(Vector<Enemy> vv)
	{
		this.ets=vv;
	}
	
	//判断是否碰到了别的tank
	public boolean isTouchOtherEnemy()
	{
		boolean b=false;
		System.out.println(this.getDirect());
		switch(this.direct)
		{
		case 0:
			//取出所有的敌人tank
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个tank
				Enemy et=ets.get(i);
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 1:
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个tank
				Enemy et=ets.get(i);
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 2:
			for(int i=0;i<ets.size();i++)
			{
				//取出第一个tank
				Enemy et=ets.get(i);
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 3:
			for(int i=0;i<ets.size();i++)
			{
				//System.out.println(1);
				//取出第一个tank
				Enemy et=ets.get(i);
				if(et!=this)
				{
					//System.out.println(et.getDirect());
					if(et.direct==0||et.direct==2)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+20>=et.y&&this.y+20<=et.y+30)
						{
							return true;
						}
					}
					if(et.direct==3||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		}
		return b;
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
						if (!this.isTouchOtherEnemy()) {
							try {
								Thread.sleep(50);
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							y -= speed;
						}
					} 
				}
				break;
			case 1:
				if (x>20) {
					for (int i = 0; i < 30; i++) {
						if (!this.isTouchOtherEnemy()) {
							try {
								Thread.sleep(50);
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							x -= speed;
						}
					} 
				}
				break;
			case 2:
				if (y<220) {
					for (int i = 0; i < 30; i++) {
						if (!this.isTouchOtherEnemy()) {
							try {
								Thread.sleep(50);
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							y += speed;
						}
					} 
				}
				break;
			case 3:
				if (x<310) {
					for (int i = 0; i < 30; i++) {
						if (!this.isTouchOtherEnemy()) {
							try {
								Thread.sleep(50);
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
							x += speed;
						}
					} 
				}
				break;
				
			}
			this.fire();
		}
	}

}