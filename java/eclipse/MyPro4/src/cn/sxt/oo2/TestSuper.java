package cn.sxt.oo2;

public class TestSuper {
	public static void main(String[] args) {
		System.out.println("��ʼ����һ��ChildClass����...");
		new ChildClass();
	}
}

class FatherClass{
	public FatherClass() {
		System.out.println("����FatherClass");
	}
}

class ChildClass extends FatherClass{
	public ChildClass() {
		System.out.println("����ChildClass");
	}
}
