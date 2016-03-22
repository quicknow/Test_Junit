package com.takescreenshot;

import java.util.Date;
//DateUtil����Ҫ���������ꡢ�¡��ա�Сʱ�����Ӻ������Ϣ���������ɱ����ͼ�ļ�Ŀ¼�����ļ���


public class DateUtil {
	
	/*
	 * ��ʽ���������
	 * @return �����ַ�������
	 */
	
	public static String format(java.util.Date date,String format){
		String result = "";
		try{
			if(date !=null){
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);				
			}			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	/*
	 * �������
	 * @return �������
	 */
	
	public static int getYear(java.util.Date date){
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
		
	}
	
	/*
	 * �����·�
	 * @return �����·�
	 */

	public static int getMonth(java.util.Date date){
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MONTH) + 1;
		
	}
	
	/*
	 * �������·��еĵڼ���
	 * @return �����·��еĵڼ���
	 */
	public static int getDay(java.util.Date date){
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
		
	}
	
	/*
	 * ����Сʱ
	 * @param date
	 * ����
	 * @return ����Сʱ
	 */
	public static int getHour(java.util.Date date){
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}
	
	/*
	 * ���ط���
	 * @param ����
	 * ����
	 * @return ���ط���
	 */
	
	public static int getMinute(java.util.Date date){
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}
	
	/*
	 * ������
	 * @param date
	 * ����
	 * @return ������
	 */
	
	public static int getSecond(java.util.Date date){
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}
	
}
