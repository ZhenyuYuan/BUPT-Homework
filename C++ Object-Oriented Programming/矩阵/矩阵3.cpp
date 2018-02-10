#include<iostream>
#include<stdlib.h>
#include<iomanip>
using namespace std;

int i, j;

//��������� 
class Matrix
{
public:
    int **m_iPtr;
    Matrix();
	Matrix(int line, int row);
	Matrix(Matrix & A);
	~Matrix();
	void initMatrix();
	void getMatrix(Matrix & A);
	void sumMatrix(Matrix & A1, Matrix & A2, Matrix & B);
	void subMatrix(Matrix & A1, Matrix & A2, Matrix & B);
private:
	int m_iLine, m_iRow;	
}; 

Matrix::Matrix()                     								//Ĭ�Ϲ��캯����������������̬������� 
{
	cout << "Please input lines and rows:";
	cin >> m_iLine >> m_iRow;
	m_iPtr = new int *[m_iLine];
	if(NULL != m_iPtr)
	{
		for(i = 0; i <= m_iLine - 1; i++)
	   		m_iPtr[i] = new int[m_iRow];
	}
}

Matrix::Matrix(int line, int row)   								//���캯���������Ǿ�����к��� 
{
	m_iLine = line;
	m_iRow  = row;
	m_iPtr = new int *[m_iLine];
	if(NULL != m_iPtr)
	{
		for(i = 0; i <= m_iLine - 1; i++)
	   		m_iPtr[i] = new int[m_iRow];
	}
}

Matrix::Matrix(Matrix &A)          									//�������캯��������͸��ƾ��� 
{
	m_iPtr = new int *[A.m_iLine];
	for(i = 0; i <= A.m_iLine-1; i++)
	   m_iPtr[i] = new int[A.m_iRow];
	m_iLine = A.m_iLine;
	m_iRow  = A.m_iRow;
}

Matrix::~Matrix()                  									//�������� ���ͷ��ڴ� 
{
	for(i = 0; i <= m_iLine-1; i++)
	    	delete []m_iPtr[i];
	delete []m_iPtr;
	//m_iPtr = NULL;
}

void Matrix::initMatrix()											//��ʼ�����飬�������Ԫ�� 
{
	cout << "Please input a " << m_iLine << "*" << m_iRow << " matrix:" << endl;
	for(i = 0; i <= m_iLine-1; i ++)
		for(j = 0; j <= m_iRow-1; j++)		
			cin >> m_iPtr[i][j];
}

void Matrix::getMatrix(Matrix &A)									//�������Ԫ�� 
{
	for(i = 0; i <= m_iLine-1; i ++)
	{
		for(j = 0; j <= m_iRow-1; j++)		
			cout << setw(6) << m_iPtr[i][j];
		cout << endl;	
	}	
}

void Matrix::sumMatrix(Matrix &A1, Matrix &A2, Matrix &B)			//����������֮�� 
{
	for(i = 0; i <= m_iLine-1; i ++)
		for(j = 0; j <= m_iRow-1; j++)		
			B.m_iPtr[i][j] = A1.m_iPtr[i][j] + A2.m_iPtr[i][j];
	
	cout << "The sum of tow matrixes is:" << endl; 					//����¾��� 
	getMatrix( B );
}

void Matrix::subMatrix(Matrix &A1, Matrix &A2, Matrix &B)			//����������֮�� 
{
	for(i = 0; i <= m_iLine-1; i ++)
		for(j = 0; j <= m_iRow-1; j++)		
		    B.m_iPtr[i][j] = A1.m_iPtr[i][j] - A2.m_iPtr[i][j];
	
	cout << "The subtraction of tow matrixes is:" << endl;
    getMatrix( B );													//����¾��� 
}

int main()
{
	int m, n;
	
	Matrix A1;                                                      //����Ĭ�Ϲ��캯�� 
	Matrix A2(A1);                                                  //���ÿ������� 
	Matrix A3(A1);                                                  //���ÿ������� 
	  
	A1.initMatrix();                                                //��ʼ������A1 
	A2.initMatrix();                                                //��ʼ������A2 
	
	A3.sumMatrix(A1, A2, A3);                                       //�������A1��A2֮�� 
	A3.subMatrix(A1, A2, A3);                                       //�������A1��A2֮�� 
	
	//A1.~Matrix();
	//A2.~Matrix();
	//A3.~Matrix();
	
	system("pause");
	return 0;
}
