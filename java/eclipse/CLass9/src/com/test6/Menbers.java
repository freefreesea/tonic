package com.test6;

class Tank
{
	int x=0;//������

	int y=0;//������
	
	//̹�˷��� 0�� 1�� 2�� 3��
	int direct = 0;
	
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
}


//�ҵ�̹����
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x, y);
	}
}