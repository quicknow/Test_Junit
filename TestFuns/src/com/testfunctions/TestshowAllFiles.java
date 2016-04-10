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


	
	//使用递归需要保证调用的过程完全一致
	public  void showAllFiles(File f){
		
		
		File flists[]=f.listFiles();
		//因为每个盘下面都有System Volume Information 访问该目录是f.listFiles()返回null，所以要排除改项。
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
