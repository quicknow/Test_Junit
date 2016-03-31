package com.testfunctions;

public class TestChenFaBiao {

	public static void main(String args[]){
		
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				if((i==3&&j==2)||(i==4&&j==2)){
					System.out.print(i+"X"+j+"="+i*j+"  ");
				} else{
					System.out.print(i+"X"+j+"="+i*j+" ");
				}
			}
			System.out.println();
		}
	}
}
