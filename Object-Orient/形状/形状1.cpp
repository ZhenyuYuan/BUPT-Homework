#include<iostream>
#include<stdlib.h>
using namespace std;

#define PI 3.1415

class Shape                								//����Shape 
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
    double getArea()
	{
		return 0;
	} 
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
    	return m_dLen * m_dWide;
    }
private:
    double m_dLen, m_dWide;	
};

class Circle: public Shape								//������Circle
{
public:
	Circle(double r)
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
        return PI * m_dR * m_dR;
	}
private:
	double m_dR;
};

class Square: public Rectangle
{
public:
	Square(double x):Rectangle(x, x) 
	{
	    x = m_dX;
		cout << "Square()" << endl;
	}
	~Square()
	{
		cout << "~Square()" << endl;
	}
private:
    double m_dX;	
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
	
	double x;
	cout << "�����������εı߳���";
	cin >> x;
	Square Squ(x);
	cout << "�����ε�����ǣ�" << Squ.getArea() << endl; 
	
	system("pause");
	return 0;
}
