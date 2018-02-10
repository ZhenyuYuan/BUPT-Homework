#include<iostream>
#include<cstdlib>
using namespace std;

#define INFINITY 1000               //���ֵ
#define MAX_VERTEX_NUM 100          //��󶥵���
#define TRUE  1
#define FALSE 0  

typedef enum{                       //����ͼ���� 
	DG, DN, UDC, UDN
}GraphKind; 

typedef struct MGraph{            
    string vexs[MAX_VERTEX_NUM];      //��������
	int  arcs[MAX_VERTEX_NUM][MAX_VERTEX_NUM];    //�ڽӾ���
	int  vexnum, arcnum;            //ͼ��ǰ�������ͻ���
	GraphKind kind;                 //ͼ�������־ 
}MGraph;

void ShortestPath_Floyd(MGraph G, int D[][MAX_VERTEX_NUM], string P[][MAX_VERTEX_NUM])
{
	int v, w, k;
	for(v = 1; v <= G.vexnum; v++)
		for(w = 1; w <= G.vexnum; w++)
		{
			D[v][w] = G.arcs[v][w];
			P[v][w] = '*';
			if(D[v][w] < INFINITY)
			    P[v][w] = G.vexs[v] + G.vexs[w];
		}	
	for(k = 1; k <=G.vexnum; k++)
		for(v = 1; v <= G.vexnum; v++)
			for(w = 1; w <= G.vexnum; w++)
				if(D[v][k] + D[k][w] < D[v][w])
				{
					D[v][w] = D[v][k] + D[k][w];
					string S = P[k][w];
					S = S.substr(1,S.length()-1);
					P[v][w] = P[v][k] + S;
				}	    
}
int LocateVex(MGraph G, string vex)
{
	for(int i=1; i <=G.vexnum; i++)
	{
		if( vex == G.vexs[i])
		    return i;
	}
	return 0;
}

int main()
{
	MGraph G;
	int D[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
	string P[MAX_VERTEX_NUM][MAX_VERTEX_NUM], S;
	int v, w, k, weight;
	string V1, V2;
	 
	cout << "������ͼ�Ķ������ͻ���:" << endl;
	cin  >> G.vexnum >> G.arcnum;
	if(G.vexnum >= MAX_VERTEX_NUM)
    {
    	cout << "�������(����100���¸�����),���������붥�����ͻ���:";
        cin  >> G.vexnum >> G.arcnum;
    }     
	cout << "�밴�������˳�����붥��:" << endl;
	for(v = 1; v <= G.vexnum; v++)
	   cin >> G.vexs[v];

	for(v = 1; v <= G.vexnum; v++)             //��ʼ���ڽӾ��� 
	    for(w = 1; w <= G.vexnum; w++)
	    {
	    	if(v == w)
	        	G.arcs[v][w] = 0;
	        else
	            G.arcs[v][w] = INFINITY;
	    }
	   
    cout << "���������β��ͷ����·����Ȩֵ:" << endl;  
	for(k = 1; k <= G.arcnum; k++)             //����������Ķ��㼰��Ȩֵ 
	{
		cin >> V1 >> V2 >> weight;
		v = LocateVex(G, V1);
		w = LocateVex(G, V2);
		G.arcs[v][w] = weight;
	}    

	ShortestPath_Floyd(G, D, P);
			
    cout << "\nÿһ�Զ�������·����:" << endl;
    for(v = 1; v <= G.vexnum; v++)
		for(w = 1; w <= G.vexnum; w++)
		    if(v != w && D[v][w] != INFINITY)
		    {
		    	cout << G.vexs[v] << G.vexs[w] << "������·��Ϊ: " << P[v][w] 
			         << "\t\t\t" << "����Ϊ: " << D[v][w] << endl;
		    }
		
	system("pause");
	return 0;
}
