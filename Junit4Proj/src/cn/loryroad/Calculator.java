package cn.loryroad;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Calculator {
	
	public int result=0;
	public int add(int operand1,int operand2){
		
		result = operand1 + operand2;
		return result;
		
		
	}
	
	public int subtract(int operand1,int operand2){
		
		result = operand1 - operand2;
		return result;
		
		
	}
	
	public int multiple(int operand1,int operand2){
		
		result = operand1 * operand2;
		for(;;){
			
			
		}
		
		
	}
	
	public int divide(int operand1,int operand2){
		
		result = operand1 /0;
		return result;		
		
	}
	
	public int getResult(){
		
		return this.result;
	}
	
	
}
