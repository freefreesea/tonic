package cn.sxt.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

/**
 * �ɻ���Ϸ��������
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	Image bg=GameUtil.getImage("images/bg.png");
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Shell[] shells=new Shell[50];

	
	
	public void paint(Graphics g) { //�Զ������� g�൱��һֻ����
				
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		
		
	
		for(int i=0;i<50;i++) {
			shells[i].draw(g);
			boolean peng=shells[i].getRect().intersects(plane.getRect());
			
		if(peng) {
			plane.live=false;
		}
	
		}
		
	}
	
	
	//�������Ƿ������ػ�����
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				
				repaint();
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//������̼���
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
		
	}
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("�ɻ���ս");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);   //���Ͻ� ����
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		
		new PaintThread().start(); //�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());      //���Ӽ��̵ļ���
		
		for(int i=0;i<50;i++) {
			shells[i]=new Shell();
		}
		}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	
	private Image offScreenImage=null;
	
	public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
