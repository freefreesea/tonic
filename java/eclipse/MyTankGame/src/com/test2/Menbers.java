package com.test2;







//�ӵ���
class Shot
{
	int x,y,direct;
	int speed=1;
	//�Ƿ񻹻���
	boolean isLive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
		

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
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
}



//�ҵ�̹����
class Hero extends Tank
{
	
	//�ӵ�
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
			break;
		case 1:
			s=new Shot(x+30, y+10,1);
			break;
		case 2:
			s=new Shot(x+10, y+30,2);
			break;
		case 3:
			s=new Shot(x, y+10,3);
			break;
			
		}
		//�����ӵ��߳�
	
	}
}