package com.basic;
import java.util.*;

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
	boolean isLive;
	
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
class Bullet
{
	int x;
	int y;
	int direct;
	
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
}


//英雄类 
//信息:坐标,速度,是否存活,方向.是否英雄
//构造函数:画出一个黄色,由坐标,方向提供信息
//功能:移动,开火
class Hero extends Tank
{
	int speed = 5;
	int isHero = 0;
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
}


//敌人类 
//信息:坐标,速度,是否存活,方向.是否英雄
//构造函数:画出一个蓝色,由坐标,方向提供信息
//功能:移动,开火  出生自己乱跑
class Enemy extends Tank
{
	int speed = 3;
	int isHero = 1;
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

}