/**
 * ����:java��ͼԭ��
 */
package com.test1;

import java.awt.*;
import javax.swing.*;
public class Demo9_1 extends JFrame{

	MyPanel1 mp;
	public static void main(String[] args) {
		Demo9_1 a=new Demo9_1();

	}
	public Demo9_1()
	{
		mp = new MyPanel1();
		
		this.add(mp);
		this.setSize(300, 300);
		//this.setLocation(860, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}


//����һ��MyPanel(���Լ������,�����ڻ�ͼ��ʵ�ֻ��µ�����)
class MyPanel1 extends JPanel
{
	//����Jpanel��paint����
	//Graphics�ǻ�ͼ����Ҫ��,����԰�������һ֧����
	public void paint(Graphics g)  //�����ʾʱ���Զ�����paint   ��С���,���С,repaint���Զ�������
	{
		//1.���ø��ຯ����ɳ�ʼ��
		super.paint(g);//�����ٵ�    
		//System.out.println("sdasdasd");
		//g.setFont(Font.);
		//�Ȼ�һ��Բ
		//g.drawString("sdasd", 100, 100);
		
		//Image im=Toolkit.getDefaultToolkit().getImage("image/aaa.jpg");
		//g.drawImage(im, 90, 90, 320, 480, this);
		
	//	g.setColor(Color.BLUE);
	//	g.setFont(new Font("���Ĳ���",Font.BOLD,30));
	//	g.drawString("�������", 100, 100);
		g.drawArc(10, 10, 120, 300, 50, 100);
	}
}