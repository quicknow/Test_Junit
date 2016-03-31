package com.testfunctions;

import java.util.Scanner;

/*
 * 猴子吃桃，每次都吃一半，再多1个，直至第10天之剩下1个，问总共有多少桃？
 * 使用递归方法解决: 假设某一天的桃子总数为f(n),前一天与后一天的关系是：f(n)-[0.5f(n)+1]=f(n+1)
 * 化简为：f(n)=2f(n+1)+2  当n=10时，f(n)=1，有这两个条件即可使用递归解决问题。总共的桃子数即为第1天的桃子数
 */

class MokeyEatPeach{
	
	public int DatePeach(int n){
		if(n==10){
			return 1;
		} else{
			return 2*DatePeach(n+1)+2;
		}
	}
	
	public static int scan(){
		
		System.out.println("请输入某一天猴子还剩的桃子数");
		Scanner sr = new Scanner(System.in);		
		int a = sr.nextInt();
		
		
		 while(true){
			if(a<11&&a>0){
				
				break;
			}else{
				System.out.println("输入的数不合法请输入0-11之间的整数");	
				 sr = new Scanner(System.in);		
				 a = sr.nextInt();
			}
		 }	
		 
		 return a;
	}
}




public class TestDiGui {
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new MokeyEatPeach().DatePeach(MokeyEatPeach.scan()));
	}

}

//递归方法求阶乘
class JieSheng{
	
	public int TotalJS(int n){
		
		if(n==1){
			return 1;
		} else{
			return n*TotalJS(n-1);
		}
	}
	
}

