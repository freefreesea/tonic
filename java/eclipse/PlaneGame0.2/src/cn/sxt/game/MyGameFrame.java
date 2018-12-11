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
	
	Image plane=GameUtil.getImage("images/plane.png");
	
	
	public void paint(Graphics g) { //一直被调用 g相当于一直画笔
		
		super.paint(g);
		Color c=g.getColor();
		Font f=g.getFont();
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体",Font.BOLD,50));
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		g.setColor(Color.red);
		g.drawString("我是谁?", 200, 200);
		g.setColor(c);
		g.drawImage(plane, 0, 200, null);
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
		
		}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
