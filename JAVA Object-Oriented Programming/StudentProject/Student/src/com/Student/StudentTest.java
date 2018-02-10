package com.Student;

import java.util.Scanner;

public class StudentTest {
	private static Scanner sc;

	public static void main(String[] args){
		Student stu;
		String stuNum = null;
		String stuName = null;
		int MathsMark = -1;
		int EnglishMark = -1;
		int ScienceMark = -1;
		
		
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
		System.out.println("ѧ����Ϣ����");
		System.out.println("ѧ�ţ�"+stu.getNumber());
	    System.out.println("������"+stu.getName());
	    System.out.println("��ѧ�ɼ���"+stu.getMathsMark());
	    System.out.println("Ӣ��ɼ���"+stu.getEnglishMark());
	    System.out.println("��ѧ�ɼ���"+stu.getScienceMark());
	    System.out.println("ƽ���ɼ���"+stu.calculateAverage());
	}	
}