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
	
	Image plane=GameUtil.getImage("images/plane.png");
	
	
	public void paint(Graphics g) { //һֱ������ g�൱��һֱ����
		
		super.paint(g);
		Color c=g.getColor();
		Font f=g.getFont();
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("����",Font.BOLD,50));
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		g.setColor(Color.red);
		g.drawString("����˭?", 200, 200);
		g.setColor(c);
		g.drawImage(plane, 0, 200, null);
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
		
		}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
