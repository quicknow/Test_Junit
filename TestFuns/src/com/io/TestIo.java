package com.io;
import java.io.*;

public class TestIo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAllFileName gn = new GetAllFileName();
		gn.printFileName("d:\\11");
		
	//	File f = new File("d:\\11");		
		
//		if(f.exists()){
//			System.out.println("The File is exist");
//			
//		}else{
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	
//		if(f.exists()){
//			System.out.println("The Folder is exist");
//		} else{
//			try {
//				f.mkdir();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

	}

}


class GetAllFileName{
	
	String s[];
	
	//��ӡ�ļ����µ������ļ����ĵݹ麯��
	public void printFileName(String path){
		
		File f = new File(path);
		System.out.println(f.getAbsolutePath());
		//��ס��ǰ��·��
		String temppath=f.getAbsolutePath();
		if(f.exists()){
//			System.out.println(path);
			//System.out.println(f.getAbsolutePath());			
			
			s=f.list();			
			for(int i=0;i<s.length;i++){				
				System.out.println(s[i]);				
			}
			
			
			
			for(int i=0;i<s.length;i++){

				//����ͨ��׺�����ж����ļ������ļ���
				int a = s[i].indexOf(".");
				
				
				//System.out.println("a="+a);
				{					
					String path2=f.getAbsolutePath()+"\\"+s[i];
					System.out.println("path2="+path2);
					//System.out.println("path2="+path2);
					File f2= new File(path2);
					//������ļ��У��������ӡ���ļ����µ������ļ���
					if(f2.isDirectory()){
						printFileName(path2);
				
					}
				}
			}
			
		} else{
			System.out.println("The file is'not exist");
		}
	}
}
