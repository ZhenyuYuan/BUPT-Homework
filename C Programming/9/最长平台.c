/*�ƽ̨*/
#include<stdio.h>
int main()
{
    int a[1000],i,n,num,x=1,level=1;
    printf("Please input the number of integer:");
    scanf("%d",&n);/*n��������Ԫ�صĸ���*/ 
    printf("Please input the integers:");
    for(i=0;i<=n-1;i++)    
    {
      scanf("%d",&a[i]);    
      if(i>=1)
      {
        if(a[i]==a[i-1])
          x++;
        else
        { 
          if(x>=level)
            level=x;
          x=1;
        }
      }            
    }
    printf("The result level is:%d",level);/*levelΪ�ƽ̨�ĳ���*/
    system("pause");
    return 0;
}
