package com.test12;
import java.util.*;

public class Demo123 {

	HashMap hm=new HashMap();
	
	Dog dog1=new Dog("asdsa", "sad111", 1.2f);
	
	hm.put("asdsa");
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