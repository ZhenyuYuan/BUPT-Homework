/*���ַ������ÿո�ָ��ĵ��������*/
#include<stdio.h>
#include<stdlib.h>
main()
{
	char s0[10000],*str=NULL,*s[10000]={NULL};
	int i,j=0;
	printf("Please input a string:");/*�����ַ���*/
	gets(s0);/*��������ַ�����������s0��*/
    str=s0;/*ָ��strָ������s0*/ 
    s[j]=str;
		
	while(*(str+1)!='\0')
	{	
	  str++; 
	  if(*str==' ')
	   {
	     *str='\0';/*��ÿ�����ʺ�Ŀո��Ϊ"\0"*/
	     j++;
	     s[j]=str+1;	     
	   }		  	  
	}
	
	printf("The result is:\n");/*ʹ��ָ�����齫ÿ���������*/
	for(i=0;i<=j;i++)
	   printf("%s\n",s[i]);
	
	system("pause");
	return 0;
}
