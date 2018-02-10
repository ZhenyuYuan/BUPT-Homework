#include<iostream>
#include<string>
#include<fstream>
#include<stdlib.h>
using namespace std;

class Contact
{
public:
	Contact();                                         //���캯��
	~Contact() {};                                     //Ĭ����������
	void Item();                                       //��ʾ�û�������Ӧ�Ĳ���
	void Search();                                     //������ϵ��
	void Renew();                                      //������ϵ��
	void Add();                                        //�����ϵ��
	void Del();                                        //ɾ����ϵ��
	void Exit();                                       //�˳�����
private:
	string m_sName[10];                                //���� 
	string m_sPhonum[10];                              //�绰���� 
	int m_iN;                                          //�绰������ 
};
 

Contact::Contact()
{
    cout << "------------------------------------------------------------------------------" << endl;
	cout << "\t\t\t\t   Contacts Book" << endl;
	cout << "------------------------------------------------------------------------------" << endl;
	cout << "\t\t\t\t<1> Search contacts" << endl;
	cout << "\t\t\t\t<2> Renew  contacts" << endl;
	cout << "\t\t\t\t<3> Add    contacts" << endl;
	cout << "\t\t\t\t<4> Delete contacts" << endl;
	cout << "\t\t\t\t<5> Exit   program"  << endl;
    cout << "------------------------------------------------------------------------------" << endl;
    
    fstream file1;
    file1.open("contactBook.txt", ios::in | ios::out);		            //�����������ʽ���ļ�contactBook.txt 
    if(file1.fail()) 								            		//�ж��ļ��Ƿ�򿪳ɹ�
	{
		cout << "File does not find." << endl;
		cout << "Exit programe." << endl;
		exit(0);
	}
    
    string str;
    m_iN = 0;
    while(getline(file1,str))
        m_iN ++;
	
	
	fstream file;
    file.open("contactBook.txt", ios::in | ios::out);
	for(int i=0; i <= m_iN; i ++)
        file >> m_sName[i] >> m_sPhonum[i]; 
    
    file1.close();
    file.close();
	Item();
}

void Contact::Item()
{
	cout << "------------------------------------------------------------------------------" << endl;
	cout << "\t\tPlease input operator 1 ~ 5 you want to do:";
	int ope;
	cin >> ope;
	switch(ope)
	{
		case 1: Search(); break;
		case 2: Renew();  break;
		case 3: Add();    break;
		case 4: Del();    break;
		case 5: Exit();   break;
	}
}

void Contact::Search()
{
	string name;
	cout << "\t-------------------------------------------------------------" << endl;
	cout << "\t\tPlease input name you want to search:";
	cin >> name;
	
	int is = 0;
	int i, m=0;
	for(i=0; i <= m_iN-1; i ++)
	{
		if(m_sName[i] == name){
			is = 1;
			m = i;
			break;
		}	
	}
	
	if(1 == is)
		cout << "\t\tFound!  " << m_sName[m] << "'s phone number is:" << m_sPhonum[m] << endl;
	if(0 == is)
	    cout << "\t\tNot found!" << endl;	
	
	Item();
}

void Contact::Renew()
{
	string name;
	string num;
	cout << "\t-------------------------------------------------------------" << endl;
	cout << "\t\tPlease input name you want to renew:";
	cin >> name;
	
	ofstream file;
	file.open("contactBook.txt");
	
	int is = 0;
	int i, m=0;
	for(i=0; i <= m_iN; i ++)
	{
		if(m_sName[i] == name){
			is = 1;
			m = i;
			break;
		}	
	}
    
    int ope;
	if(is == 1)
	{
		cout << "\t\tFound this contact!" << endl;
		cout << "\t\t<1>Renew name\n\t\t<2>Renew phone number\n\t\t<3>Renew both name and phone number" << endl;
		cin  >> ope;
		switch(ope){
			case 1:
				cout << "\t\tPlease input new name:";
				cin >> name;
				m_sName[m] = name;
				break;
			case 2:
				cout << "\t\tPlease input new phone number:";
				cin >> num;
				m_sPhonum[m] = num;
				break;	
			case 3:
				cout << "Please input new name and new phone number:";
				cin >> name >> num;
				m_sName[m]   = name;
				m_sPhonum[m] = num;
				break;
		}
		cout << "\t\tSuccessful!" << endl;
	}
		
	if(is == 0)
	    cout << "\t\tNot found!" << endl;
	
	for(i = 0; i <= m_iN-1; i++)
	    file << m_sName[i] << " " <<  m_sPhonum[1] << endl;	  
    
	file.close();
	Item();
}

void Contact::Add()
{
	string name;
	string num;
	cout << "\t\tPlease input the name and phone number you want to add:";
	cin >> name >> num;
	m_sName[m_iN]   = name;
	m_sPhonum[m_iN] = num;
	m_iN++;
	
	ofstream file;
	file.open("contactBook.txt");
	
	for(int i = 0; i <= m_iN-1; i++)
	    file << m_sName[i] << " " <<  m_sPhonum[i] << endl;
	    
	cout << "\t\tSuccessful!" << endl;
	
	file.close();
	Item();
}

void Contact::Del()
{
	string name;
	string num;
	cout << "\t-------------------------------------------------------------" << endl;
	cout << "\t\tPlease input name you want to delete:";
	cin >> name;
	
	ofstream file;
	file.open("contactBook.txt");
	
	int is = 0;
	int i, m=0;
	for(i=0; i <= m_iN; i ++)
	{
		if(m_sName[i] == name){
			is = 1;
			m = i;
			break;
		}	
	}
	if(is == 1)
	{
	    for(i = m; i <= m_iN-2; i++)
	    {
	    	m_sName[i] = m_sName[i+1];
	    	m_sPhonum[i] = m_sPhonum[i+1];
	    }
	}
	if(is == 0)
	    cout << "\t\tNot found!" << endl;
	
	for(i = 0; i <= m_iN-1; i++)
	    file << m_sName[i] << " " <<  m_sPhonum[i] << endl;	
	    
	cout << "\t\tSuccessful!" << endl;
    
    file.close();
	Item();
}

void Contact::Exit()
{
	cout << "------------------------------------------------------------------------------" << endl;
	cout << "\t\t\t\tExit program!" << endl;
	cout << "------------------------------------------------------------------------------" << endl;
	exit(0);                                                            //�˳����� 
}

int main()
{
	Contact con;														//������ϵ�˶���
	
	system("pause");
	return 0;
}
