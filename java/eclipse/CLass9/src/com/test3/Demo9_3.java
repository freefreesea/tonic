/**
 * ����:�����¼��������
 */
package com.test3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo9_3 extends JFrame implements ActionListener{

	JPanel mp=new JPanel();
	JButton jb1;
	JButton jb2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_3 demo9_3 =new Demo9_3();
	}
	public Demo9_3()
	{
		//mp=new JPanel();
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		mp.setBackground(Color.BLACK);
		
		this.add(mp);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		Cat MyCat1=new Cat();
		
		
		//ע�����
		jb1.addActionListener(this);
		jb1.addActionListener(MyCat1);
		//ָ��action����			�����ĸ���ť
		jb1.setActionCommand("��ɫ");
		jb2.addActionListener(this);
		jb2.addActionListener(MyCat1);
		jb2.setActionCommand("��ɫ");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//���¼�����ķ���
	public void actionPerformed(ActionEvent e) {
		//�ж����ĸ���ť�����
		if(e.getActionCommand().equals("��ɫ"))
		{
			mp.setBackground(Color.BLACK);
		}
		else
			mp.setBackground(Color.red);
	}
}

class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("ë֪����ɫ");
		}
		else
			System.out.println("ë֪����ɫ");
		
	}
	
}
/*class MyPanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, width, height);
	}
}*/