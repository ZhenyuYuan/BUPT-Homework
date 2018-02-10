// MergeSort2
#include <iostream>
#include "Sort.h"
using namespace std;

void Merge(int c[], int d[], int l, int m, int r, long long &CompNum, long long &MoveNum)
{
	int i = l, j = m, k = l;
	while( i < m && j < r )
	{
		if(c[i] < c[j])	d[k++] = c[i++];
		else	d[k++] = c[j++];
	}
    CompNum += k;
    
	if(i >= m)
	{
		for(int q = j; q <= r; q++)
			d[k++] = c[q];
	}
	else
		for(int q = i; q < m; q++)
			d[k++] = c[q];
}

void MergePass(int x[], int y[], int s, int n, long long &MoveNum, long long &CompNum)
{
	int i = 0;
	while(i <= n-2*s)
	{	//�ϲ���СΪs������2�������� 
		Merge(x, y, i, i+s, i+2*s, CompNum, MoveNum);
		i += 2*s;
	}
	//ʣ�µ�Ԫ�ظ�������2s 
	if(i+s < n)		Merge(x, y, i, i+s, n, CompNum, MoveNum);
	else
		for(int j = i; j < n; j++)
		{
			y[j] = x[j];
		}	
	
	MoveNum += n;
}

//�ϲ������㷨 
void MergeSort(int a[], int n, long long &CompNum, long long &MoveNum)
{
	int *b = new int[n];
	int s = 1;
	while(s < n)
	{
		MergePass(a, b, s, n, MoveNum, CompNum);		// �ϲ�������b 
		s += s;
		MergePass(b, a, s, n, MoveNum, CompNum);		// �ϲ�������a 
		s += s;
	}
}
