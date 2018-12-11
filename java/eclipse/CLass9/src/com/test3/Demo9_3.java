/**
 * 功能:讲解事件处理机制
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
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		mp.setBackground(Color.BLACK);
		
		this.add(mp);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		Cat MyCat1=new Cat();
		
		
		//注册监听
		jb1.addActionListener(this);
		jb1.addActionListener(MyCat1);
		//指定action命令			区别哪个按钮
		jb1.setActionCommand("黑色");
		jb2.addActionListener(this);
		jb2.addActionListener(MyCat1);
		jb2.setActionCommand("红色");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//对事件处理的方法
	public void actionPerformed(ActionEvent e) {
		//判断是哪个按钮被点击
		if(e.getActionCommand().equals("黑色"))
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
		if(e.getActionCommand().equals("黑色"))
		{
			System.out.println("毛知道黑色");
		}
		else
			System.out.println("毛知道红色");
		
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