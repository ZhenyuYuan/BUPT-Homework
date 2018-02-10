/*�����ǰ��ʱ���������ص�ǰ�����ֵ���������á�
�����������ʱ�����������ؽ�������ǰ��ֵ���ʲ�������*/ 
#include<iostream>
#include<stdlib.h>
using namespace std;

class Point
{
public:
	Point (int x, int y);
	~Point() {};
	Point &operator++();					//ǰ��++
	Point  operator++(int);					//����++,��int�������� 
	Point &operator--();					//ǰ��-- 
	Point  operator--(int);					//����-- ��int�������� 
	void get_XY();
private:
	int m_iX, m_iY;	
};

Point::Point(int x, int y)
{
	m_iX = x;
	m_iY = y;
}

Point &Point::operator++()
{
	m_iX ++;
	m_iY ++;
	return *this;
}

Point Point::operator++(int)
{
	Point old(*this);          				//������ʱ����old������ֱ�Ӹ�ֵ�ķ�����ʹ��Ĭ�Ͽ������캯�� 
	this -> m_iX ++;
	this -> m_iY ++;
	//return *this;							
	return old; 							 //ʵ�ַ���this++֮ǰ��ֵ
}

Point &Point::operator--()
{
	m_iX --;
	m_iY --;
	return *this;
}

Point Point::operator--(int)
{
	Point old(*this);          				//������ʱ����old������ֱ�Ӹ�ֵ�ķ�����ʹ��Ĭ�Ͽ������캯�� 
	this -> m_iX --;
	this -> m_iY --;
	//return *this; 							//ʵ�ַ��� this-- ֮ǰ��ֵ 
	return old;
}

void Point::get_XY()
{
	cout << "(x, y) = ";
	cout << "(" << m_iX << ", ";
	cout << m_iY << ")" << endl;
}

int main()
{
	int x, y;
	
	cout << "������ x , y :";
	cin >> x >> y;
	Point poi1(x, y);	
	cout << " ++point1 : "; 
	(++poi1).get_XY();
	
	//cout << "������ x , y :";
	//cin >> x >> y;
	Point poi2(x, y);
	cout << " point2++ : ";
	(poi2++).get_XY();
	
	//cout << "������ x , y :";
	//cin >> x >> y;
	Point poi3(x, y);
	cout << " --point3 : "; 
	(--poi3).get_XY();
	
	//cout << "������ x , y :";
	//cin >> x >> y;
	Point poi4(x, y);
	cout << " point4-- : ";
	(poi4--).get_XY();
	
	system("pause");
	return 0;
}
