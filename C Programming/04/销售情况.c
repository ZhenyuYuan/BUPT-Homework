#include<stdio.h>
#include<stdlib.h>
int main()
{
	
 double s=0;
 int a=1,b,i;
 printf("��������һ��������������������Ʒ�ţ�������������Ʒ��Ϊ-1��������������\n");
 for(i=1;i<=5;i++)
  { 
   printf("��%d�������\n",i);
   do
   {
    scanf("%d",&a);
    if(a!=-1)
     {
   	  scanf(",%d",&b);
      switch(a)
      {
       case 1:
     	 s=s+b*2.98;
     	 break;
       case 2:
     	 s=s+b*4.50;
         break;
       case 3:
    	 s=s+b*9.98;
    	break;
       case 4:
         s=s+b*4.49;
         break;
       case 5:
         s=s+b*6.87;
         break;
   	  }
     }
   }   
   while(a!=-1);
  }
  printf("���������ܶ�Ϊ%lf",s);
  system("pause");
  return 0;
}
