package com.testfunctions;

public class TestFuns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//System.out.println("How are you");
			
			Funs fun= new Funs();
			String str2 =fun.convertUpperorLower("AAbbCc");
			
			System.out.println(str2);
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
	
}
