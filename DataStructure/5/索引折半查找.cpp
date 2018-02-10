#include<iostream>
#include<cstdlib>
using namespace std;

typedef struct{
	int maxkey;        //ÿ�����ؼ��� 
	int stadr;         //ÿ����ʼλ�� 
	int blocksize;     //ÿ��ؼ��ָ��� 
}indexItem;            //������ 
typedef struct{ 
	int key;           //������ 
}indexTable;

int MaxKey(indexItem block[], indexTable s[], int keynum, int a)    //�õ�ÿ������ؼ��� 
{
	int i, j, k;
	int stadress = block[a].stadr;
	int max = s[stadress].key;
	for(i = block[a].stadr; (i < block[a].stadr+block[a].blocksize) && (i <= keynum); i++)
		max = (s[i].key > max) ? s[i].key: max;
	return max;
}

int Search(indexItem block[], indexTable s[], int a, int key, int &address, int keynum)		//�ڿ���˳����� 
{
	int i;
	for(i = block[a].stadr; (i < block[a].stadr+block[a].blocksize) && (i <= keynum); i++)
    {
    	if(key == s[i].key)
    	{
    		address = i;
			return 1;
		}	 
    }
    return 0;
}

int BinSearch(indexItem block[], indexTable s[], int low, int heigh, int key, int &address, int keynum)    //�ݹ�ʵ���۰���� 
{
	int middr;              //�м���λ�� 
	int midmax;             //�м������ؼ��� 

	while(low <= heigh)
	{
		middr  = (low + heigh)/2;
		midmax = block[middr].maxkey;
	 
	    if(key <= midmax && middr > 1 && key > block[middr-1].maxkey)
			return Search(block, s, middr, key, address, keynum);
		else if(middr == 1)
		{
			return Search(block, s, middr, key, address, keynum);
		}	
    	else 
		    if(key > midmax)     
		    {
				low = middr+1;
				return BinSearch(block, s, low, heigh, key, address, keynum);
			} 
        	else
			{
				if(middr > 1)
				{
				    heigh = middr-1;
				    return BinSearch(block, s, low, heigh, key, address, keynum);
				}
				if(middr == 1)
				{
					heigh = middr;
					return BinSearch(block, s, low, heigh, key, address, keynum);
				}
				
			}  
		return 0;
	}
}

int main()
{
	int keynum, blocknum, i, j, k=1;
	int key;  									//�����ҵĹؼ��� 
	int address = -1;             				//�����ҹؼ����������е�λ�� 
	
	cout << "����ؼ��ָ���:";
	cin  >> keynum;
	indexTable s[keynum+1];                     //�������� 
	
	while(k=1)
	{
		cout << "����Ҫ�ֿ����:";
	    cin  >> blocknum;
	    if(blocknum > keynum)
	        cout << "\n����!�ֿ鲻�Ϸ�,�����·ֿ�!\n" << endl;
	    else
	        break;
	}
	indexItem block[blocknum+1];                //���������� 
	
	cout << "����ÿ��ؼ��ָ���:";
	for(int num=0, i = 1; i <= blocknum; i++)
	{	
		cin >> block[i].blocksize;
		num += block[i].blocksize;
		if(i == blocknum && num != keynum)
		{
			cout << "\n����!�����·����!\n" << endl;
			i = 0;
			num = 0; 
			cout << "����ÿ��ؼ��ָ���:";
		}
	}	
	
	cout << "�밴�����ֿ�����ʽ����ؼ���:" << endl;          //�������� 
	for(i = 1; i <= keynum; i++)
	    cin >> s[i].key;	
	cout << "�������ɹ�,Ϊ:" << endl;
	for(i = 1; i <= keynum; i++)
	    cout << s[i].key << " ";
	
	cout << "\n�ֿ����Ϊ:" << endl;
	for(i = 1,j = 1; j <= blocknum; j++)
	{
		block[j].stadr = i;
		for(k = 1; k <= block[j].blocksize; k++)
	    {
			cout << s[i].key << " ";
			i++;
	    }    
	    cout << "\n";
	}    
    
    for(i = 1; i <= blocknum; i++)
        block[i].maxkey = MaxKey(block, s, keynum, i);
	cout << "ÿ������ؼ���Ϊ:" << endl;
	for(i = 1; i <= blocknum; i++)
        cout << block[i].maxkey << " ";
	
	cout << "\n������Ҫ���ҵ�Ԫ��(������������,������-1):" << endl;
	cin  >> key;
	while(key != -1)
	{
		if(key != -1)
	    {
			if(BinSearch(block, s, 1, blocknum, key, address, keynum) == 1)
		    	cout << "���ҳɹ�,�ùؼ������ڱ���λ��Ϊ:" << address << endl;
			else
		  	  	cout << "����ʧ��,��Ԫ�ز��ڱ���!" << endl;
		}
		cout << "������Ҫ���ҵ�Ԫ��(������������,������-1):" << endl;
		cin  >> key;
		address = -1;
	}

	system("pause");
	return 0;
} 
