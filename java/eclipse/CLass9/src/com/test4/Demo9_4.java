/**
 * 功能:加深对事件处理机制的理解
 * 1.通过上下左右键,来控制一个小球的移动
 */
package com.test4;
import java.awt.*;
import javax.swing.*;



import java.awt.event.*;

public class Demo9_4 extends JFrame{
	
	MyPanel mp;

	public static void main(String[] args) {
		Demo9_4 demo9_4 = new Demo9_4();
	}

	public Demo9_4()
	{
		mp=new MyPanel();
		
		this.add(mp);
		
		//按键属于JFrame的事件
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
}

class MyPanel extends JPanel implements KeyListener
{
	int speed=5;
	int x=10,y=10;
	Hero hero;
	
	/*public MyPanel()
	{
		//hero = new Hero(x,y);
	}*/
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(new Hero(x,y).getX(), new Hero(x,y).getY(), g, 0, 0);
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
			g.drawLine(x+10, y+15, x+10, y-2);
			break;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyChar()+"键被按下");
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

	@Override
	public void keyReleased(KeyEvent e) {
	/*	// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//System.out.println(12);
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			//System.out.println(12);
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			
		}*/
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()=="s")
		{
			y=y+speed;
			//调用repaint()函数,来重绘界面
		}	
		else if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			y=y-speed;
		}
		else if(e.getKeyChar()==KeyEvent.VK_LEFT)
		{
			x=x-speed;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x=x+speed;
		}
		this.repaint();
	}
}

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