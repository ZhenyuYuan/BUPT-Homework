package homework4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings({ "serial"})
public class _14211529_Ԭ����_4_InputComInfoWin extends JDialog implements ActionListener{

	private _14211529_Ԭ����_4_CommissionEmployee comemp;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtSocialsecuritynumber;
	private JTextField txtGrosssales;
	private JTextField txtCommissionrate;
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");

	public _14211529_Ԭ����_4_InputComInfoWin() {
		setTitle("Employee system: Create a CommissionEmployee");
		setBounds(100, 100, 450, 300);
		
		JPanel hintPane = new JPanel();
		hintPane.setBounds(1, 0, 432, 29);
		JPanel fnamePane = new JPanel();
		fnamePane.setBounds(1, 30, 432, 37);
		JPanel lnamePane = new JPanel();
		lnamePane.setBounds(1, 69, 432, 37);
		JPanel socialSecNumPane = new JPanel();
		socialSecNumPane.setBounds(1, 106, 432, 40);
		JPanel grossSalePane= new JPanel();
		grossSalePane.setBounds(1, 144, 432, 40);
		JPanel comRatePane = new JPanel();
		comRatePane.setBounds(1, 184, 432, 40);
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(1, 221, 432, 40);
		getContentPane().setLayout(null);
		getContentPane().add(hintPane);
		hintPane.setLayout(null);
		
		JLabel lblPleaseInputInformation = new JLabel("Please input information of CommissionEmployee you want to create:");
		lblPleaseInputInformation.setBounds(10, 10, 412, 15);
		hintPane.add(lblPleaseInputInformation);
		getContentPane().add(fnamePane);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		fnamePane.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setText("Firstname");
		fnamePane.add(txtFirstname);
		txtFirstname.setColumns(10);
		getContentPane().add(lnamePane);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lnamePane.add(lblLastname);
		
		txtLastname = new JTextField();
		txtLastname.setText("Lastname");
		lnamePane.add(txtLastname);
		txtLastname.setColumns(10);
		getContentPane().add(socialSecNumPane);
		socialSecNumPane.setLayout(null);
		
		JLabel lblSocialsecutitynumber = new JLabel("SocialSecutityNumber:");
		lblSocialsecutitynumber.setBounds(57, 10, 149, 15);
		socialSecNumPane.add(lblSocialsecutitynumber);
		
		txtSocialsecuritynumber = new JTextField();
		txtSocialsecuritynumber.setBounds(188, 7, 140, 21);
		txtSocialsecuritynumber.setText("SocialSecurityNumber");
		socialSecNumPane.add(txtSocialsecuritynumber);
		txtSocialsecuritynumber.setColumns(10);
		getContentPane().add(grossSalePane);
		grossSalePane.setLayout(null);
		
		JLabel lblGrosssales = new JLabel("GrossSales:");
		lblGrosssales.setBounds(114, 8, 74, 15);
		grossSalePane.add(lblGrosssales);
		
		txtGrosssales = new JTextField();
		txtGrosssales.setBounds(188, 5, 74, 21);
		txtGrosssales.setText("0");
		grossSalePane.add(txtGrosssales);
		txtGrosssales.setColumns(10);
		getContentPane().add(comRatePane);
		comRatePane.setLayout(null);
		
		JLabel lblCommissionrate = new JLabel("CommissionRate:");
		lblCommissionrate.setBounds(77, 8, 110, 15);
		comRatePane.add(lblCommissionrate);
		
		txtCommissionrate = new JTextField();
		txtCommissionrate.setBounds(186, 5, 110, 21);
		txtCommissionrate.setText("0");
		comRatePane.add(txtCommissionrate);
		txtCommissionrate.setColumns(10);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			
			okButton.addActionListener(this);
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			cancelButton.addActionListener(this);
			buttonPane.add(cancelButton);
		}
		setModal(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okButton){
			String firstName = (String)txtFirstname.getText();
			String lastName = (String)txtLastname.getText();
			String socialSecurityNumber = (String)txtSocialsecuritynumber.getText();
			double grossSales = Double.parseDouble(txtGrosssales.getText());
			double commissionRate = Double.parseDouble(txtCommissionrate.getText());
			
			_14211529_Ԭ����_4_CommissionEmployee comemp;
			comemp = new _14211529_Ԭ����_4_CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
			this.comemp = comemp;
		}
		if(e.getSource()==cancelButton){
			this.comemp = null;
		}
		dispose();
		
	}
	public _14211529_Ԭ����_4_CommissionEmployee getComEmp() {
		return this.comemp;
	}
	public void setComEmp(_14211529_Ԭ����_4_CommissionEmployee comemp) {
		this.comemp = comemp;
	}
}