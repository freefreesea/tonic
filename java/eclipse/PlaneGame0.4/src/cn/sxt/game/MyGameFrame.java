package cn.sxt.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

/**
 * �ɻ���Ϸ��������
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	Image bg=GameUtil.getImage(path)
	Image planeImg=GameUtil.getImage("images/plane.png");
	
	Plane plane=new Plane(planeImg,250,250);
	Plane plane2=new Plane(planeImg,350,250);
	Plane plane3=new Plane(planeImg,450,250);
	
	
	
	public void paint(Graphics g) { //�Զ������� g�൱��һֻ����
				
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		plane2.drawSelf(g);
		plane3.drawSelf(g);
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
	
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("�ɻ���ս");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);   //���Ͻ� ����
		
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		
		new PaintThread().start(); //�����ػ����ڵ��߳�
		
		}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
