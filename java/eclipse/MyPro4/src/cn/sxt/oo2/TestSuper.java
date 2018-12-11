package cn.sxt.oo2;

public class TestSuper {
	public static void main(String[] args) {
		System.out.println("开始创建一个ChildClass对象...");
		new ChildClass();
	}
}

class FatherClass{
	public FatherClass() {
		System.out.println("创建FatherClass");
	}
}

class ChildClass extends FatherClass{
	public ChildClass() {
		System.out.println("创建ChildClass");
	}
}
