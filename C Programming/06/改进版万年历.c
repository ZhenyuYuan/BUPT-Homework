/*������*/
#include<stdio.h>
int isLeap(int year)/*����isLeap�Ķ���(�ж�year���Ƿ�Ϊ����)*/
{
  if(year%400==0) return 1;
  if(year%100==0) return 0;
  if(year%4==0)   return 1;
  return 0;   
}

int GetMonthDays(int year,int month)/*����GetMonthDays�Ķ��壨����year��month�µ�������*/
{  
 switch (month)
 { 
   case 1:case 3:case 5:case 7:case 8:case 10:case 12:
 	return 31;
 	break;
   case 2:
	return 28+isLeap(year);
	break;
   default:
	return 30;
	break;
 } 
}

int GetWeekDay(int year,int month,int day)/*����GetWeekDay�Ķ��壨����year��month��day�������ڼ���*/
{ 
  int days,i;/*daysΪ��Ԫ0001��1��1�յ���year-1��12��31�յ�������*/
  days=(year-1)*365+(year-1)/400+(year-1)/4-(year-1)/100;
  for(i=1;i<=(month-1);i++)
    day=day+GetMonthDays(year,i);
  return (days+day)%7;
}

void PrintMonthCalender(int startDay,int days)/*����PrintMonthCalender�Ķ��壨��Ҫ����ʽ���ĳ�µ�������*//* startday��ʾ����1�������ڼ�,days��ʾ���¹��м���*/
{
  int i;
  printf("Sun.\tMon.\tTue.\tWed.\tThu.\tFri.\tSat.\n");
  for(i=1;i<=startDay;i++)
	printf("\t");
  for(i=1;i<=days;i++)
   {
     printf("%d\t",i);
     if((i-(7-startDay))%7==0)
        printf("\n");
   }
}

int main()
{
  
  int year,month;
  printf("Please input year and month:");
  scanf("%d%d",&year,&month);
  printf("\t\t\t%d-%d\n",year,month);
  PrintMonthCalender(GetWeekDay(year,month,1),GetMonthDays(year,month));         
  return 0;
  
}
