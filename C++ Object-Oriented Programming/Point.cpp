#include<iostream>
#include<stdlib.h>
#include<cmath>
using namespace std;


//Point�� 
class Point
{
public:
	Point(int x1, int y1, int x2, int y2);
	~Point(); 
	void distance(int x1, int y1, int x2, int y2);
private:
	int m_iX1, m_iY1, m_iX2, m_iY2;
	double m_iDistance;
};
Point::Point(int x1, int y1, int x2, int y2)
{
	m_iX1 = x1; 
	m_iY1 = y1;
	m_iX2 = x2;
	m_iY2 = y2;
	cout << "���캯��:Point(int x1, int y1, int x2, int y2)" << endl;
}
Point::~Point()
{
	cout << "���������� ~Point()" << endl;
}
void Point::distance(int x1, int y1, int x2, int y2)
{
	int xx = fabs(x1 - x2); 
	int yy = fabs(y1 - y2);
	xx *= xx;
	yy *= yy;
	m_iDistance = sqrt(xx+yy);
	cout << "�����ľ�����:" << m_iDistance << endl;
}
/*---------------------------------------------------------------------------*/
//������ 
class Rectangle
{
public:
	Rectangle(int x1, int y1, int x2, int y2);
	~Rectangle();
    void getArea(int x1, int y1, int x2, int y2);
private:
	int m_iX1, m_iY1, m_iX2, m_iY2;
	long m_lArea;
};
Rectangle::Rectangle(int x1, int y1, int x2, int y2)
{
	m_iX1 = x1; 
	m_iY1 = y1;
	m_iX2 = x2;
	m_iY2 = y2;
	cout << "���캯����Rectangle(int x1, int y1, int x2, int y2)" << endl;
}
Rectangle::~Rectangle()
{
	cout << "���������� ~Rectangle()" << endl;
}
void Rectangle::getArea(int x1, int y1, int x2, int y2)
{
	int xx = fabs(x1 - x2); 
	int yy = fabs(y1 - y2);
	m_lArea = xx * yy;
    cout << "���ε������:" << m_lArea << endl;
}
/*---------------------------------------------------------------------------*/

int main()
{	
	cout << "���������Ͻǵ�(X1, Y1):";
	int X1, Y1;
	cin >> X1 >> Y1;
	cout << "���������½ǵ�(X2��Y2):";
	int X2, Y2;
	cin >> X2 >> Y2;
	
	//������������ 
	Point poi(X1, Y1, X2, Y2);             //���ù��캯�� 
	poi.distance(X1, Y1, X2, Y2);
	poi.~Point();
	
	cout << "------------------------------------------------------------------" << endl;
	//���������� 
	Rectangle rec(X1, Y1, X2, Y2);         //���ù��캯��
	rec.getArea(X1, Y1, X2, Y2);
	rec.~Rectangle();
	
	system("pause");
	return 0;
}

