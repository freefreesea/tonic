package cn.sxt.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

/**
 * 飞机游戏的主窗口
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	Image bg=GameUtil.getImage("images/bg.png");
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Shell[] shells=new Shell[50];

	
	
	public void paint(Graphics g) { //自动被调用 g相当于一只画笔
				
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
	
	
	//帮助我们反复的重画窗口
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
	
	//定义键盘监听
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
	 * 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);   //左上角 坐标
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		
		new PaintThread().start(); //启动重画窗口的线程
		addKeyListener(new KeyMonitor());      //增加键盘的监听
		
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
