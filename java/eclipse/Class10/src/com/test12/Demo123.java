package com.test12;
import java.util.*;

public class Demo123 {

	public static void main(String[] args) {
		HashMap hm=new HashMap();
		Dog dog1=new Dog("asdsa", "sad111", 1.2f);
		
		Queue qu = new Queue() {
		};
		
		
		hm.put("asdsa", dog1);
		
		if(hm.containsKey("asdsa"))
		{
			System.out.println("sadas");
			Dog dog=(Dog)hm.get("asdsa");
		}
	}
	
}



class Dog
{
	String name;
	String id;
	float sal;
	
	public Dog(String name,String id,float sal)
	{
		this.name=name;
		this.id=id;
		this.sal=sal;
	}
}