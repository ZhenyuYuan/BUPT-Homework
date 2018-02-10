package homework3;

public class _14211529_袁振宇_3_HourlyEmployee extends _14211529_袁振宇_3_Employee{
	private double wage;    //每小时的工钱
	private double hours;	//月工作小时数
	public _14211529_袁振宇_3_HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}
	public double earning(){
		return wage* hours;
	}
	public void setWage(double wage){
		this.wage = wage;
	}
	public void setHours(double hours){
		this.hours = hours;
	}
	public double getWage(){
		return wage;
	}
	public double getHours(){
		return hours;
	}
	public String toString(){
		return getClass().getName()
				+"[fistname="+getFirstName()
				+", lastName="+getLastName()
				+", socialSecurityNumber="+getSocialSecurityNumber()
				+", wage="+getWage()
				+", hours="+getHours()
				+", monthlySalary="+earning()
				+"]";
	}
}