package homework3;

import java.util.ArrayList;

public class _14211529_袁振宇_3_EmployeeList {
	private ArrayList<_14211529_袁振宇_3_Employee> list;	//list存储雇员对象
	private int total;			//雇员 总人数
	public _14211529_袁振宇_3_EmployeeList(){		//length是数组长度
		list = new ArrayList<>(100);
		total = list.size();
	}
	public boolean Add(_14211529_袁振宇_3_Employee emp){//增加 emp 到数组中，成功，返回 true，否则 false
	    return list.add(emp);
	}
	public _14211529_袁振宇_3_Employee getItem(int i) {
		return list.get(i);
	}
	public int getTotal(){//雇员总人数
		total = list.size();
		return total;
	}
}
