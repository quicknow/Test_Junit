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
		//������һ��С����������ͷָ���������ָ��
		Children chl= new Children(1,null);
		Children firstchl=chl;
		Children temp = chl;
		
		//ͷָ��
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
		Setclerk sc = new Setclerk(4);
		//sc.printchild(sc.firstchl);
		
		//���һ�����ӳ�Ȧ�ĺ���
		int num=TestYueSeFu.lastchildnum(sc.firstchl, 2);
		
		System.out.println(num);
	}
	
	public static int lastchildnum(Children chl,int m){
		Children temp;
		Children kk=chl;//		
		temp=chl;
		
		while(kk.next!=temp){
			for(int i=1;i<m;i++){
				if(i==m-1){
					kk=temp;
					temp=temp.next;
				} else{
					temp=temp.next;
				}			
			}
			
			kk.next=temp.next;
			temp=temp.next;
		}	
		
		return kk.num;
	}

}
