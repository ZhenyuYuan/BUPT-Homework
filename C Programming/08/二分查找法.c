/*��Ƶݹ麯���ö��ֲ����㷨����ֵΪkey������Ԫ�ص��±�*/
#include<stdio.h>
#include<stdlib.h>
int RecurBinarySearch(int a[],int left,int right,int key[],int j)/*��Ƶݹ麯��RecurBinarySearch()*/
{
  int middle;
  middle=(right+left)/2;
  if(left<=right)
  { 
    if(key[j]==a[middle])
       return middle;
    else 
     if(key[j]>a[middle])
	   return RecurBinarySearch(a,middle+1,right,key,j);
     if(key[j]<a[middle])
	   return RecurBinarySearch(a,left,middle-1,key,j);
  }
  if(left>right)  
    return -1;  
}
int main()
{
	int a[100000],key[100000],n,m,i,j,left,right;
	
	printf("Please input the number of integers:");/*��������n��������a��Ԫ�صĸ���*/
	scanf("%d",&n);	
	printf("Please input the number you want to search:");/*��������m������Ҫ���ҵ������ĸ���*/
	scanf("%d",&m);
	
	printf("Please input the integers:");/*����n���������������a��*/
	for(i=0;i<=n-1;i++)
	   scanf("%d",&a[i]);
	   
	printf("Please input the integers you want to search:");/*����m��Ҫ���ҵ���*/
	for(j=0;j<=m-1;j++)
	  scanf("%d",&key[j]);
	  
	printf("The elements'subscript in the array are:");
	for(j=0;j<=m-1;j++)
	 {	    
	    left=0;
	    right=n-1;	  	
	  	printf("%d ",RecurBinarySearch(a,left,right,key,j));/*�����Ӻ���RecurBinarySearch()*/
	  	if(j==m-1)
	  	  printf("\n");
	  } 
	  
	system("pause");
	return 0;
}
