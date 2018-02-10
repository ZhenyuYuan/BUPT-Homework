package com.Student;

public class Student {
	private String studentNumber;
	private String studentName;
	private int markForMaths;
	private int markForEnglish;
	private int markForScience;
	public Student(){
		this(" ", " ");
	}
	public Student(String number, String name){
		studentNumber = number;
		studentName = name;
		markForMaths = -1;
		markForEnglish = -1;
		markForScience = -1;
	}
	public String getNumber(){
		return studentNumber;
	}
	public String getName(){
		return studentName;
	}
	public void enterMarks(int markForMaths, int markForEnglish, int markForScience){
		this.markForMaths = markForMaths;
		this.markForEnglish = markForEnglish;
		this.markForScience = markForScience;
	}
	public int getMathsMark(){
		return markForMaths;
	}
	public int getEnglishMark(){
		return markForEnglish;
	}
	public int getScienceMark(){
		return markForScience;
	}
	public double calculateAverage()
	{
		double AverageMarks = (markForMaths+markForEnglish+markForScience) / 3.0;
		return AverageMarks;
	}
	public String toString(){
		return("ѧ�ţ�"+studentNumber+"\n������"+studentName+"\n��ѧ�ɼ���"+markForMaths+
			   "\nӢ��ɼ���"+markForEnglish+"\n��ѧ�ɼ���"+markForScience+"\nƽ���ɼ���"+this.calculateAverage());
	}
}
