#include <iostream>
#include <cstdlib>
#include "Sort.h"
#include <fstream>
using namespace std;

int main() 
{	
	ifstream test;
	test.open("�����������.txt",ifstream::in);
	int n;
	test>>n;
	int *a=new int[n];
	for (int i=0;i<7;++i)
	{
		for (int j=0;j<n;++j)
			test>>a[j];
		cout<<"��"<<i+1<<"�����ݲ��Խ��:"<<endl;
		Sort (a, n);
		cout<<endl<<endl<<endl;
		system ("pause"); 
	}
	system("pause");
	return 0;
}

