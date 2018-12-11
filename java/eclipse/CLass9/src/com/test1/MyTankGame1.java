/**
 * Ŷ����:̹����Ϸ1.0
 * 1.����̹��
 */
package com.test1;
import java.awt.*;
import javax.swing.*;

public class MyTankGame1 extends JFrame{
	MyPanel mp;
	public static void main(String[] args) {
		MyTankGame1 mytankgame1=new MyTankGame1();
	}
	
	public MyTankGame1()
	{
		mp=new MyPanel();
		
		this.add(mp);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


//�ҵ����
class MyPanel extends JPanel
{
	
	//����һ���ҵ�̹��
	Hero hero;
	
	//���캯��
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	
	//��дpaint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
		
	}
	
	//����̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//�ж���ʲô���͵�̹��
		switch(type)
		{
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.cyan);
			break;
		}
		
		//�жϷ���
		switch(direct)
		{
		case 0:
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұ߾���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5.������
			g.drawLine(x+10, y+15, x+10, y-2);
			break;
		}
	}
	
}

//̹����
class Tank
{
	int x=0;//������

	int y=0;//������
	
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
}


//�ҵ�̹����
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x, y);
	}
}