package edu.odu.cs.cs350.namex.UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.odu.cs.cs350.namex.*;

public class testCataloger {

	@Test	//Test the Cataloger() default constructor
	public void testCatalogerConstructor() {
		Cataloger tester = new Cataloger();
		
		assertTrue(tester.getNameList().isEmpty());
		assertEquals(tester.getLearningMachine(), null);
	}

	@Test	//Test the Cataloger(LearningMachine lm) constructor
	public void testCatalogerLearningMachine() {
		LearningMachine testLearningMachine = new LearningMachine();	//Revise once LearningMachine constructor is in place
		Cataloger tester = new Cataloger(testLearningMachine);
		
		assertTrue(tester.getNameList().isEmpty());
		assertEquals(tester.getLearningMachine(), testLearningMachine);
	}

	@Test	//Test the Cataloger(String[] names) constructor
	public void testCatalogerStringArray() {
		String[] names = {"Hello test", "this is test", "0000", "----", "   "};
		Cataloger tester = new Cataloger(names);
		
		//Compare each element of the array given to the tester.nameList
		for(int i=0; i < names.length; i++)
			assertTrue(names[i].equals(tester.getNameList().get(i)));
		
		assertEquals(tester.getLearningMachine(), null);
	}

	@Test
	public void testGetNameList() {
		String[] names = {"Hello test", "this is test", "0000", "----", "   "};
		Cataloger tester = new Cataloger(names);
		
		//Compare each element of the array given to the tester.nameList
		for(int i=0; i < names.length; i++)
			assertTrue(names[i].equals(tester.getNameList().get(i)));
	}

	@Test
	public void testGetLearningMachine() {
		LearningMachine testLearningMachine = new LearningMachine();	//Revise once LearningMachine constructor is in place
		Cataloger tester = new Cataloger(testLearningMachine);
		
		assertEquals(tester.getLearningMachine(), testLearningMachine);
	}

	@Test
	public void testIdentifyNamesIn() {
		//The pre-trained learning machine to identify names
		LearningMachine tester = new LearningMachine();	//Revise once LearningMachine stuff is in place
		
		//Simple name test
		Cataloger test1 = new Cataloger(tester);
		String textBlock1 = "Hello Deborah, my name is Johnathan. How had Doug Jefferson been lately?";	
		String[] names1 = {"Deborah", "Johnathan", "Doug Jefferson"};
		//Empty string test
		Cataloger test2 = new Cataloger(tester);
		String textBlock2 = "       ";
		//No name test
		Cataloger test3 = new Cataloger(tester);
		String textBlock3 = "Hello, how are you doing today?";
		//Punctuated name test
		Cataloger test4 = new Cataloger(tester);
		String textBlock4 = "John Edward're went to Dolly Breu's house and had a cup of tea with George Jac'kson.";
		String[] names2 = {"John Edward're","Dolly Breu's","George Jac'kson"};
		
		//Run the function for each case
		test1.identifyNamesIn(textBlock1);
		test2.identifyNamesIn(textBlock2);
		test3.identifyNamesIn(textBlock3);
		test4.identifyNamesIn(textBlock4);
		
		//Compare the expected results
		for(int i=0; i < names1.length; i++)
			assertTrue(names1[i].equals(test1.getNameList().get(i)));
		
			assertTrue(test3.getNameList().isEmpty());
			
			assertTrue(test3.getNameList().isEmpty());
			
		for(int i=0; i < names2.length; i++)
			assertTrue(names2[i].equals(test4.getNameList().get(i)));
		
	}

}
