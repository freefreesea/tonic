package com.test1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyTankGame extends JFrame{
	public static void main(String[] args) {
		MyTankGame myTankGame = new MyTankGame();
	}

	public MyTankGame()
	{
		MyPanel mp = new MyPanel();
		Thread thread2 = new Thread(mp);
		
		thread2.start();
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(400, 300);													
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	Hero hero1;
	Vector<Enemy> vector2 = new Vector<Enemy>(); //vector2��ʾ����̹�˼���
	Vector<Bomb> vector3 = new Vector<Bomb>();
	int enemySize=6; 			//����̹������
	
	ImageIcon image1=new ImageIcon("src/image4.jpg");
	ImageIcon image2=new ImageIcon("src/image5.jpg");
	ImageIcon image3=new ImageIcon("src/image6.jpg");
	
	//��������ͼƬ,����ͼƬ�������һ��ը��
	/*Image image1=null;
	Image image2=null;
	Image image3=null;*/
	
	public MyPanel()
	{
		hero1 = new Hero(200,200,5,0,true);	//����̹��
		
		//��ʼ������ͼƬ
		/*image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/image4.jpg"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/image5.jpg"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/image6.jpg"));*/
		
		for(int i=0;i<enemySize;i++)
		{
			Enemy enemy = new Enemy((i+1)*50, 0, 5, 2, true);
			enemy.setIsHero(0);
			vector2.add(enemy);
			Thread thread = new Thread(enemy);
			thread.start();
			//������̹�����һ���ӵ�
			Bullet s=new Bullet(enemy);
			enemy.ss.add(s);
			Thread t2= new Thread(s);
			t2.start();
		}
		

	}

	
	//****************************************************************************************************************
	//****************************************************************************************************************
	public void paint(Graphics g)
	{
		System.out.println(1);
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		this.drawtank(hero1, g);								//Ȼ�����⻭����  ������
		
		//������̹��
		for(int i=0;i<vector2.size();i++)				//���� enemysize
		{
			if(vector2.get(i).isLive==true)
			{
				this.drawtank(vector2.get(i), g);
			}
			if(vector2.get(i).isLive==false)
			{
				//vector2.remove(i);
			}
		}
		this.drawBullet(g);
	
		
		for(int i=0;i<hero1.vector.size();i++)
		{
			for(int j=0;j<vector2.size();j++)
			{
				this.hit( hero1.vector.get(i),vector2.get(j));
			}
		}
		
		this.drawBomb(g);
	/*	for(int i=0;i<hero1.vector.size();i++)
		{
			Bullet myShot = hero1.vector.get(i);
			if(myShot.islive==true)
			{
				for(int j=0;j<vector2.size();j++)
				{
					Enemy et= vector2.get(j);
					if(et.isLive)
					{
						this.hit(myShot, et);
					}

				}
			}
		
		}*/
	}
	//****************************************************************************************************************
	//****************************************************************************************************************
	
	
	public void drawtank(Tank tank,Graphics g)
	
	{
		switch(tank.getIsHero())
		{
		case 1:
			g.setColor(Color.YELLOW);
			break;
		case 0:
			g.setColor(Color.CYAN);
			break;
		}
		switch(tank.direct)
		{
		case 0:    
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(tank.getX(), tank.getY(), 5, 30,false);
			//2.�����ұ߾���
			g.fill3DRect(tank.getX()+15, tank.getY(), 5, 30,false);
			//3.�����м����
			g.fill3DRect(tank.getX()+5, tank.getY()+5, 10, 20,false);
			//4.����Բ��
			g.fillOval(tank.getX()+5, tank.getY()+10, 10, 10);
			//5.������
			g.drawLine(tank.getX()+10, tank.getY()+15, tank.getX()+10, tank.getY());
			break;
		case 3:
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(tank.getX(), tank.getY(), 30, 5,false);
			//2.�����ұ߾���
			g.fill3DRect(tank.getX(), tank.getY()+15, 30, 5,false);
			//3.�����м����
			g.fill3DRect(tank.getX()+5, tank.getY()+5, 20, 10,false);
			//4.����Բ��
			g.fillOval(tank.getX()+10, tank.getY()+5,10 , 10);
			//5.������
			g.drawLine(tank.getX()+15, tank.getY()+10, tank.getX()+30, tank.getY()+10);
			break;
		case 2:
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(tank.getX(), tank.getY(), 5, 30,false);
			//2.�����ұ߾���
			g.fill3DRect(tank.getX()+15, tank.getY(), 5, 30,false);
			//3.�����м����
			g.fill3DRect(tank.getX()+5, tank.getY()+5, 10, 20,false);
			//4.����Բ��
			g.fillOval(tank.getX()+5, tank.getY()+10, 10, 10);
			//5.������
			g.drawLine(tank.getX()+10, tank.getY()+15, tank.getX()+10, tank.getY()+30);
			break;
		case 1:
			//�����ҵ�̹��(��ʱ�ٷ�װ��һ������)
			//1.������ߵľ���
			g.fill3DRect(tank.getX(), tank.getY(), 30, 5,false);
			//2.�����ұ߾���
			g.fill3DRect(tank.getX(), tank.getY()+15, 30, 5,false);
			//3.�����м����
			g.fill3DRect(tank.getX()+5, tank.getY()+5, 20, 10,false);
			//4.����Բ��
			g.fillOval(tank.getX()+10, tank.getY()+5,10 , 10);
			//5.������
			g.drawLine(tank.getX()+15, tank.getY()+10, tank.getX(), tank.getY()+10);
			break;
		}
	
	}

	//�ж��ӵ��Ƿ���е���
	public void hit(Bullet bullet,Enemy enemy)
	{
		switch(enemy.direct)
		{
		case 0:
		case 2:
			if(bullet.x>enemy.getX()&&bullet.x<enemy.x+20&&bullet.y>enemy.getY()&&bullet.y<enemy.getY()+30)
			{
				//����
				bullet.islive=false;
				enemy.isLive=false;
				//����һ��ը��
				Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
				vector3.add(bomb);
			}
			
			break;
		case 1:
		case 3:
			if(bullet.x>enemy.getX()&&bullet.x<enemy.x+30&&bullet.y>enemy.getY()&&bullet.y<enemy.getY()+20)
			{
				//����
				bullet.islive=false;
				enemy.isLive=false;
				Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
				vector3.add(bomb);
			}
			
			break;
		}
	}
	
	public void drawBomb(Graphics g)
	{
		for(int i=0;i<vector3.size();i++)
		{
			if(vector3.get(i).isLive==true)
			{
				Bomb bomb = vector3.get(i);
				if(bomb.life>6)
				{
					g.drawImage(image1.getImage(), bomb.x,bomb.y,30,30,null);
				}
				else if(bomb.life>3)
				{
					g.drawImage(image2.getImage(), bomb.x,bomb.y,30,30,null);
				}
				else
				{
					g.drawImage(image3.getImage(), bomb.x,bomb.y,30,30,null);
				}
				bomb.lifeDown();
			}
			if(vector3.get(i).isLive==false)
			{
				vector3.remove(i);
			}
		}
	}
	
	
	public void drawBullet(Graphics g)   
	{
		for(int i=0;i<this.hero1.vector.size();i++)
		{
			System.out.println("�ӵ�����");
			if(this.hero1.vector.get(i)!=null&&this.hero1.vector.get(i).islive==true)
			{
				switch(this.hero1.vector.get(i).direct)
				{
				case 0:
					g.draw3DRect(this.hero1.vector.get(i).x, this.hero1.vector.get(i).y, 1, 1, false);
					break;
				case 2:
					g.draw3DRect(this.hero1.vector.get(i).x, this.hero1.vector.get(i).y, 1, 1, false);
					break;
				case 1:
					g.draw3DRect(this.hero1.vector.get(i).x, this.hero1.vector.get(i).y, 1, 1, false);
					break;
				case 3:
					g.draw3DRect(this.hero1.vector.get(i).x, this.hero1.vector.get(i).y, 1, 1, false);
					break;
				}
			}
			if(this.hero1.vector.get(i).islive==false)
			{
				//�ӵ�������
				this.hero1.vector.remove(i);   //Ϊʲô������i?
			}
			
		}
		for (int j = 0; j < this.vector2.size(); j++) {
			for (int i = 0; i < this.vector2.get(j).vector4.size(); i++) {
				if (this.vector2.get(j).vector4.get(i) != null && this.vector2.get(j).vector4.get(i).islive == true) {
					switch (this.vector2.get(j).vector4.get(i).direct) {
					case 0:
						g.draw3DRect(this.vector2.get(j).vector4.get(i).x, this.vector2.get(j).vector4.get(i).y, 1, 1, false);
						break;
					case 2:
						g.draw3DRect(this.vector2.get(j).vector4.get(i).x, this.vector2.get(j).vector4.get(i).y, 1, 1, false);
						break;
					case 1:
						g.draw3DRect(this.vector2.get(j).vector4.get(i).x, this.vector2.get(j).vector4.get(i).y, 1, 1, false);
						break;
					case 3:
						g.draw3DRect(this.vector2.get(j).vector4.get(i).x, this.vector2.get(j).vector4.get(i).y, 1, 1, false);
						break;
					}
				}
				if (this.hero1.vector.get(i).islive == false) {
					//�ӵ�������
					this.hero1.vector.remove(i); //Ϊʲô������i?
				}

			} 
		}
	}
	
	
	//�ƶ����***********************************************************************************
	//��������� ��������ı�,̹�������ƶ�
	//j������ ����������
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			this.hero1.setDirect(0);
			this.hero1.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			this.hero1.setDirect(2);
			this.hero1.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			this.hero1.setDirect(1);
			this.hero1.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.hero1.setDirect(3);
			this.hero1.moveRight();
			break;
		}
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			if(this.hero1.vector.size()<=4)
			{
				this.hero1.fire();
				System.out.println("����fire");
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
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			this.repaint();
		}
	}
}