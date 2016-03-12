package com.testfunctions;

public class TestFuns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//System.out.println("How are you");
			
			Funs fun= new Funs();
			/*
			String str2 =fun.convertUpperorLower("AAbbCc");
			
			System.out.println(str2);*/
			
			int arry[]={9,12,6,3,8};
			
			//fun.MaoPao(arry);
			fun.xuze(arry);
			
			for(int i=0;i<arry.length;i++){
				System.out.println(arry[i]);
			}
	}

}


/*
 * 字符串转化成字符数组
 * String str="abcde";
char[] c=new char[str.length()];
c=str.toCharArray();
这样就行了
String类自带了toCharArray()这个方法的
 * 
 * 
 * java可以使用两种方法直接将字符数组转为字符串
方法1：直接在构造String时转换。
char[] data = {'a', 'b', 'c'};
String str = new String(data);

方法2：调用String类的方法转换。
String.valueOf(char[] ch)
 * 
 */
class Funs{
	
	//大小写转化的函数
	public String convertUpperorLower(String str){
		String str2;
		char a[]=new char[str.length()];
		a=str.toCharArray();
		
		for(int i=0;i<str.length();i++){
			
			if(a[i]>64&&a[i]<91){
				a[i]=(char)(a[i]+32);
			}else if(a[i]>96&&a[i]<123){
				a[i]=(char)(a[i]-32);
			}
			
			
		}
		str2=String.valueOf(a);
		return str2;
	}
	
	
	//冒泡排序算法
	public void MaoPao(int a[]){
		int temp=0;
		
		for(int i=0;i<a.length-1;i++){
			
			for(int j=0;j<a.length-i-1;j++){
				
				if(a[j]>a[j+1]){
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}
				
			}
			
		}	
		
	}
	
	
	//选择排序{9,12,6,3,8}
	public  void xuze(int a[]){
		
		for(int i=0;i<a.length-1;i++){
			int min=a[i]; int flag=0; int temp=0;
			
			//每次选出最小的那个数
			for(int j=i+1;j<a.length;j++){
				
				if(min>a[j]){
					min=a[j];
					flag=j;
				}				
			}
			
			if(min!=a[i]){
				temp=a[i];
				a[i]=min;
				a[flag]=temp;
			}
			
		}		
		
	}
	
	
	
	
	
	
	
	
}
