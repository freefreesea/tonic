package cn.sxt.game;

import javax.swing.JFrame;
import java.awt.event.*;

/**
 * 飞机游戏的主窗口
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	public void launchFrame() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(550, 150);   //左上角 坐标
		
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
