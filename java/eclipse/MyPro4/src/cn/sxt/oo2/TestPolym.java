package cn.sxt.oo2;
/**
 * ���Զ�̬
 * 1.�̳�
 * 2.��д
 * 3.��������ָ���������Dog ���� Animal �Ĳ�������
 * 
 * Animal d=new Dog();   ʵ�ֵ���Dog�Ĺ���
 * @author tonic
 *
 */

public class TestPolym {
	public static void main(String[] args) {
		Animal a=new Animal();
		animalCry(a);
		Animal d=new Dog();  //�Զ�����ת��
		animalCry(d);
		animalCry(new Cat());
		
		Animal c=new Cat();
		
		Dog d2=(Dog) d;   //ǿ������ת��
		d2.seeDoor();
		
		Dog d3=(Dog) c;
		d3.seeDoor();
		
		
	}
	
	static void animalCry(Animal a) {
		a.shout();
	}
}


class Animal{
	public void shout() {
		System.out.println("����һ��");
	}
}

class Dog extends Animal{
	public void shout() {
		System.out.println("������");
	}
	
	public void seeDoor() {
		System.out.println("����!!!");
	}
}

class Cat extends Animal{
	public void shout() {
		System.out.println("������");
	}
}