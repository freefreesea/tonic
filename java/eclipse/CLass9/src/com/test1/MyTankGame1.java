/**
 * 哦功能:坦克游戏1.0
 * 1.画出坦克
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


//我的面板
class MyPanel extends JPanel
{
	
	//定义一下我的坦克
	Hero hero;
	
	//构造函数
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	
	//重写paint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
		
	}
	
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		//判断是什么类型的坦克
		switch(type)
		{
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.cyan);
			break;
		}
		
		//判断方向
		switch(direct)
		{
		case 0:
			//画出我的坦克(到时再封装成一个函数)
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2.画出右边矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5.画出线
			g.drawLine(x+10, y+15, x+10, y-2);
			break;
		}
	}
	
}

//坦克类
class Tank
{
	int x=0;//横坐标

	int y=0;//纵坐标
	
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


//我的坦克类
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x, y);
	}
}