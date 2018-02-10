package com.Student;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> list;	//list�洢ѧ������
	private int total;			//ѧ��������
	public StudentList(){		//length�����鳤��
		list = new ArrayList<>(100);
		total = list.size();
	}
	public boolean Add(Student stu){//���� stu �������У��ɹ������� true������ false
	    return list.add(stu);
	}
	public boolean Remove(int no){//ɾ���� no������Ԫ�أ�ɾ���ɹ������� true������ false
		if(no >= 0 && list.remove(no) != null)
			return true;
		else
			return false;
	}
	public boolean Remove(String number){//ɾ��ѧ��Ϊ number��ѧ����ɾ���ɹ��� ���� true������ false 
		int no = -1;
		for(int i=0; i <= list.size()-1;i++){
			if(list.get(i).getNumber().equals(number)){
				no = i;
				break;
			}	
		}
		if((no >= 0) && (list.remove(no) != null))
			return true;
		else 
			return false;
	}
	public boolean isEmpty(){//�ж������Ƿ�Ϊ�գ����ǣ����� true������ false 
		return list.isEmpty();
	}
	public Student getItem(int no){//���ص� no��ѧ�� 
		return list.get(no);
	}
	public Student getItem(String number){//����ѧ��Ϊ number ��ѧ���������������ڣ����� null�� 
		int no = -1;
		for(int i=0; i <= list.size()-1; i++){
			if(list.get(i).getNumber().equals(number)){
				no = i;
				break;
			}
		}
		if((no >= 0) && (no <= list.size()-1))
			return list.get(no);
		else 
			return null;
	}
	public int getTotal(){//����ѧ��������
		total = list.size();
		return total;
	}
}