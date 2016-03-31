package com.testfunctions;

import com.dog.*;

public class TestStatic {
	
	static int i=1;
	
	static{
		System.out.println("a");
		
		i++;
	}
	
	public TestStatic(){
		
		i++;
		System.out.println("b");
		System.out.println(i);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//类中的静态变量在定义的时候就已经存在，使用的时候会仅且执行一次
		//System.out.println(TestStatic.i);
		/*
	    new TestStatic();
	    
	    new TestStatic();
	    
	    new TestStatic();*/
	    
	    Dog dog = new Dog();
	    System.out.println(dog.name);
	    
	}

}
