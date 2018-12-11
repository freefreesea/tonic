package com.ran.www.test1;

public class StringTest {
	public static void main(String[] args) {
		String date="Today is Sunday";
		String lower,upper;
		lower=date.toLowerCase();
		upper=date.toUpperCase();
		System.out.println(lower);
		System.out.println(upper);
		
		
		char a=date.charAt(2);
		System.out.println(a);
		
		String b=date.substring(0,3);
		System.out.println(b);
		String c=date.substring(6);
		System.out.println(c);
		
		
		String date1="SunDay",date2="Sunday";
		System.out.println(date1.equals(date2));
		System.out.println(date1.equalsIgnoreCase(date2));
		
		
		String date3="Sunday",date4="sunday";
		int d=date3.compareTo(date4);
		int e=date3.compareToIgnoreCase(date4);
		System.out.println(d);
		System.out.println(e);
		
		
		
		
	}
}
