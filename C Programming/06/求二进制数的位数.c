/*�����������λ��*/
#include<stdio.h>
int countBinary(int n)/*�ݹ麯��countBinnary�Ķ��壨���ڽ��Ǹ�ʮ��������nת���ɶ��������������ظö���������λ����*/
{
	if (n<=1) 
	  return 1;
	else
	  return countBinary(n/2)+1;
}
main()
{
  
   int n;
   printf("Input an integer:");
   scanf("%d",&n);
   printf("The binary form of number %d has %d digits.",n,countBinary(n));
   return 0;
   
}
