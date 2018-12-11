/**
 * ����:0��1��2��3��
 * 1.����4��tank
 * 2.hero���ƶ�
 * 3.hero���Է����ӵ�
 * 4.�ӵ�����ǽ�ڻ���ʧ,�������� �ᱬը��ʧ
 */



package com.test2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame extends JFrame{
	//******************************������*****************************************
	MyPanel mp;
	Thread panelThread;
	//******************************������*****************************************
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame mtg=new MyTankGame();

	}
	
	public MyTankGame()
	{
		//******************************��ʼ����*****************************************
		mp = new MyPanel();
		panelThread = new Thread(mp);
		panelThread.start();
		//******************************��ʼ����*****************************************
		
		this.add(mp);
		this.addKeyListener(mp);
		mp.setBackground(Color.BLACK);
		this.setSize(400,300);
		this.setLocation(100, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	//******************************������*****************************************
	Hero hero1;
	Vector<Enemy> enemys;
	Vector<Bomb> bombs;
	Enemy enemy;
	int enemySize=3;
	ImageIcon image1= new ImageIcon("src/image4.jpg");
	ImageIcon image2= new ImageIcon("src/image5.jpg");
	ImageIcon image3= new ImageIcon("src/image6.jpg");
	
	//******************************������*****************************************
	public MyPanel()
	{
	//******************************��ʼ����****************************************	
		enemys= new Vector<Enemy>();
		bombs= new Vector<Bomb>();
		for(int i=0;i<enemySize;i++)
		{
			enemy = new Enemy((i+1)*100, 0, 2);
			enemys.add(enemy);
		}
		hero1=new Hero(200, 200, 0);
	//******************************��ʼ����****************************************
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		this.drawTank(hero1, g);
		for(int i=0;i<enemys.size();i++)
		{
			if (enemys.get(i).isLIve) {
				this.drawTank(enemys.get(i), g);
			}
			else if(enemys.get(i).isLIve==false)
			{
				enemys.remove(i);
			}
		}
		this.drawBullet(g);
		hero1.hitWall();
		for(int i=0;i<hero1.bullets.size();i++)
		{
			for(int j=0;j<enemys.size();j++)
			{
				this.hit(hero1.bullets.get(i), enemys.get(j));
			}
		}
		this.drawBomb(g);
		
	}
	
	
	public void hit(Bullet bullet,Enemy enemy)
	{
		switch(enemy.direct)
		{
		case 0:
		case 2:
		{
			if(bullet.x>enemy.x&&bullet.x<enemy.x+20&&bullet.y>enemy.y&&bullet.y<enemy.y+30)
			{
				bullet.isLive=false;
				enemy.isLIve=false;
				Bomb bomb = new Bomb(enemy);
				bombs.add(bomb);
			}
			break;
		}
		case 1:
		case 3:
		{
			if(bullet.x>enemy.x&&bullet.x<enemy.x+30&&bullet.y>enemy.y&&bullet.y<enemy.y+20)
			{
				bullet.isLive=false;
				enemy.isLIve=false;
				Bomb bomb = new Bomb(enemy);
				bombs.add(bomb);
			}
		}
		
		}
	}
	
	
	//��̹��:ִ�к󻭳����д�����̹��̹��
	public void drawTank(Tank tank,Graphics g)			//��̬���� ȡ�ö��Ǹ����ֵ ������д����
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

	public void drawBullet(Graphics g)
	{
		for(int i=0;i<hero1.bullets.size();i++)
		{
			Bullet bullet = hero1.bullets.get(i);
			if (bullet.isLive==true) {
				
				g.setColor(Color.RED);
				g.drawRect(bullet.x, bullet.y, 1, 1);
			}
		}
	}
	
	public void drawBomb(Graphics g)
	{
		for(int i = 0;i<bombs.size();i++)
		{
			if(bombs.get(i).isLive==true)
			{
				if(bombs.get(i).life>6)
				{
					g.drawImage(image1.getImage(), bombs.get(i).x, bombs.get(i).y, 30, 30, null);
				}
				else if(bombs.get(i).life>3)
				{
					g.drawImage(image2.getImage(), bombs.get(i).x, bombs.get(i).y, 30, 30, null);
				}
				else if(bombs.get(i).life>0)
				{
					g.drawImage(image3.getImage(), bombs.get(i).x, bombs.get(i).y, 30, 30, null);
				}
				bombs.get(i).lifeDown();
			}
			if(bombs.get(i).isLive==false)
			{
				bombs.remove(i);
			}
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode())
		{
		case KeyEvent.VK_UP:
			{
				hero1.setDirect(0);
				hero1.y-=hero1.speed;
				break;
			}
		case KeyEvent.VK_LEFT:
			{
				hero1.setDirect(1);
				hero1.x-=hero1.speed;
				break;
			}
		case KeyEvent.VK_DOWN:
			{
				hero1.setDirect(2);
				hero1.y+=hero1.speed;
				break;
			}
		case KeyEvent.VK_RIGHT:
			{
				hero1.setDirect(3);
				hero1.x+=hero1.speed;
				break;
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			if (hero1.bullets.size()<hero1.getMaxBulletSize()) {
				hero1.fire();
			}
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			/*for(int i=0;i<hero1.bullets.size();i++)
			{
				int x=hero1.bullets.get(i).x;
				int y=hero1.bullets.get(i).y;
				for(int j=0;j<enemys.size();j++)
				{
					switch(enemys.get(j).direct)
					{
					case 0:
					case 2:
						if(x>enemys.get(j).x&&x<enemys.get(j).x+20&&y>enemys.get(j).y&&y<enemys.get(j).y+30)
						{
							
						}
					}
				}
			}*/
			this.repaint();
		}
	}
}


