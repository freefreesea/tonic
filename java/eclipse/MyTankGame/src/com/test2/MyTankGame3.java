/**
 * 功能:加深对事件处理机制的理解
 * 1.通过上下左右键,来控制一个小球的移动
 */
package com.test2;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import java.util.*;



import java.awt.event.*;

public class MyTankGame3 extends JFrame{
	
	MyPanel mp;

	public static void main(String[] args) {
		MyTankGame3 demo9_4 = new MyTankGame3();
	}

	public MyTankGame3()
	{
		mp=new MyPanel();
		 //启动mp线程
		Thread t=new Thread(mp);
		t.start();
		this.add(mp);
		
		//按键属于JFrame的事件
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	
	int speed=5;
	Hero hero;
	Vector<EnemyTank> ets=new Vector<EnemyTank>(); 
	
	int enSize=3;
	public MyPanel()
	{
		hero = new Hero(100,100);
		
		//定义敌人的坦克组
		for(int i=0;i<enSize;i++)
		{
			//创建一辆敌人的坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(2);
			ets.add(et);
		}
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		//画出自己
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		
		//画出子弹
		if(hero.s!=null&&hero.s.isLive==true)
		{
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		//画出敌人
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
		}
	}

	
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
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			//画出我的坦克(到时再封装成一个函数)
			//1.画出左边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2.画出右边矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.画出圆形
			g.fillOval(x+10, y+5,10 , 10);
			//5.画出线
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
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
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 3:
			//画出我的坦克(到时再封装成一个函数)
			//1.画出左边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2.画出右边矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.画出圆形
			g.fillOval(x+10, y+5,10 , 10);
			//5.画出线
			g.drawLine(x+15, y+10, x, y+10);
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			//设置我的坦克的方向
			hero.setDirect(0);
			hero.setY(hero.getY()-speed);
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			this.hero.setDirect(2);
			hero.setY(hero.getY()+speed);
		}
		else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			this.hero.setDirect(3);
			hero.setX(hero.getX()-speed);
		}
		else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			this.hero.setDirect(1);
			hero.setX(hero.getX()+speed);
		}
		/*else if(e.getKeyCode()==KeyEvent.VK_J)
		{
			//同时按键的时候 会出bug
		}*/
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			//开火
			this.hero.shotEnemy();
		}
		
		
		this.repaint();
		
		
		/*if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			y=y+speed;
			//调用repaint()函数,来重绘界面
		}	
		else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			y=y-speed;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x=x-speed;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x=x+speed;
		}
		this.repaint();*/
	}


	public void keyReleased(KeyEvent e) {

	}


	public void keyTyped(KeyEvent e) {
	
	}
	public void run() {
		// TODO Auto-generated method stub
		//每隔100毫秒去重绘
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
			}
			//重绘
			this.repaint();
		}
	}
}

