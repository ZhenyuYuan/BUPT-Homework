/*�жϸ������������Ƿ�Ϊ������*/ 
#include<stdio.h>
#include<stdlib.h>

int isWaveNum(int n , int a) /*�ݹ麯��isWaveNum�Ķ��壬�����жϸ������������Ƿ�Ϊ������*/
{    
	if(n/100 == 0)
	{  
	  if(n%11==0) 
		return 0;
	  else 
	    if(n%100==a) 
		 return 1;		
	 }
	else 
	   return isWaveNum(n/100 , a);
} 
int main()
{
	int n,a;
	printf("Please input an integer:");
	scanf("%d",&n);
	a = n % 100;
	if(isWaveNum(n,a) == 1) printf("YES\n");
	else printf("NO\n");
	
	system("pause");
	return 0;
}
