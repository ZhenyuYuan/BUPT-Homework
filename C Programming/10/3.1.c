/*һά��̬����*/
#include<stdio.h>
#include<stdlib.h>
int *array;
int *Create1(int n)
{
	array=malloc(sizeof(int)*n); /*����һά����*/
	return array;
}
main()
{
	int n,i;
	
	printf("Please input n:");
	scanf("%d",&n);
	
	array=Create1(n);/*�����Ӻ���*/
	
	if(array==NULL)/*�ж��Ƿ�ɹ����䵽�ڴ�*/
	  printf("Out of memory\n");
	else
	{
	 printf("Please input %d integers:\n",n);
	 for(i=0;i<=n-1;i++)
	   scanf("%d",array+i);
    }    
    for(i=0;i<=n-1;i++)/*�������*/
	{
	  printf("%d ",*(array+i)*(-10));
	  if(i==n-1)
	    printf("\n");
    }
	free(array);/*�ͷ�һά����*/
    array=NULL;
	
	system("pause");
	return 0;	
}
