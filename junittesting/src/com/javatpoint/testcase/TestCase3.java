package com.javatpoint.testcase;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase3 {

	@BeforeClass
	public static void beforeEachMethod(){
		
		System.out.println("Initialize test data before each Test");
		
	}
	
	
	@AfterClass
	public static void AfterEachMethod(){
		
		System.out.println("Initialize test data After each Test");
		
	}
	
	@Test
	public void stringLengthTest() {
		int actualLength= "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	public void toUppercase(){
		
		String str= "abcd";
		String result= str.toUpperCase();
		//assertNull(result);
		assertNotNull(result);
		assertEquals("ABCD", result);
		
		
	}
	@Test
	public void containsString(){
		
		String str="abcdefgh";
		boolean result = str.contains("ijk");
		
		//assertEquals(false,result);
		assertFalse(result);
		
	}
	
}
