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
	
	Image bg=GameUtil.getImage("images/bg.png");
	Image plane=GameUtil.getImage("images/plane.png");
	
	int planeX=250,planeY=250;
	
	
	public void paint(Graphics g) { //�Զ������� g�൱��һֻ����
				
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane,planeX,planeY,null);
		planeY++;
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
