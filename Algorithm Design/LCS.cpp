//����������� 
#include <iostream>
#include <cstdlib>
using namespace std;

void LCSLength(int m, int n, char *x, char *y, int **c, int **b)
{
	int i, j;
	for(i = 1; i <= m; i++)           //��Ҫ�ں����г�ʼ�� 
		c[i][0] = 0;
	for(i = 1; i <= n; i++)
		c[0][i] = 0;
}
