package com.testfunctions;
import java.io.*;

public class TestshowAllFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File root = new File("c:\\");
			
			if(root.isDirectory()){
				new TestshowAllFiles().showAllFiles(root);
			}else{
				System.out.println(root.getAbsolutePath());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TestshowAllFiles.showAllFiles(root);
	}


	
	//ʹ�õݹ���Ҫ��֤���õĹ�����ȫһ��
	public  void showAllFiles(File f){
		
		
		File flists[]=f.listFiles();
		//��Ϊÿ�������涼��System Volume Information ���ʸ�Ŀ¼��f.listFiles()����null������Ҫ�ų����
		if(flists!=null){
			for(int i=0;i<flists.length;i++){				
				System.out.println(flists[i].getAbsolutePath());
					
				if(flists[i].isDirectory()){					
					showAllFiles(flists[i]);
				}
					
			}
		}	
			
	}

}
