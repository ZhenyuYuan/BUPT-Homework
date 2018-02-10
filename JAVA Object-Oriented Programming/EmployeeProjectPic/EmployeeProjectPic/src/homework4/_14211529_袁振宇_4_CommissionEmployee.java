package homework4;

public class _14211529_Ԭ����_4_CommissionEmployee extends _14211529_Ԭ����_4_Employee{
	private double grossSales;		//���۶�
	private double commissionRate;	//��ɱ���
	public _14211529_Ԭ����_4_CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		this.grossSales = grossSales;	
		this.commissionRate = commissionRate;
	}
	public double earning(){
		return grossSales*commissionRate;
	}	
	public void setGrossSales(double grossSales){
		this.grossSales = grossSales;
	}
	public void setCommissionRate(double commissionRate){
		this.commissionRate = commissionRate;
	}
	public double getGrossSales(){
		return grossSales;
	}
	public double getCommissionRate(){
		return commissionRate;
	}
	public String toString(){
		return getClass().getName()
				+"[fistname="+getFirstName()
				+", lastName="+getLastName()
				+", socialSecurityNumber="+getSocialSecurityNumber()
				+", grossSales="+getGrossSales()
				+", commissionRate="+getCommissionRate()
				+", monthlySalary="+earning()
				+"]";
	}
}