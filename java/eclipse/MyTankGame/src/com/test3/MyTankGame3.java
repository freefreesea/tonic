/**
 * 功能:加深对事件处理机制的理解
 * 1.通过上下左右键,来控制一个小球的移动
 */
package com.test3;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
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
	
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	//定义一个炸弹集合
	
	
	int enSize=3;
	
	//三张图片才能组成一个炸弹
	Image image1;
	Image image2=null;
	Image image3=null;
	
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
		
		//初始化图片
		//image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("image4.jpg"));
		//image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("image2.jpg"));
		//image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("image3.jpg"));
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		//画出自己
		this.drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		
		
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot = hero.ss.get(i);
			
			//画出子弹,画出一颗子弹
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false)
			{
				//从ss中删除
				hero.ss.remove(myShot);
			}
		}
		
		//画出炸弹
		for(int i=0;i<bombs.size();i++)
		{
			//取出炸弹
			Bomb b=bombs.get(i);
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30, this);
			}
			else if(b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 30, 30, this);
			}
			else
			{
				g.drawImage(image3, b.x, b.y, 30, 30, this);
			}
			
			//让b的生命值减小
			b.lifeDowm();
			//如果炸弹生命值为0,就把该炸弹从bombs中去掉
			if(b.life==0)
			{
				bombs.remove(b);
			}
		}
	
		//画出敌人
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et = ets.get(i);
			
			if(et.isLive) {
			this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
			}
		}
	}

	
	//写一个函数专门判断子弹是否击中敌人坦克
	public void hitTank(Shot s,EnemyTank et)
	{
		//判断坦克的方向
		switch(et.direct)
		{
		//如果敌人坦克的方向是上或者下
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				s.isLive=false;
				et.isLive=false;
				//击中
				//创建一颗炸弹,放入Vector
				Bomb b=new Bomb(et.x, et.y);
				bombs.add(b);
			}
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				//击中
				//子弹死亡 敌人坦克死亡
				s.isLive=false;
				et.isLive=false;
				
				//copy
				Bomb b=new Bomb(et.x, et.y);
				bombs.add(b);
			}
			
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
			if(this.hero.ss.size()<=4)
			{
			this.hero.shotEnemy();
			}
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
			
			//判断是否击中
			for(int i=0;i<hero.ss.size();i++)
			{
				//取出子弹
				Shot myShot = hero.ss.get(i);
				//判断子弹是否有效
				if(myShot!=null &&myShot.isLive==true)
				{
					//取出每个坦克,判断
					for(int j=0;j<ets.size();j++)
					{
						//取出坦克
						EnemyTank et=ets.get(j);
						
						if(et.isLive)
						{
							this.hitTank(myShot, et);
						}
						
					}
				}
			}
			
			//重绘
			this.repaint();
		}
	}
}

