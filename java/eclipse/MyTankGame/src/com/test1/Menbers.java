package com.test1;

class Tank
{
	int x=0;//横坐标

	int y=0;//纵坐标
	
	//坦克方向 0上 1右 2下 3左
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
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}



//我的坦克类
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x, y);
	}
}