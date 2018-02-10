/*������(�������麯������)���ܴ�������,�������麯���Ŀ��Դ�������*/
/*���麯��ֻ�ж���û��ʵ�֣����麯�����ж�������ʵ��*/
#include<iostream>
#include<stdlib.h>
using namespace std;

#define PI 3.1415

class Shape                								//����Shape �������ࣩ 
{
public:
    Shape()
    {
    	cout << "Shape()" << endl; 
    }
    ~Shape()
    {
    	cout << "~Shape()" << endl;
    }
    virtual double getArea() = 0;						//���崿�麯�� 
};

class Rectangle: public Shape							//������Rectangle
{
public:
    Rectangle(double l, double w)
    {
		m_dLen  = l;
		m_dWide = w;
		cout << "Rectangle()" << endl;
    }
    ~Rectangle()
    {
    	cout << "~Rectangle()" << endl;
    }
    double getArea()
    {
    	double area = m_dLen * m_dWide;
    	return area;
    }
private:
    double m_dLen, m_dWide;	
};

class Circle: public Shape								//������Circle
{
public:
	Circle(int r)
	{	
		m_dR = r;
		cout << "Circle()" << endl;
	}
	~Circle()
	{
		cout << "~Circle()" << endl;
	}
	double getArea()
	{
		double area = PI * m_dR * m_dR;
        return area;
	}
private:
	double m_dR;
};

class Square: public Rectangle
{
public:
	Square(double x):Rectangle(x, x) 
	{
	    cout << "Square()" << endl;
	}
	~Square()
	{
		cout << "~Square()" << endl;
	}	
};

int main()
{
	double l, w;
	cout << "��������εĳ��Ϳ�";
	cin >> l >> w; 
	Rectangle Rec(l, w);
	Shape *p1 = &Rec;
	cout << "���ε�����ǣ�" << Rec.getArea() << endl;
	cout << "���ε�����ǣ�" << p1 -> getArea() << endl;
	
	double r;
	cout << "������Բ�İ뾶��";
	cin >> r;
	Circle Cir(r);
	cout << "Բ������ǣ�" << Cir.getArea() << endl;
	
	cout << "�����������εı߳���";
	cin >> l;
	Square Squ(l);
	cout << "�����ε�����ǣ�" << Squ.getArea() << endl; 
	
	system("pause");
	return 0;
}
