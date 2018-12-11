/**
 * �ҵļ��±�(����+����)
 */
package com.test1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Notepad extends JFrame implements ActionListener{
	
	//������Ҫ�����
	JTextArea jta = null;
	//�˵���
	JMenuBar jmb=null;
	//��һJMenu
	JMenu jm1 = null;
	//JMenuItem
	JMenuItem jmi1=null; 
	JMenuItem jmi2=null; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notepad np=new Notepad();
	}
	
	//���캯��
	public Notepad()
	{
		//����jta
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1 = new JMenu("��(o)");
		//�������Ƿ�
		jm1.setMnemonic('F');
		jmi1 = new JMenuItem("��",new ImageIcon("src/image4.jpg"));
		
		
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2 = new JMenuItem("����");
		
		//�Ա���˵�����
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//����
		this.setJMenuBar(jmb);
		//��jm1����jmb
		jmb.add(jm1);
		//��item����Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		
		//����JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,300);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж����ĸ��˵���ѡ��
		if(e.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//JFileChooser
			JFileChooser jfc1 = new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�...");
			//Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�·��
			String filename = jfc1.getSelectedFile().getAbsolutePath();
			
//			System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			
			try {
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
				
				
				//���ļ��ж�ȡ��Ϣ����ʾ��jta
				
				String s= "";
				String allCon="";
				while((s=br.readLine())!=null)
				{
					allCon+=s+"\r\n";
				}
				
				//������jta
				//System.out.println(allCon);
				jta.setText(allCon);
				
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}finally
			{
				try {
					br.close();
					fr.close();
					
					
				} catch (Exception e3) {
					e3.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		else if(e.getActionCommand().equals("save"))
		{
			//���ֱ���Ի���
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("����Ϊ...");
			//��Ĭ�ϵķ�ʽ��ʾ
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			//�õ��û�ϣ�����ļ����浽�δ�
			String file=jfc.getSelectedFile().getAbsolutePath();
			
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				
				bw.write(this.jta.getText());
								
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}finally
			{
				try {
					bw.close();
					fw.close();
					
					
					
					
				} catch (Exception e3) {
					e3.printStackTrace();
					// TODO: handle exception
				}
			}
		}
	}
}