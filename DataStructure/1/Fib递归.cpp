#include<iostream>
#include<stdlib.h>
using namespace std;

int Fib(int );

int main()
{
	int n;
	cout << "����������:";
	cin >> n;
	cout << "n=" << n << "ʱ������ֵΪ" << Fib(n) << endl;
	system("pause");
	return 0;
}

int Fib(int n)
{
	if(n == 0 || n == 1)
	    return n;
	else
	    return Fib(n-1) + Fib(n-2);                    //ʵ�ֵݹ� 
}
