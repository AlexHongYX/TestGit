package SelectSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener,MouseListener{
	JLabel userLa,passLa;
	JTextField userTxt;
	JPasswordField passTxt;
	JButton loBt,quitBt;
	
	JPanel selectPa;
	JButton[] selectBts;
	
	
	JPanel controlPa;
	JLabel numLa,nameLa,sexla,Warnla;
	JTextField numTxt,nameTxt,sexTxt,deleteTxt;
	JButton findBt;
	
	public LoginFrame()
	{
		this.setSize(400, 300);
		this.setTitle("登录窗口");		
		
		this.setLayout(null);
		userLa=new JLabel("用户名");
		userLa.setSize(60, 30);
		userLa.setLocation(90, 50);
		this.add(userLa);
		
		userTxt=new JTextField();
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 50);
		this.add(userTxt);
		
		passLa=new JLabel("密   码");
		passLa.setSize(60, 30);
		passLa.setLocation(90, 100);
		this.add(passLa);
		passTxt=new JPasswordField();
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 100);
		this.add(passTxt);
		loBt=new JButton("登录");
		loBt.setSize(60, 30);
		loBt.setLocation(120, 150);
		loBt.addActionListener(this);
		this.add(loBt);
		quitBt=new JButton("退出");
		quitBt.setSize(60, 30);
		quitBt.setLocation(210, 150);
		this.add(quitBt);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("登录"))
		{
		String name=userTxt.getText().trim();
		String num=passTxt.getText().trim();
		StudentDeal deal=new StudentDeal();
		if(num.equals(deal.findNumByName(name)))
		{
			this.setSize(800, 600);
			this.setTitle("主窗口");
			this.getContentPane().removeAll();
			initSelectPanel();
			initControlPa();
		}
		}
		else
		{
			if(bt.getText().equals("查找"))
			{
				StudentDeal deal=new StudentDeal();
				String name=deal.findNameByNum(numTxt.getText().trim());
				nameTxt.setText(name);
				
			}else
			if(bt.getText().equals("添加"))
			{
				StudentDeal deal=new StudentDeal();
				StudentInfo stu=new StudentInfo(numTxt.getText().trim(),nameTxt.getText().trim(),sexTxt.getText().trim());
				deal.addStudent(stu);
				
			}else
			if(bt.getText().equals("删除"))
			{
				StudentDeal deal=new StudentDeal();
				String result=deal.deleteStudent(numTxt.getText().trim());
				deleteTxt.setText(result);
				
			}else
			if(bt.getText().equals("修改"))
			{
				StudentDeal deal=new StudentDeal();
				StudentInfo stu=new StudentInfo(numTxt.getText().trim(),nameTxt.getText().trim(),sexTxt.getText().trim());
				deal.updateStudent(stu);
				
			}
		}
		
	}

	private void initSelectPanel()
	{
		selectPa=new JPanel();
		selectPa.setLayout(null);
		selectPa.setSize(200, 600);
		selectPa.setBackground(Color.orange);
		String[] strs={"增加学生","删除学生","修改学生","查找学生"};
		selectBts=new JButton[strs.length];
		for(int i=0;i<selectBts.length;i++)
		{
			selectBts[i]=new JButton(strs[i]);
			selectBts[i].setSize(120, 30);
			selectBts[i].setLocation(30,35*i+30);
			selectBts[i].addMouseListener(this);
			selectPa.add(selectBts[i]);
		}
		this.add(selectPa);
		
	}
	private void initControlPa()
	{
		controlPa=new JPanel();
		controlPa.setLayout(null);
		controlPa.setLayout(null);
		controlPa.setLocation(200,0);
		controlPa.setSize(600, 600);
		controlPa.setBackground(Color.LIGHT_GRAY);
		this.add(controlPa);
	}

	public void mouseClicked(MouseEvent e)
	{
	    JButton sourceBt=(JButton)e.getSource();
	    System.out.println("OK");
		String str=sourceBt.getText();
		if(str.equals("查找学生"))
		{
			controlPa.removeAll();

			numLa=new JLabel("请输入学号");
			numLa.setSize(100, 30);
			numLa.setLocation(30, 30);
			controlPa.add(numLa);
			nameLa=new JLabel("学生姓名");
			nameLa.setSize(100, 30);
			nameLa.setLocation(30, 80);
			controlPa.add(nameLa);
			numTxt=new JTextField();
			numTxt.setSize(100, 30);
			numTxt.setLocation(140, 30);
			controlPa.add(numTxt);
			nameTxt=new JTextField();
			nameTxt.setSize(100, 30);
			nameTxt.setLocation(140, 80);
			controlPa.add(nameTxt);
			findBt=new JButton("查找");
			findBt.setSize(60, 30);
			findBt.setLocation(120, 130);
			findBt.addActionListener(this);
			controlPa.add(findBt);
			this.getContentPane().repaint();
		}
		else 
			if(str.equals("增加学生"))
			{
				controlPa.removeAll();

				numLa=new JLabel("请输入学号");
				numLa.setSize(100, 30);
				numLa.setLocation(30, 30);
				controlPa.add(numLa);
				nameLa=new JLabel("学生姓名");
				nameLa.setSize(100, 30);
				nameLa.setLocation(30, 80);
				controlPa.add(nameLa);
				sexla=new JLabel("性别");
				sexla.setSize(100, 30);
				sexla.setLocation(30, 120);
				controlPa.add(sexla);

				numTxt=new JTextField();
				numTxt.setSize(100, 30);
				numTxt.setLocation(140, 30);
				controlPa.add(numTxt);
				nameTxt=new JTextField();
				nameTxt.setSize(100, 30);
				nameTxt.setLocation(140, 80);
				controlPa.add(nameTxt);
				sexTxt=new JTextField();
				sexTxt.setSize(100, 30);
				sexTxt.setLocation(140, 130);
				controlPa.add(sexTxt);
				findBt=new JButton("添加");
				findBt.setSize(60, 30);
				findBt.setLocation(120, 180);
				findBt.addActionListener(this);
				controlPa.add(findBt);
				this.getContentPane().repaint();
			}
	      else
	    	  if(str.equals("删除学生"))
	  		{
	  			controlPa.removeAll();
	 
	  			numLa=new JLabel("请输入学号");
	  			numLa.setSize(100, 30);
	  			numLa.setLocation(30, 30);
	  			controlPa.add(numLa);
	  			numTxt=new JTextField();
	  			numTxt.setSize(100, 30);
	  			numTxt.setLocation(140, 30);
	  			controlPa.add(numTxt);
	  			Warnla=new JLabel("状态信息显示栏");
				Warnla.setSize(120,30);
				Warnla.setLocation(30, 80);
				controlPa.add(Warnla);
	  			deleteTxt=new JTextField();
	  			deleteTxt.setSize(100,30);
	  			deleteTxt.setLocation(140, 80);
	  			controlPa.add(deleteTxt);
	  			findBt=new JButton("删除");
	  			findBt.setSize(60, 30);
	  			findBt.setLocation(120, 130);
	  			findBt.addActionListener(this);
	  			controlPa.add(findBt);
	  			this.getContentPane().repaint();
	  		}
	    else
	    	if(str.equals("修改学生"))
			{
				controlPa.removeAll();

				Warnla=new JLabel("以下为根据学号进行修改后，请填写正确信息！！！");
				Warnla.setSize(800,30);
				Warnla.setLocation(30, 30);
				controlPa.add(Warnla);
				numLa=new JLabel("请输入学号");
				numLa.setSize(100, 30);
				numLa.setLocation(30, 80);
				controlPa.add(numLa);
				nameLa=new JLabel("学生姓名");
				nameLa.setSize(100, 30);
				nameLa.setLocation(30, 130);
				controlPa.add(nameLa);
				sexla=new JLabel("性别");
				sexla.setSize(100, 30);
				sexla.setLocation(30, 180);
				controlPa.add(sexla);
				numTxt=new JTextField();
				numTxt.setSize(100, 30);
				numTxt.setLocation(140, 80);
				controlPa.add(numTxt);
				nameTxt=new JTextField();
				nameTxt.setSize(100, 30);
				nameTxt.setLocation(140, 130);
				controlPa.add(nameTxt);
				sexTxt=new JTextField();
				sexTxt.setSize(100, 30);
				sexTxt.setLocation(140, 180);
				controlPa.add(sexTxt);
				findBt=new JButton("修改");
				findBt.setSize(60, 30);
				findBt.setLocation(120, 230);
				findBt.addActionListener(this);
				controlPa.add(findBt);
				this.getContentPane().repaint();
			}
		}
	 public void mousePressed(MouseEvent e){}
	 public void mouseReleased(MouseEvent e){}
	 public void mouseEntered(MouseEvent e)
	 {
	 }
	 public void mouseExited(MouseEvent e)
	 {
	 }
}

