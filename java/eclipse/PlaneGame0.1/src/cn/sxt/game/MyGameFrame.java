package cn.sxt.game;

import javax.swing.JFrame;
import java.awt.event.*;

/**
 * �ɻ���Ϸ��������
 * @author tonic
 *
 */

public class MyGameFrame extends JFrame{
	
	public void launchFrame() {
		this.setTitle("�ɻ���ս");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(550, 150);   //���Ͻ� ����
		
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
