package cn.sxt.oo2;
/**
 * ���Է�װ
 * @author tonic
 *
 */
public class TestEn {
	public static void main(String[] args) {
	/*	Human h=new Human();
		//h.age=13;
		h.name="sdasdsa";*/
		
		Person4 p4=new Person4();
		p4.setAge(15);
		System.out.println(p4.getAge());
		p4.setMan(true);
		System.out.println(p4.isMan());
	}
}
/*
class Human{
	private int age;
	String name;
	
	void sayAge() {
		System.out.println(age);
	}
}

class Boy extends Human{
	void sayHello() {
	//	System.out.println(age);  //����Ҳ�ò���private
	}
}*/