#include <iostream>
using namespace std;

class Complex
{
private:
	double real;
	double imag;
public:
	Complex(double r=0,double i=0)
	{
		real = r;
		imag = i;
	}
	Complex complex_add(Complex &c2);
	void display()
	{
		cout<<"("<<real<<","<<imag<<"i)"<<endl;
	}
};

Complex Complex::complex_add(Complex &c2)
{
	Complex c;
	c.real=real+c2.real;
	c.imag=imag+c2.imag;
	return c;
}


int main()
{
	Complex c1(3,4), c2(5,-10), c3;
	c3 = c1.complex_add(c2);
	cout<<"c1=";
	c1.display();
	cout<<"c2=";
	c2.display();
	cout<<"c1+c2=";
	c3.display();
	return 0;
}