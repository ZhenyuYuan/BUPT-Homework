/*���ַ�����ɾ��ָ���ַ�*/
#include<stdio.h>
void delcharfun(char str[],char ch)/*����delcharfun()�Ķ���*/
{
  int i;
  for(i=0;str[i]!='\0';i++)
  {
    while(str[i]==ch)  i++;         
    printf("%c",str[i]);                 
  }  
}
int main()
{
    char str[100],ch,i;
    printf("Please input the string:");/*�����ַ���*/  
    gets(str);
    printf("Please input the letter you want to delete:");/*������Ҫɾ�����ַ�*/
    scanf("%c",&ch);
    printf("The result is:");
    delcharfun(str,ch);
    system("pause");
    return 0;
}
