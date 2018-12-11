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


//1.��MyPanel֪����갴�µ���Ϣ,����֪�������λ����x,y
//2.��MyPanel֪���Ǹ�������
//3.��MyPanel֪������ƶ�,��ק
//4.��MyPanel֪�����ڵı仯  (�ر�,��С��,���)
class MyPanel extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�������"+arg0.getX()+"  ,"+arg0.getY());
	}

	@Override//����ƶ���Panel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�������");
	}

	@Override//����뿪panel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�������");
	}

	@Override//���� û�ɿ�
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override//�ɿ�
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

	@Override//������
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
		System.out.println("��굱ǰ����"+e.getX()+"  ,"+e.getY());
	}

	@Override//���ڼ���
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	@Override//���ڹر���
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�ر���");
	}

	@Override//�������ڹر�
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("closing");
	}

	@Override//������С��
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��С��");
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