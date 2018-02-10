#include <iostream>
#include <cstdlib>
using namespace std;

const int maxn = 1000;
int a[maxn][maxn],b[maxn];              
//aΪѭ�����ճ̱����飬bΪ�������飬��n/2Ϊ����ʱ��������ճ̱� 

bool IsOdd(int n)                  //�жϲ���ѡ����n�Ƿ�Ϊ���� 
{
     return n&1; //��������1
}

/*
	�㷨copy�����Ͻǵݹ�������С���е��������ְ���
���λ�ó������½ǣ������Ͻ�С�����������ּ�n/2����
�������λ�ó������½Ǻ����Ͻǣ�������˱����ճ̱�
*/
void Copy(int n)                 	//��nΪż����ֱ�ӿ������� 
{
    int m=n/2;
    for(int i=1; i<=m; i++)
    	for(int j=1; j<=m; j++)
    	{
        	a[i][j+m] = a[i][j]+m;	//ͨ���ҹ��ɣ�������Ӧλ�õ�Ԫ�� 
        	a[i+m][j] = a[i][j+m];		
    		a[i+m][j+m] = a[i][j];  //�����Ͻ���Ӧλ�õ����������½�
   		}
}

void CopyOdd(int n)                 //����n/2Ϊ��������� 
{
	int m=n/2;
	for(int i=1; i<=m; i++)
	{
    	b[i]=m+i;
		b[m+i]=b[i];
	}
	for(int i=1; i<=m; i++)
	{
   		for(int j=1; j<=m+1 ;j++)
    	{
            if(a[i][j]>m)
			{
				a[i][j] = b[i];
				a[m+i][j] = (b[i]+m)%n;
			}
            else 
				a[m+i][j] = a[i][j]+m;
    	}
    	for(int k=2; k<=m;k++)
    	{
      		a[i][m+k]=b[i+k-1];
      		a[b[i+k-1]][m+k]=i;
    	}
	}
}

void MakeCopy(int n)       		//�����������Ԫ�ؿ��� 
{
     if(n/2>=2 && IsOdd(n/2))
	 	CopyOdd(n);
     else 
	 	Copy(n);
}

void Tournament(int n)
{
	if(n==1)
 		a[1][1]=1;
    else if(IsOdd(n))
	 	Tournament(n+1);
    else 
	{
		Tournament(n/2);
    	MakeCopy(n);
	}
}

int main()
{
    int n;
    bool b = 0;              //��Ϊ�жϲ���ѡ���Ƿ�Ϊ�����ı�� 
    cout << "�����������Ա����n(n>=2): ";
    cin  >> n;
	while(n < 2)
	{
		cout << "���벻�Ϸ�����������ڻ����2������!" << endl;
		cout << "�����������Ա����n(n>=2): ";
		cin  >> n;
	}
        
    Tournament(n);
    if(IsOdd(n))  //nΪ����
    {
    	n++;
    	cout << "0��ѡ��Ϊ�������ӣ�ʵ�ʱ�������ʱ���迼�ǡ�" << endl; 
    	b = 1;
    }   
    
	for(int i=1; i<=n; i++)
    {
    	for(int j=1; j<=n; j++)
    	{
    		
			if(j == 1)
    		    cout << "ѡ��";
			if(a[i][j]==n && b)
				a[i][j] = 0; 
			cout<<a[i][j]<< "  ";
    	}		
    	cout<<endl;
    }
    
    system("pause");
    return 0;
}
