#include<iostream>
#include<cstdlib>
using namespace std;

#define OK    1
#define ERROR 0

typedef struct BiTNode{				      	//�������ṹ����		
	char data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;

int CreateBiTree(BiTree &T)               	//������ݹ鷽ʽ���������� 
{
	char ch;									
  	cin >> ch;								//������Ԫ�� 
	if('*' == ch)  
	    T = NULL;
	else
	{
		if(!(T = new BiTNode))				//�����½�� 
	    	return ERROR;
		T->data = ch;                       //���ɸ��ڵ� 
		CreateBiTree(T->lchild);            //���������� 
		CreateBiTree(T->rchild);		    //���������� 
	}
	return OK;
}
int LeafNum(BiTree T)
{
	if(NULL == T)                           //���Ϊ����������0 
	    return 0;
	else
	{
		if(!(T->lchild)&&!(T->rchild))      //����Ȳ����������ֲ������Һ��ӣ���ý��ΪҶ�ӽ�㣬����1 
			return 1;
		else
		    return LeafNum(T->lchild)+LeafNum(T->rchild);   //�ݹ������������������ 
	}
}
void PrintTree(BiTree T, int t) 
{
	if(T)
	{
		for(int i=0; i<t; i++)
		    cout << " ";
		cout << T->data << endl;            //������Ԫ�� 
		PrintTree(T->lchild, t+2);          //�ݹ���������� 
		PrintTree(T->rchild, t+2);          //�ݹ���������� 
	}
}

int main()
{
	BiTree T;
	
	cout << "Please input a Binary Tree by PreOrder:" << endl;
	CreateBiTree(T);                                          //���������� 
	
	cout << "-------------------------" << endl;
	cout << "The number of Leaf is: " << LeafNum(T) << endl;  //����ö�������Ҷ����Ŀ 
	cout << "The Binary Tree is:" << endl;                    //�԰����ʽ��������� 
	PrintTree(T, 0);
	cout << "-------------------------" << endl; 
	
	system("pause");
	return 0;
} 
