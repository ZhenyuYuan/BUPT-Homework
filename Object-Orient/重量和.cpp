#include<iostream>
#include<stdlib.h>
using namespace std;

class Car;                                              //����Car�� 

//Boat�� 
class Boat
{
public:
	friend double TotalWeight(Boat &b, Car &c);         //������Ԫ���� 
	Boat(double weighe1);
	~Boat(){};
private:
	double m_dWeight1;	
};
Boat::Boat(double weight1)
{
	m_dWeight1 = weight1;
}

//Car�� 
class Car
{
public:
	friend double TotalWeight(Boat &b, Car &c);         //������Ԫ���� 
	Car(double weight2);
	~Car(){};
private:
    double m_dWeight2;	
};
Car::Car(double weight2)
{
	m_dWeight2 = weight2;
}

double TotalWeight(Boat &b, Car &c)
{
	return b.m_dWeight1 + c.m_dWeight2;
}


int main()
{
	cout << "����������Ʒ������:";
	double w1, w2;
	cin >> w1 >> w2;
	
	Boat B(w1);
	Car  C(w2);
	
	cout << "����Ʒ����������:" << TotalWeight(B, C) << endl;
	
	system("pause");
	return 0;
}
