package cn.sxt.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

/**
 * 飞机游戏的主窗口
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	Image bg=GameUtil.getImage(path)
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Plane plane2=new Plane(planeImg,350,250);
	Plane plane3=new Plane(planeImg,450,250);
	
	
	
	public void paint(Graphics g) { //自动被调用 g相当于一只画笔
				
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		plane2.drawSelf(g);
		plane3.drawSelf(g);
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
	
	
	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);   //左上角 坐标
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		
		new PaintThread().start(); //启动重画窗口的线程
		
		}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
