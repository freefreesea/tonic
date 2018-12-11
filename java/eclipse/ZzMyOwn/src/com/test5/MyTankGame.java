/**
 * ����:0��1��2��3��
 * 1.����4��tank
 * 2.hero���ƶ�
 * 3.hero���Է����ӵ�
 * 4.�ӵ�����ǽ�ڻ���ʧ,�������� �ᱬը��ʧ
 * 5.�ұ�ը
 * 6.�ֹ�
 * 	6.1��һ����panel
 * 	6.2��˸
 * 7.��ͣ ����
 * 8.�ص�����
 * 9.�ɼ�
 * 	9.1�ļ���
 * 	9.2��дһ����¼��,��ɶ���ҵļ�¼
 * 10.���� 
 */
package com.test5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame extends JFrame implements ActionListener{
	public static void main(String[] args) {
		MyTankGame mtg = new MyTankGame();
	}
	//******************************������*****************************************	
	MyPanel mp;
	MyStartPanel msp;
	//�˵�
	JMenuBar jmb=null;
	//��ʼ��Ϸ
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//******************************������*****************************************
	public MyTankGame()
	{
		//******************************��ʼ����*****************************************
//		mp= new MyPanel();
//		Thread panelThread = new Thread(mp);
//		panelThread.start();
		//�����˵�
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ����Ϸ(N)");
		//��jmi1������Ӧ
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jm1.add(jmi1);
		jmb.add(jm1);
		this.setJMenuBar(jmb);
//		//******************************��ʼ����*****************************************
//		this.add(mp);
//		this.addKeyListener(mp);
		msp = new MyStartPanel();
		Thread t=new Thread(msp);
		t.start();
		this.add(msp);
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//���û���ͬ�ĵ��������ͬ�Ĵ���
		if(arg0.getActionCommand().equals("newgame"))
		{
			mp= new MyPanel();
			Thread panelThread = new Thread(mp);
			panelThread.start();
			//��ɾ���ɵ����
			this.remove(msp);
			this.add(mp);
			this.addKeyListener(mp);
			//��ʾ,ˢ��JFrame
			this.setVisible(true);
		}
	}

}

class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		if (times%2==0) {
			g.setColor(Color.YELLOW);
			g.setFont(new Font("������κ", Font.BOLD, 30));
			g.drawString("stage 1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//����
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			times++;
			this.repaint();
		}
	}
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	//******************************������*****************************************
	Hero hero1 ; 
	Vector<Enemy> enemys;
	Vector<Bomb> bombs;
	Bomb bomb;
	Enemy enemy;
	int enemySize = 5;
	ImageIcon image1;
	ImageIcon image2;
	ImageIcon image3;
	//******************************������*****************************************
	
	public MyPanel()
	{
		//******************************��ʼ����****************************************
		image1 = new ImageIcon("src/image4.jpg");
		image2 = new ImageIcon("src/image5.jpg");
		image3 = new ImageIcon("src/image6.jpg");
		hero1 = new Hero(200, 200, 0);
		enemys= new Vector<Enemy>();
		bombs = new Vector<Bomb>();
		//******************************��ʼ����****************************************
		for(int i=0;i<enemySize;i++)
		{
			enemy= new Enemy((i+1)*30, 0,0);
			//��MyPanel�ĵ���tank�����õ���tank
			enemy.setEts(enemys);
			enemys.add(enemy);
			Thread enemyThread = new Thread(enemy);
			enemyThread.start();
		}
	}
	
	//������ʾ��Ϣ
	public void showInfo(Graphics g)
	{
		//������ʾ��Ϣtank(���μ�ս��)
				this.drawTank(new Enemy(80, 330,0),g);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getEnNum()+"", 110, 350);
				
				this.drawTank(new Hero(130, 330,0),g);
				g.setColor(Color.BLACK);
				g.drawString(Recorder.getMyLife()+"", 160, 350);
			
		//������ҵĳɼ�
				g.setColor(Color.black);
				g.setFont(new Font("����",Font.BOLD,20));
				g.drawString("�ܳɼ�", 420, 30);
				this.drawTank(new Enemy(420,60,0),g);
				g.setColor(Color.black);
				g.drawString(Recorder.getAllEnNum()+"",460 , 80);
				
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.showInfo(g);
		
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
						Recorder.reduceEnNum();
						Recorder.addEnNum();
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
						Recorder.reduceEnNum();
						Recorder.addEnNum();
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
	//��̹��:ִ�к󻭳����д�����̹��̹��
	public void drawTank(Tank tank,Graphics g)					//��̬���� ȡ�ö��Ǹ����ֵ ������д����
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