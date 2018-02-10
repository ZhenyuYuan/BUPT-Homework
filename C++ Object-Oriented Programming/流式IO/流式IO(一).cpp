#include<iostream>
#include<fstream>
#include<iomanip>
#include<string>
#include<stdlib.h>
using namespace std;

int main()
{
	ofstream output;

	output.open("text1.txt", ios::out);				//���ļ�������� 
	if(output.fail()) 								//�ж��ļ��Ƿ�򿪳ɹ� 
	{
		cout << "File does not exit." << endl;
		cout << "Exit programe." << endl;
		return 0;
	}
	
	/*---------------------------���ļ���д������---------------------------*/
	int i;
	unsigned int ui;
	long  li;
	float f;
	double d;
	char  c;
	string str;
	
	cout << "Please input an integer:";
	cin  >> i;
	cout << "Please input an unsigned integer:";
	cin  >> ui;
    cout << "Please input a long int:";
	cin  >> li;
	cout << "Please input a float:";
	cin  >> f;
	cout << "Please input a double:";
	cin  >> d;
	cout << "Please input a char:";
	cin  >> c;
	cout << "Please input a string:";
	//cin  >> str;
	getline(cin, str);
	
	output << setw(10) << i;
	output << setw(10) << ui;
	output << setw(10) << li;
	output << setw(10) << setprecision(8) << showpoint << f;      //��showpointʹ��С������ȫΪ0ʱ�����С�����ֶ���ֻ���������� 
	output << setw(10) << setprecision(8) << showpoint << d;
	output << setw(10) << c;
	output << setw(10) << str;
	
	output << endl; 
	output << "ʮ���ƣ�  i = " << dec << i << endl;
	output << "�˽���:   i = " << oct << i << endl;
	output << "ʮ������: i = " << hex << i << endl;
	
	output.close();									//�ر��ļ�
	
	system("pause");
	return 0;	
}
