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
 * �ַ���ת�����ַ�����
 * String str="abcde";
char[] c=new char[str.length()];
c=str.toCharArray();
����������
String���Դ���toCharArray()���������
 * 
 * 
 * java����ʹ�����ַ���ֱ�ӽ��ַ�����תΪ�ַ���
����1��ֱ���ڹ���Stringʱת����
char[] data = {'a', 'b', 'c'};
String str = new String(data);

����2������String��ķ���ת����
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
