/*����ת��*/
#include<stdio.h>
int convert(int n)/*�ݹ麯��convert�Ķ��壨���ڽ���������ת��Ϊʮ��������*/ 
{
  if(n==0||n==1)
    return n;
  else
    return (n%10+convert(n/10)*2);	
}
main()
{  
  
  int n;
  printf("Please input an integer:");
  scanf("%d",&n);
  printf("The result is:%d",convert(n));
  return 0;	
   
}
