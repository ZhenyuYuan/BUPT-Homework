#include <iostream> 
#include "Sort.h"
using namespace std;


void Sort (int A[],int n)	
{
	long long MoveNum = 0, CompNum=0;
	
	int *B = new int[n];
	int *C = new int[n];
	
	
	for(int i = 0; i < n; i++)
	{
		B[i] = A[i];
		C[i] = A[i];
	}
	
	InsertSort(A, n, MoveNum, CompNum);
	cout<<"��������"<<endl;
	cout<<"��������飺"<<endl;
	for(int i = 0; i < n; i++)
	{
		cout << A[i] << " ";
		if((i+1)%10 == 0)
		    cout << endl;
	}
	cout<<endl;
	cout <<"��Ų������"<<MoveNum<< endl;
	cout <<"�Ƚϴ�����"<<CompNum<< endl<<endl;
	
	MoveNum = 0, CompNum=0;
	MergeSort(B, n, MoveNum, CompNum);
	cout<<"�鲢����"<<endl;
	cout<<"��������飺"<<endl;
	for(int i = 0; i < n; i++)
	{
		cout << B[i] << " ";
		if((i+1)%10 == 0)
		    cout << endl;
	}
	cout<<endl;
	cout <<"��Ų������"<<MoveNum<< endl;
	cout <<"�Ƚϴ�����"<<CompNum<< endl<<endl;
	
	MoveNum = 0, CompNum=0;
	QuickSort(C, 0, n-1, MoveNum, CompNum);
	cout<<"��������"<<endl;
	cout<<"��������飺"<<endl;
	for(int i = 0; i < n; i++)
	{
		cout << C[i] << " ";
		if((i+1)%10 == 0)
		    cout << endl;
	}
	cout<<endl;
	cout <<"��Ų������"<<MoveNum<< endl;
	cout <<"�Ƚϴ�����"<<CompNum<< endl<<endl;
}
