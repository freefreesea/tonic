/**
 * 方向:0上1左2下3右
 * 1.画出4个tank
 * 2.hero可移动
 * 3.hero可以发射子弹
 * 4.子弹碰到墙壁会消失,碰到敌人 会爆炸消失
 * 5.我爆炸
 * 6.分关
 * 7.暂停 继续
 * 8.重叠不行
 * 9.成绩
 * 10.声音 
 */
package com.test4;
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
		Thread panelThread = new Thread(mp);
		panelThread.start();
		//******************************初始化区*****************************************
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	//******************************定义区*****************************************
	Hero hero1 ; 
	Vector<Enemy> enemys;
	Vector<Bomb> bombs;
	Bomb bomb;
	Enemy enemy;
	int enemySize = 3;
	ImageIcon image1;
	ImageIcon image2;
	ImageIcon image3;
	//******************************定义区*****************************************
	
	public MyPanel()
	{
		//******************************初始化区****************************************
		image1 = new ImageIcon("src/image4.jpg");
		image2 = new ImageIcon("src/image5.jpg");
		image3 = new ImageIcon("src/image6.jpg");
		hero1 = new Hero(200, 200, 0);
		enemys= new Vector<Enemy>();
		bombs = new Vector<Bomb>();
		//******************************初始化区****************************************
		for(int i=0;i<enemySize;i++)
		{
			enemy= new Enemy((i+1)*100, 0,1);
			enemys.add(enemy);
			Thread enemyThread = new Thread(enemy);
			enemyThread.start();
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero1, g);
		for(int i=0;i<enemys.size();i++)
		{
			if (enemys.get(i).isLive==true) {
				this.drawTank(enemys.get(i), g);
			}
			else
			{
				enemys.remove(i);
			}
		}
		this.hitJudge(g);
		this.drawBullet(g);
		this.drawBomb(g);
		

	}
	
	
	public void drawBomb(Graphics g)
	{
		for (int i = 0; i < bombs.size(); i++) {
			if (bombs.get(i).isLive==true) {
				Bomb bomb = bombs.get(i);
				if (bomb.life > 6) {
					bomb.lifeDown();
					g.drawImage(image1.getImage(), bomb.x, bomb.y, 30, 30, null);
				} else if (bomb.life > 3) {
					bomb.lifeDown();
					g.drawImage(image2.getImage(), bomb.x, bomb.y, 30, 30, null);
				} else if (bomb.life > 0) {
					bomb.lifeDown();
					g.drawImage(image3.getImage(), bomb.x, bomb.y, 30, 30, null);
				}
				if (bomb.life == 0) {
					bomb.isLive = false;
				} 
				
			} 
			else
			{
				bombs.remove(i);
			}
		}
	}
	
	/*public void clean()
	{
		for(int i=0;i<hero1.bullets.size();i++)
		{
			if(hero1.bullets.get(i).isLive==false)
			{
				hero1.bullets.remove(i);
			}
		}
		for(int i=0;i<enemys.size();i++)
		{
			if(enemys.get(i).isLive==false)
			{
				enemys.remove(i);
			}
		}
	}*/
	
	
	public void hitJudge(Graphics g)
	{
		for(int i=0;i<hero1.bullets.size();i++)
		{
			for(int j=0;j<enemys.size();j++)
			{
				Bullet bullet = hero1.bullets.get(i);
				Enemy enemy = enemys.get(j);
				switch(enemy.direct)
				{
				case 0:
				case 2:
					if(bullet.x>enemy.x&&bullet.x<enemy.x+20&&bullet.y>enemy.y&&bullet.y<enemy.y+30)
					{
						bullet.isLive=false;
						enemy.isLive=false;
						bomb = new Bomb(enemys.get(j));
						bombs.add(bomb);
						//hero1.bullets.remove(i);
						//enemys.remove(j);
					}
					break;
				case 1:
				case 3:
					if(bullet.x>enemy.x&&bullet.x<enemy.x+30&&bullet.y>enemy.y&&bullet.y<enemy.y+20)
					{
						bullet.isLive=false;
						enemy.isLive=false;
						bomb = new Bomb(enemys.get(j));
						bombs.add(bomb);
						//hero1.bullets.remove(i);
						//enemys.remove(j);
					}
					break;
				}
			}
		}
		
		for(int i=0;i<hero1.bullets.size();i++)
		{
			if(hero1.bullets.get(i).x<0||hero1.bullets.get(i).x>400||hero1.bullets.get(i).y<0||hero1.bullets.get(i).y>300)
			{
				hero1.bullets.get(i).isLive=false;
			}
		}
		
		for (int i = 0; i < enemys.size(); i++) {
			for (int j = 0; j < enemys.get(i).bullets.size(); j++) {
				Bullet bullet = enemys.get(i).bullets.get(j);
				switch (hero1.direct) {
				case 0:
				case 2:
					if (bullet.x > hero1.x && bullet.x < hero1.x + 20 && bullet.y > hero1.y
							&& bullet.y < hero1.y + 30) {
						bullet.isLive = false;
						hero1.isLive = false;
						bomb = new Bomb(hero1);
						bombs.add(bomb);
						//hero1.bullets.remove(i);
						//enemys.remove(j);
					}
					break;
				case 1:
				case 3:
					if (bullet.x > hero1.x && bullet.x < hero1.x + 30 && bullet.y > hero1.y
							&& bullet.y < hero1.y + 20) {
						bullet.isLive = false;
						hero1.isLive = false;
						bomb = new Bomb(hero1);
						bombs.add(bomb);
						//hero1.bullets.remove(i);
						//enemys.remove(j);
					}
					break;
				}
			} 
		}
	}
	
	public void drawBullet(Graphics g)
	{
		for(int i=0;i<this.hero1.bullets.size();i++)
		{
			if (this.hero1.bullets.get(i).isLive==true) {
				g.setColor(Color.WHITE);
				g.drawRect(this.hero1.bullets.get(i).x, this.hero1.bullets.get(i).y, 1, 1);
			}
			else
				this.hero1.bullets.remove(i);
		}
		for(int i=0;i<enemys.size();i++)
		{
			for (int j = 0; j < enemys.get(i).bullets.size(); j++) {
				if (enemys.get(i).bullets.get(j).isLive == true) {
					g.setColor(Color.WHITE);
					g.drawRect(enemys.get(i).bullets.get(j).x, enemys.get(i).bullets.get(j).y, 1, 1);
				} else
					enemys.get(i).bullets.remove(j);
			}
		}
	}
	//画坦克:执行后画出所有创建的坦克坦克
	public void drawTank(Tank tank,Graphics g)					//多态进来 取得都是父类的值 必须重写方法
	{
		if (tank.isLive()==true) {
			int x = tank.x;
			int y = tank.y;
			switch (tank.getIsHero()) {
			case 0:
				g.setColor(Color.YELLOW);
				break;
			case 1:
				g.setColor(Color.CYAN);
				break;
			}
			switch (tank.direct) {
			case 0:
				g.fill3DRect(x, y, 5, 30, false);
				g.fill3DRect(x + 15, y, 5, 30, false);
				g.fill3DRect(x + 5, y + 5, 10, 20, false);
				g.drawOval(x + 5, y + 10, 10, 10);
				g.drawLine(x + 10, y + 10, x + 10, y);
				break;
			case 1:
				g.fill3DRect(x, y, 30, 5, false);
				g.fill3DRect(x, y + 15, 30, 5, false);
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				g.drawOval(x + 10, y + 5, 10, 10);
				g.drawLine(x + 15, y + 10, x, y + 10);
				break;
			case 2:
				g.fill3DRect(x, y, 5, 30, false);
				g.fill3DRect(x + 15, y, 5, 30, false);
				g.fill3DRect(x + 5, y + 5, 10, 20, false);
				g.drawOval(x + 5, y + 10, 10, 10);
				g.drawLine(x + 10, y + 10, x + 10, y + 30);
				break;
			case 3:
				g.fill3DRect(x, y, 30, 5, false);
				g.fill3DRect(x, y + 15, 30, 5, false);
				g.fill3DRect(x + 5, y + 5, 20, 10, false);
				g.drawOval(x + 10, y + 5, 10, 10);
				g.drawLine(x + 15, y + 10, x + 30, y + 10);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (hero1.x>30&&hero1.y>30&&hero1.x<370&&hero1.y<270) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: {
				this.hero1.setDirect(0);
				hero1.y -= hero1.speed;
				break;
			}
			case KeyEvent.VK_LEFT: {
				this.hero1.setDirect(1);
				hero1.x -= hero1.speed;
				break;
			}
			case KeyEvent.VK_DOWN: {
				this.hero1.setDirect(2);
				hero1.y += hero1.speed;
				break;
			}
			case KeyEvent.VK_RIGHT: {
				this.hero1.setDirect(3);
				hero1.x += hero1.speed;
				break;
			}

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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			this.repaint();
			//this.clean();
			
		}
	}
	
}