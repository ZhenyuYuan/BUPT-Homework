/*��ά��̬����*/
#include<stdio.h>
#include<stdlib.h>
int **Creatr2(int n,int m)
{   
    int **array;
    int i; 
	array=(int **)malloc(sizeof(int *)*n);/*��������Ϊn�Ķ�ָ̬������*/	
	for(i=0;i<=n-1;i++)
	  array[i]=malloc(sizeof(int)*m);/*��������Ϊm������ָ������*/	
    return array;
}
main()
{
	int **array,n,m,i,j;
	
	printf("Please input n and m:");/*����n��m*/
	scanf("%d %d",&n,&m);
	printf("Please input %d integers:\n",n*m);/*����n*m������*/
	
	array=Creatr2(n,m);/*�����Ӻ���*/
	
	if(array==NULL)/*�ж��Ƿ�ɹ����䵽�ڴ�*/
	  printf("Out of memory\n");
	else
	  for(i=0;i<=n-1;i++)
	  {
	    for(j=0;j<=m-1;j++)		
		  scanf("%d",*(array+i)+j); 
	  }	
	
	for(i=0;i<=n-1;i++)/*�������*/
	  {
	    for(j=0;j<=m-1;j++)
		{
		  printf("%d ",*(*(array+i)+j)*(-10)) ; 
	    }
	    printf("\n");
	  }	
	
	for(i=0;i<n;i++)/*�ͷ�һά��������*/ 
	  free(array[i]);
	free(array);/*�ͷ�ָ������*/

	system("pause");
	return 0;	 	  
}

