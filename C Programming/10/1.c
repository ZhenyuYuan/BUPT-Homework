/*��ƺ�������str2ָ����ַ�����str1ָ����ַ������״γ��ֵ�λ��*/
#include<stdio.h>
#include<stdlib.h>
char *locatesubstr(char *str1,char *str2)
{
   int i = 0; 
   if( *str1 == '\0')
     return ("NULL");
   while( *(str1+i) == *(str2+i) && *(str2+i) != '\0' )
     i++;
   if( *(str2+i) == '\0')
     return str1;
   else  
     return locatesubstr(str1+1,str2); /*ʵ�ֵݹ�*/    
}
main()
{
   char s1[500],s2[500],*str1 = 0,*str2 = 0;   
   
   printf("Please input one string:");/*�����ַ���str1*/ 
   gets(s1);
   str1 = s1;   
  
   printf("Please input another string:");/*�����ַ���str2*/ 
   gets(s2);
   str2 = s2;   
  
   printf("The result is:%s\n",locatesubstr(str1,str2));/*���ú���locatesubstr()*/ 
   
   system("pause");
   return 0;	
}
