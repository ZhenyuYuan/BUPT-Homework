#include <iostream>
#include <fstream>
#include "build.h"
using namespace std;

int main ()
{
	ofstream test;
	test.open("�����������.txt",fstream::out);
	int n;
	cout<<"������Ҫ���Ե���������";
	cin>>n;
	test<<n<<endl;
	Build_Best_Insert (test, n);
	cout<<"���������������������"<<endl;
	Build_Worst_Insert ( test, n);
	cout<<"�������������������"<<endl;
	Build_Best_Quick ( test, n);
	cout<<"���������������������"<<endl;
	Build_Worst_Quick ( test, n);
	cout<<"�������������������"<<endl;
	Build_Best_Merge ( test, n);
	cout<<"�鲢�����������������"<<endl;
	Build_Worst_Merge ( test, n);
	cout<<"�鲢���������������"<<endl;
	Build_Chaotic (test, n);
	cout<<"������������������"<<endl;
	system("pause");
	return 0;
}	