package com.test5;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Demo9_5 extends JFrame{
	MyPanel mp;
	
	public static void main(String[] args) {
		Demo9_5 demo9_5 = new Demo9_5();
	}

	public Demo9_5()
	{
		mp=new MyPanel();
		
		this.add(mp);
		this.addMouseListener(mp);
		this.addKeyListener(mp);
		this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		this.setSize(400, 300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


//1.让MyPanel知道鼠标按下的信息,并且知道点击的位置下x,y
//2.让MyPanel知道那个键按下
//3.让MyPanel知道鼠标移动,拖拽
//4.让MyPanel知道串口的变化  (关闭,最小化,最大化)
class MyPanel extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标点击了"+arg0.getX()+"  ,"+arg0.getY());
	}

	@Override//鼠标移动到Panel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标来了");
	}

	@Override//鼠标离开panel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标走了");
	}

	@Override//按下 没松开
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override//松开
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override//键输入
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyChar());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("鼠标当前坐标"+e.getX()+"  ,"+e.getY());
	}

	@Override//窗口激活
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("激活");
	}

	@Override//窗口关闭了
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("关闭了");
	}

	@Override//窗口正在关闭
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("closing");
	}

	@Override//窗口最小化
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("最小话");
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}