/**
 * 方向:0上1左2下3右
 * 1.画出4个tank
 * 2.hero可移动
 * 3.hero可以发射子弹
 * 4.子弹碰到墙壁会消失,碰到敌人 会爆炸消失
 */
package com.basic;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame extends JFrame{
	public static void main(String[] args) {
		MyTankGame mtg = new MyTankGame();
	}
	//******************************定义区*****************************************	
	MyPanel mp;
	//******************************定义区*****************************************
	public MyTankGame()
	{
		//******************************初始化区*****************************************
		mp= new MyPanel();
		//******************************初始化区*****************************************
		mp.setBackground(Color.BLACK);
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}

class MyPanel extends JPanel implements KeyListener
{
	//******************************定义区*****************************************
	Hero hero1 ; 
	Vector<Enemy> enemys;
	Enemy enemy;
	int enemySize = 3;
	//******************************定义区*****************************************
	
	public MyPanel()
	{
		//******************************初始化区****************************************
		hero1 = new Hero(200, 200, 0);
		enemys= new Vector<Enemy>();
		//******************************初始化区****************************************
		for(int i=0;i<enemySize;i++)
		{
			enemy= new Enemy((i+1)*100, 0, 2);
			enemys.add(enemy);
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		this.drawTank(hero1, g);
		for(int i=0;i<enemySize;i++)
		{
			this.drawTank(enemys.get(i), g);
		}
		this.drawBullet(g);
	}
	
	
	public void drawBullet(Graphics g)
	{
		for(int i=0;i<this.hero1.bullets.size();i++)
		{
			g.setColor(Color.WHITE);
			g.drawRect(this.hero1.bullets.get(i).x, this.hero1.bullets.get(i).y, 1, 1);
		}
	}
	//画坦克:执行后画出所有创建的坦克坦克
	public void drawTank(Tank tank,Graphics g)					//多态进来 取得都是父类的值 必须重写方法
	{
		int x=tank.x;
		int y=tank.y;
		switch(tank.getIsHero())
		{
		case 0:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.CYAN);
			break;
		}
		
		switch(tank.direct)
		{
		case 0:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 10, 10);
			g.drawLine(x+10,y+10, x+10,y);
			break;
		case 1:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.drawOval(x+10, y+5, 10, 10);
			g.drawLine(x+15,y+10, x,y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 10, 10);
			g.drawLine(x+10,y+10, x+10,y+30);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5, false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.drawOval(x+10, y+5, 10, 10);
			g.drawLine(x+15,y+10, x+30,y+10);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			{
				this.hero1.setDirect(0);
				hero1.y-=hero1.speed;
				break;
			}
		case KeyEvent.VK_LEFT:
			{
				this.hero1.setDirect(1);
				hero1.x-=hero1.speed;
				break;
			}
		case KeyEvent.VK_DOWN:
			{
				this.hero1.setDirect(2);
				hero1.y+=hero1.speed;
				break;
			}
		case KeyEvent.VK_RIGHT:
			{
				this.hero1.setDirect(3);
				hero1.x+=hero1.speed;
				break;
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			if (hero1.bullets.size()<5) {
				this.hero1.fire();
			}
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}