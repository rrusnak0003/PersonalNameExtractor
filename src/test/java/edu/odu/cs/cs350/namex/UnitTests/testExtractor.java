package edu.odu.cs.cs350.namex.UnitTests;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import edu.odu.cs.cs350.namex.Cataloger;
import edu.odu.cs.cs350.namex.Extractor;


public class testExtractor {

	@Test	//Test the string operations from main
	public void testMain() {
		
		StringBuffer buffer = new StringBuffer();
		String testString = "Hello, this" + System.getProperty("line.separator") + " is a test " + System.getProperty("line.separator");
		Scanner inputStr = new Scanner(testString);
		boolean more = true;
		while(more){											
		buffer.append(inputStr.nextLine());						
		buffer.append(System.getProperty("line.separator"));	
		more = inputStr.hasNext();								
		}
		inputStr.close();
		String toProcess = buffer.toString();
		
		assertEquals(toProcess, testString);
		
	}

	@Test	//Test the markPersonalNames function from Extractor
	public void testMarkPersonalNames() {
		String[] nameList = {"John Edward", "Dolly Breu's", "George Jackson"};
		Cataloger testMarkNames = new Cataloger(nameList);
		String textBlock = "John Edward went to Dolly Breu's house and had a cup of tea with George Jackson.";

		//Check that the markPersonalNames function properly tags the names
		String markedUp = Extractor.markPersonalNames(textBlock, testMarkNames);
		assertEquals(markedUp,
				"<PER>John Edward</PER> went to <PER>Dolly Breu's</PER> house and had a cup of tea with <PER>George Jackson</PER>.");
		
	}
}
