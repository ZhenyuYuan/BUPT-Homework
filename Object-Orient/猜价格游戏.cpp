/*����C/C++���ԣ�ͨ��������������ķ����ǵ�����������������
srand(time(0));�趨��������ӣ� ��������ʹ�õ�ǰʱ����Ϊ����
rand();  ����һ�������
�������ͷ�ļ�ctime �� cstdlib*/
#include<iostream>
#include<ctime>
#include<cstdlib>
using namespace std;

int main()
{
	int price;                        //"price"���û��²�ļ۸� 
	
	srand(time(0));
	int PRICE = 1 + rand()%1000;      //"PRICE"����Ʒʵ�ʵļ۸� 
	cout << PRICE << endl;
	
	do
	{
		cout << "Please input the price you guess:";
		cin >> price;
		if(price >1000)
		    cout << "Please input an integer less than 1000!\n" << endl; 	
		else
		{
			if(price < PRICE)
	    		cout << "Too lower! Please try again.\n" << endl;
	    	if(price > PRICE)
	        	cout << "Too higher! Please try again.\n" << endl;
	    	if(price == PRICE)
	        	cout << "Your are right!" << endl;
		}
	}while(price != PRICE);
	
    system("pause");
    return 0;
} 
