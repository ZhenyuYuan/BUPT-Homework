#include<iostream>
#include<stdlib.h>
using namespace std;

main()
{
	int Fib[100]={0,1},c,n;                           //n����쳲��������е�����
	
	cout << "����������:";
	cin >> n;
	  
    if(n>=2)
    {
    	for(int i=2; i<=n; i++)
		{		
			Fib[i] = Fib[i-1] + Fib[i-2];
	 	}
    }
	
	cout << "n=" << n << "ʱ������ֵΪ" << Fib[n] << endl;
	
	system("pause");
	return 0;
}
