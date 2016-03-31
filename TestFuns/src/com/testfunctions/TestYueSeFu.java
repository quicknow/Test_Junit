package com.testfunctions;


class Children{
	
	int num;
	
	Children next;
	
	public Children(int num,Children ch){
		this.num=num;
	}
	
}

class Setclerk{
	Children firstchl=null;	
	
	
	public  Setclerk(int n){
		//创建第一个小孩，并创建头指针和跑老套指针
		Children chl= new Children(1,null);
		Children firstchl=chl;
		Children temp = chl;
		
		//头指针
		this.firstchl=firstchl;
		
		
		for(int i=2;i<=n;i++){
			if(i!=n){
				chl= new Children(i,null);
				temp.next=chl;			
				temp=chl;
			} else{	
				chl= new Children(i,null);
				temp.next=chl;	
				chl.next=firstchl;
				temp=null;
				
			}
		}
		
	}
	
	public void printchild(Children firstchl){
		Children temp = firstchl;
		while(temp.next!=firstchl){
			System.out.println(temp.num);
			temp=temp.next;
		}
		System.out.println(temp.num);
		temp=null;
	}
	

}

public class TestYueSeFu {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Setclerk sc = new Setclerk(100);
		sc.printchild(sc.firstchl);
		
	}

}
