package com.Student;

import java.util.Scanner;

public class StudentListTest {
	private static Scanner sc;

	public static void main(String[] args){
		Student stu;
		StudentList stulist;
		String stuNum = null;
		String stuName = null;
		int MathsMark = -1;
		int EnglishMark = -1;
		int ScienceMark = -1;
		int operation = 0;
		int seq = -1;
		
		sc = new Scanner(System.in);
		
		stulist = new StudentList();
		
		System.out.println("�˵����£�������1~8������Ҫִ�еĲ�����");
		System.out.println("1.����һ��ѧ��      2.����ѧ��ɾ��ѧ��      3.����λ��ɾ��ѧ��");
		System.out.println("4.�ж��Ƿ�Ϊ��      5.����λ�÷���ѧ��      6.����ѧ�ŷ���ѧ��");
		System.out.println("7.���ȫ��ѧ����Ϣ      8.�˳�����");
		
		while(true){
			System.out.println("���������Ĳ�����");
			operation = sc.nextInt();
			sc = new Scanner(System.in);
			
			switch(operation){
			case 1:
				while(true){
					sc = new Scanner(System.in);
					try{
						System.out.println("������ѧ��ѧ�ţ�");
						stuNum = sc.nextLine();		//��ȡһ���ַ���
						boolean isOK = true;
						for(int i=0; i<stuNum.length(); i++){
							if(!(('0'<=stuNum.charAt(i))&&(stuNum.charAt(i)<='9')) ){
								isOK = false;
								break;
							}
						}
						if(!((stuNum.length()==10)&&(stuNum.charAt(0)=='2')&&(stuNum.charAt(1)=='0')&&(isOK))){
							throw new StudentNumberException();
						}
						break;
					}
					catch(StudentNumberException e){
						System.out.println(e.getMessage());
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
						System.out.println("������ѧ��������");
						stuName = sc.nextLine();
				while(true){
					sc = new Scanner(System.in);
					try{	
						System.out.println("������ѧ�����ſγɼ�����ѧ��Ӣ���ѧ����");
						MathsMark = sc.nextInt(); 	//��ȡһ������
						EnglishMark = sc.nextInt();
						ScienceMark = sc.nextInt();
						if(!((MathsMark>=0)&&(MathsMark<=100)&&(EnglishMark>=0)&&(EnglishMark<=100)&&(ScienceMark>=0)&&(ScienceMark<=100))){
							throw new ScoreException();
						}
						break;
					}
					catch(ScoreException e){
						System.out.println(e.getMessage());
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
				stu = new Student(stuNum, stuName);
				stu.enterMarks(MathsMark, EnglishMark, ScienceMark);
				if(stulist.Add(stu)){
					System.out.println("--Ŀǰ��"+stulist.getTotal()+"��ѧ������ϢΪ--");
					for(int i=0; i<=stulist.getTotal()-1; i++){
						stu = (Student) stulist.getItem(i);
						System.out.println("ѧ�ţ�"+stu.getNumber());
						System.out.println("������"+stu.getName());
						System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
						System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
						System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
						System.out.println("ƽ���ɼ���"+stu.calculateAverage());
					}
				}
				break;
			case 2:
				if(stulist.getTotal() == 0)
					System.out.println("��ǰѧ����Ϊ0������ɾ��");
				else{
					while(true){
						sc = new Scanner(System.in);
						try{
							System.out.println("������ѧ��ѧ�ţ�");
							stuNum = sc.nextLine();		//��ȡһ���ַ���
							boolean isOK = true;
							for(int i=0; i<stuNum.length(); i++){
								if(!(('0'<=stuNum.charAt(i))&&(stuNum.charAt(i)<='9')) ){
									isOK = false;
									break;
								}
							}
							if(!((stuNum.length()==10)&&(stuNum.charAt(0)=='2')&&(stuNum.charAt(1)=='0')&&(isOK))){
								throw new StudentNumberException();
							}
							break;
						}
						catch(StudentNumberException e){
							System.out.println(e.getMessage());
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
					}
					if(stulist.Remove(stuNum) == true){
						System.out.println("ɾ���ɹ�");
						System.out.println("--Ŀǰ��"+stulist.getTotal()+"��ѧ������ϢΪ--");
						for(int i=0; stulist.getTotal()>0 && i<=stulist.getTotal()-1; i++){
							stu = (Student) stulist.getItem(i);
							System.out.println("ѧ�ţ�"+stu.getNumber());
							System.out.println("������"+stu.getName());
							System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
							System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
							System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
							System.out.println("ƽ���ɼ���"+stu.calculateAverage());
						}
					}
					else {
						System.out.println("�Բ���û�ж�Ӧ��ѧ����");
					}					
				}
				break;
			case 3:
				if(stulist.getTotal() == 0)
					System.out.println("��ǰѧ����Ϊ0������ɾ��");
				else{
					System.out.println("������Ҫɾ���ڼ���ѧ����");
					seq = sc.nextInt();
					if(seq <= stulist.getTotal()){
						if(stulist.Remove(seq-1))
							System.out.println("ɾ���ɹ�");
						else 
							System.out.println("ɾ��ʧ��");
						System.out.println("--Ŀǰ��"+stulist.getTotal()+"��ѧ������ϢΪ--");
						for(int i=0; stulist.getTotal()>0 && i<=stulist.getTotal()-1; i++){
							stu = (Student) stulist.getItem(i);
							System.out.println("ѧ�ţ�"+stu.getNumber());
							System.out.println("������"+stu.getName());
							System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
							System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
							System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
							System.out.println("ƽ���ɼ���"+stu.calculateAverage());
						}
					}
					else{
						System.out.println("�Բ���û�ж�Ӧ��ѧ����");
					}
				}
				break;
			case 4:
				if(stulist.isEmpty())
					System.out.println("��ǰѧ����Ϊ0");
				else
					System.out.println("��ǰѧ����Ϊ��"+stulist.getTotal());
				break;
			case 5:
				if(stulist.getTotal() == 0)
					System.out.println("��ǰѧ����Ϊ0�����ɲ���");
				else{
					System.out.println("������Ҫ����ѧ����λ����ţ�");
					seq = sc.nextInt();
					if((seq > 0) && (seq <= stulist.getTotal())){
						stu = stulist.getItem(seq-1);
						System.out.println("ѧ�ţ�"+stu.getNumber());
						System.out.println("������"+stu.getName());
						System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
						System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
						System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
						System.out.println("ƽ���ɼ���"+stu.calculateAverage());
					}
					else{
						System.out.println("�Բ���û�ж�Ӧ��ѧ��");
					}			
				}
				break;
			case 6:
				if(stulist.getTotal() == 0)
					System.out.println("��ǰѧ����Ϊ0�����ɲ���");
				else{
					System.out.println("������Ҫ����ѧ����ѧ�ţ�");
					stuNum = sc.nextLine();
					stu = stulist.getItem(stuNum);
					if(stu != null){
						System.out.println("ѧ�ţ�"+stu.getNumber());
						System.out.println("������"+stu.getName());
						System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
						System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
						System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
						System.out.println("ƽ���ɼ���"+stu.calculateAverage());
					}
					else{
						System.out.println("�Բ���û�ж�Ӧ��ѧ��");
					}
				}
				
				break;	
			case 7:
				System.out.println("--Ŀǰ��"+stulist.getTotal()+"��ѧ������ϢΪ--");
				for(int i=0; stulist.getTotal()>0 && i<=stulist.getTotal()-1; i++){
					stu = (Student) stulist.getItem(i);
					System.out.println("ѧ�ţ�"+stu.getNumber());
					System.out.println("������"+stu.getName());
					System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
					System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
					System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
					System.out.println("ƽ���ɼ���"+stu.calculateAverage());
				}
				break;
			case 8:
				System.out.println("�˳�����");
				System.exit(0);
				break;
			}
		}
	}
}