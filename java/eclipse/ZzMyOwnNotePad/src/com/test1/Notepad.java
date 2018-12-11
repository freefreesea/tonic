/**
 * 我的记事本(界面+功能)
 */
package com.test1;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Notepad extends JFrame implements ActionListener{
	
	//定义需要的组件
	JTextArea jta = null;
	//菜单条
	JMenuBar jmb=null;
	//第一JMenu
	JMenu jm1 = null;
	//JMenuItem
	JMenuItem jmi1=null; 
	JMenuItem jmi2=null; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Notepad np=new Notepad();
	}
	
	//构造函数
	public Notepad()
	{
		//创建jta
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1 = new JMenu("打开(o)");
		//设置助记符
		jm1.setMnemonic('F');
		jmi1 = new JMenuItem("打开",new ImageIcon("src/image4.jpg"));
		
		
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2 = new JMenuItem("保存");
		
		//对保存菜单处理
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//加入
		this.setJMenuBar(jmb);
		//把jm1放入jmb
		jmb.add(jm1);
		//把item放入Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		
		//放入JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,300);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个菜单被选中
		if(e.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//JFileChooser
			JFileChooser jfc1 = new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件...");
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件路径
			String filename = jfc1.getSelectedFile().getAbsolutePath();
			
//			System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			
			try {
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
				
				
				//从文件中读取信息并显示到jta
				
				String s= "";
				String allCon="";
				while((s=br.readLine())!=null)
				{
					allCon+=s+"\r\n";
				}
				
				//放置入jta
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
			//出现保存对话框
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("另存为...");
			//按默认的方式显示
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			//得到用户希望把文件保存到何处
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
