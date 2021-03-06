package homework4;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class _14211529_Ԭ����_4_MainWindow extends JFrame implements ActionListener{

	private static _14211529_Ԭ����_4_EmployeeList empList;
	
	private JPanel mainPanel1 = new JPanel();
	private JPanel mainPanel2 = new JPanel();
	private JPanel mainPanel3 = new JPanel();
	//declare and create the top menu bar
	private JMenuBar bar = new JMenuBar();
	//declare and create two menus
	private JMenu leftStripeMenu = new JMenu("EmployeeInforInput");
	private JMenu rightStripeMenu = new JMenu("Search");
	//declare and create each menu item
	private JMenuItem ComEmpItem = new JMenuItem("CommisionEmployee");
	private JMenuItem BasePlusComEmpItem = new JMenuItem("BasePlusCommisionEmployee");
	private JMenuItem AvreageEarningSearchItem = new JMenuItem("AvreageEarningSearch");
	private JLabel lblWelcome = new JLabel("Welcome to employee system");
	private JLabel lblDesignedByYzy = new JLabel("Designed by YZY");
	
	
	public static void main(String[] args) {
		new _14211529_Ԭ����_4_MainWindow();
	}

	public _14211529_Ԭ����_4_MainWindow() {
		setTitle("Employee System");
		
		//set each stripe to an innitail color
		mainPanel1.setBackground(Color.LIGHT_GRAY);
		mainPanel2.setBackground(Color.LIGHT_GRAY);
		mainPanel3.setBackground(Color.LIGHT_GRAY);
	
		
		//add menu items to the botton stripe menu
		leftStripeMenu.add(ComEmpItem);
		leftStripeMenu.add(BasePlusComEmpItem);
		rightStripeMenu.add(AvreageEarningSearchItem);
		
		//add the menus to the menu bar
		bar.add(leftStripeMenu);
		bar.add(rightStripeMenu);
		
		//add the menu bar to the frame
		setJMenuBar(bar);
		
		//add listerners to each menu item
		ComEmpItem.addActionListener(this);
		BasePlusComEmpItem.addActionListener(this);
		AvreageEarningSearchItem.addActionListener(this);
		
		//select a GridLayout
		setLayout(new GridLayout(3,1));
		add(mainPanel1);
		add(mainPanel2);
		add(mainPanel3);
		mainPanel3.add(lblWelcome);
		lblWelcome.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		//add the panels to the frame
		getContentPane().add(mainPanel2);
		lblDesignedByYzy.setFont(new Font("MV Boli", Font.PLAIN, 15));
		
		mainPanel2.add(lblDesignedByYzy);
				
		empList = new _14211529_Ԭ����_4_EmployeeList();
		//choose settings for the frame and make it visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ComEmpItem){
			_14211529_Ԭ����_4_InputComInfoWin comwin = new _14211529_Ԭ����_4_InputComInfoWin();
			comwin.setVisible(true);
			_14211529_Ԭ����_4_CommissionEmployee ComEmp;
			ComEmp = comwin.getComEmp();
			if(ComEmp!=null){
				empList.Add(ComEmp);
			}
		}
		else if(e.getSource()==BasePlusComEmpItem){
			_14211529_Ԭ����_4_InputBaseComInfoWin bpcomwin = new _14211529_Ԭ����_4_InputBaseComInfoWin();
			bpcomwin.setVisible(true);
			_14211529_Ԭ����_4_BasePlusCommissionEmployee BasePlusComEmp;
			BasePlusComEmp = bpcomwin.getComEmp();
			if(BasePlusComEmp!=null){
				empList.Add(BasePlusComEmp);
			}
		}
		else if(e.getSource()==AvreageEarningSearchItem){
			double averageEarning = 0;
			double earning = 0;
			if(empList.getTotal()>0){
				for(int i = 0; i < empList.getTotal(); i++){
					earning+=empList.getItem(i).earning();
				}
				averageEarning = earning/empList.getTotal();
			}
			else{
				averageEarning = 0;
			}
			
			_14211529_Ԭ����_4_AverageEarningWin averagewin = new _14211529_Ԭ����_4_AverageEarningWin(empList.getTotal(), averageEarning);
			averagewin.setVisible(true);;
		}
	}

	public static _14211529_Ԭ����_4_EmployeeList getEmpList() {
		return empList;
	}

	public void setEmpList(_14211529_Ԭ����_4_EmployeeList empList) {
		_14211529_Ԭ����_4_MainWindow.empList = empList;
	}
}
