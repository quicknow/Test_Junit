package com.testfunctions;

import java.util.Scanner;

/*
 * ���ӳ��ң�ÿ�ζ���һ�룬�ٶ�1����ֱ����10��֮ʣ��1�������ܹ��ж����ң�
 * ʹ�õݹ鷽�����: ����ĳһ�����������Ϊf(n),ǰһ�����һ��Ĺ�ϵ�ǣ�f(n)-[0.5f(n)+1]=f(n+1)
 * ����Ϊ��f(n)=2f(n+1)+2  ��n=10ʱ��f(n)=1������������������ʹ�õݹ������⡣�ܹ�����������Ϊ��1���������
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
		
		System.out.println("������ĳһ����ӻ�ʣ��������");
		Scanner sr = new Scanner(System.in);		
		int a = sr.nextInt();
		
		
		 while(true){
			if(a<11&&a>0){
				
				break;
			}else{
				System.out.println("����������Ϸ�������0-11֮�������");	
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

//�ݹ鷽����׳�
class JieSheng{
	
	public int TotalJS(int n){
		
		if(n==1){
			return 1;
		} else{
			return n*TotalJS(n-1);
		}
	}
	
}

