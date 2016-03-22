package com.takescreenshot;

import java.io.File;
import java.io.IOException;
/*
 * FileUtil�����ڴ���Ŀ¼���ļ�����������ֻʹ�ô���Ĵ���Ŀ¼�����������ļ��ķ���������Ҳο�������
 * ���ڸ��ݲ�����Ҫ����ָ���������ļ�
 */

public class FileUtil {
	public static boolean createFile(String destFileName){
		File file  = new File(destFileName);
		if(file.exists()){
			System.out.println("���������ļ�"+destFileName+"ʧ��,Ŀ���ļ��Ѵ��ڣ�");
			return false;
		}
		
		if(destFileName.endsWith(File.separator)){
			System.out.println("���������ļ�"+destFileName+"ʧ�ܣ�Ŀ���ļ�����ΪĿ¼");
			return false;
		}
		
		//�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
		
		if(!file.getParentFile().exists()){
			//���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
			System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
			if(!file.getParentFile().mkdirs()){
				System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");
				return false;
			}
		}
		
		//����Ŀ���ļ�
		try{
			if(file.createNewFile()){
				System.out.println("���������ļ�"+destFileName+"�ɹ�");
				return true;
			}else {
				System.out.println("���������ļ�"+destFileName+"ʧ��");
				return false;
			}
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("���������ļ�"+destFileName+"ʧ�ܣ�"+e.getMessage());
			return false;
		}		
	}
	
	public static boolean createDir(String destDirName){
		File dir = new File(destDirName);
		if(dir.exists()){
			System.out.println("����Ŀ¼"+destDirName+"ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����");
			
			return false;
		}
		
		//����Ŀ¼
		if(dir.mkdirs()){
			System.out.println("����Ŀ¼"+destDirName+"�ɹ���");
			return true;
		}else{
			System.out.println("����Ŀ¼"+destDirName+"ʧ�ܣ�");
			return false;
		}
	}

}
