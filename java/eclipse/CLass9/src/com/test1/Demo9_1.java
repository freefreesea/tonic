/**
 * 功能:java绘图原理
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


//定义一个MyPanel(我自己的面板,适用于绘图和实现会吐的区域)
class MyPanel1 extends JPanel
{
	//覆盖Jpanel的paint方法
	//Graphics是绘图的重要类,你可以把它理解成一支画笔
	public void paint(Graphics g)  //组件显示时会自动调用paint   最小最大化,变大小,repaint会自动被调用
	{
		//1.调用父类函数完成初始化
		super.paint(g);//不能少的    
		//System.out.println("sdasdasd");
		//g.setFont(Font.);
		//先画一个圆
		//g.drawString("sdasd", 100, 100);
		
		//Image im=Toolkit.getDefaultToolkit().getImage("image/aaa.jpg");
		//g.drawImage(im, 90, 90, 320, 480, this);
		
	//	g.setColor(Color.BLUE);
	//	g.setFont(new Font("华文彩云",Font.BOLD,30));
	//	g.drawString("祖国万岁", 100, 100);
		g.drawArc(10, 10, 120, 300, 50, 100);
	}
}