package cn.sxt.oo2;

/**
 * 属性 直接private
 * 设置set方法  向封装里输入值
 * 设置get方法  向封装外输入值
 * 其他方法 一般public即可
 * 
 * @author tonic
 *
 */
public class Person4 {
	private int id;
	private String name;
	private int age;
	private boolean man;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		if(age>=1&&age<=199) {
		this.age=age;
	}
		else
			System.out.println("请输入正常的年龄");
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMan() {
		return man;
	}

	public void setMan(boolean man) {
		this.man = man;
	}

	public int getAge() {
		return this.age;
	}
}
