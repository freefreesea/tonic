/**
 * ����:������¼�������Ƶ����
 * 1.ͨ���������Ҽ�,������һ��С����ƶ�
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
		
		//��������JFrame���¼�
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
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyChar()+"��������");
		/*if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			y=y+speed;
			//����repaint()����,���ػ����
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
			//����repaint()����,���ػ����
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