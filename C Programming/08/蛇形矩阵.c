/*���ξ���*/
#include<stdio.h>
#include<stdlib.h>
int a[100][100];
void getMatrix(int n)
{
 int i,j,num=1;
 for(i=1;i<=n;i++)/*������1~n*n�������ε�˳��װ��һ��n*n�ľ�����*/
    for(j=1;j<=i;j++)
    {
      if(i%2==0) a[i+1-j][j]=num;
      else a[j][i+1-j]=num;
      num++;
    }
  for(i=n+1;i<2*n;i++)
    for(j=1;j<=2*n-i;j++)
    {
      if(i%2==0) a[n+1-j][i-n+j]=num; 
      else a[i-n+j][n+1-j]=num;
      num++;
    }
}

main()
{
  int i,j,n;
  printf("Please input order of the snake matrix:");/*����һ������n,�������ξ���Ľ���*/ 
  scanf("%d",&n);
  
  getMatrix(n);/*�����Ӻ���*/
  
  printf("The snake matrix is:\n");/*������ξ���*/
  for(i=1;i<=n;i++)
   {    
     for(j=1;j<=n;j++)
        printf("%d ",a[i][j]);
	 printf("\n");
   }
   
   system("pause");
   return 0;
}
