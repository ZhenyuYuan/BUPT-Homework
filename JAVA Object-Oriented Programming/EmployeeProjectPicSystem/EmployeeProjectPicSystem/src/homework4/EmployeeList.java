package homework4;

import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Employee> list;	//list�洢��Ա����
	private int total;			//��Ա ������
	public EmployeeList(){		//length�����鳤��
		list = new ArrayList<>(100);
		total = list.size();
	}
	public boolean Add(Employee emp){//���� emp �������У��ɹ������� true������ false
	    return list.add(emp);
	}
	public Employee getItem(int i) {
		return list.get(i);
	}
	public int getTotal(){//��Ա������
		total = list.size();
		return total;
	}
}