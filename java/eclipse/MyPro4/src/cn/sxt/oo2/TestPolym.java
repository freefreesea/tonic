package cn.sxt.oo2;
/**
 * 测试多态
 * 1.继承
 * 2.重写
 * 3.父类引用指向子类对象Dog 带入 Animal 的参数里面
 * 
 * Animal d=new Dog();   实现的是Dog的功能
 * @author tonic
 *
 */

public class TestPolym {
	public static void main(String[] args) {
		Animal a=new Animal();
		animalCry(a);
		Animal d=new Dog();  //自动向上转型
		animalCry(d);
		animalCry(new Cat());
		
		Animal c=new Cat();
		
		Dog d2=(Dog) d;   //强制向下转型
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
		System.out.println("叫了一声");
	}
}

class Dog extends Animal{
	public void shout() {
		System.out.println("汪汪汪");
	}
	
	public void seeDoor() {
		System.out.println("看门!!!");
	}
}

class Cat extends Animal{
	public void shout() {
		System.out.println("喵喵喵");
	}
}