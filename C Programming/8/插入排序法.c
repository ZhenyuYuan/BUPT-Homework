/*�ò������򷨽�����a��Ԫ�ذ�������ʽ����*/
#include<stdio.h>
#include<stdlib.h>
void InsertSort(int a[],int n)/*�����Ķ���*/
{
  int i,j,x;
  for(i=2;i<=n;i++)
  { 
    x=a[i]; 
	j=i-1;  
    while(x<a[j]&&j>=1)      	      
	{	 
	  a[j+1]=a[j];	 	 	 
	  j--;
	}   
	a[j+1]=x;
  }
}
int main()
{
  int a[1000],n,i;
  printf("Please input the number of integer:");/*��������n���������Ԫ�صĸ���*/
  scanf("%d",&n);
 
  printf("Please input the integers:");/*����n������*/
  for(i=1;i<=n;i++)
    scanf("%d",&a[i]);      
  
  InsertSort(a,n);/*���ú���InsertSort()*/
  
  printf("The result is:"); 
  for(i=1;i<=n;i++)/*������к������*/
    printf("%d ",a[i]);
  system("pause");
  return 0;
}
