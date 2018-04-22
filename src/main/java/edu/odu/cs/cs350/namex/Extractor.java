package edu.odu.cs.cs350.namex;

import java.util.Scanner;

public class Extractor {

	public static void main(String[] args){
		String author = "Roald Dahl";
		String title = "James and the Giant Peach by Roald Dahl";
		
		Trainer mainTrainer = new Trainer();	
		mainTrainer.prepareTrainingMaterials();
		mainTrainer.train(title, author);	
		
		//Create a cataloger using the Learning Machine trained by mainTrainer
		Cataloger mainCataloger = new Cataloger(mainTrainer.getLearningMachine());
		
		//Take input
		StringBuffer buffer = new StringBuffer();
		Scanner inputStr = new Scanner(System.in);
		boolean more = true;
		
		while(more){											//While there is more input, read the next line and add it to the buffer
		buffer.append(inputStr.nextLine());						//Read the next line from input
		buffer.append(System.getProperty("line.separator"));	//Append an endline to the buffer
		more = inputStr.hasNext();								//Check to see if there is more input
		}
		inputStr.close();
		String toProcess = buffer.toString();
		
		//Mark personal names found in the input taken above
		String markedUp = markPersonalNames(toProcess, mainCataloger);
		System.out.println(markedUp);

	}
	
	
    /**
     * Searches through a given string to find names from an ArrayList, if found, names are marked up with <PER></PER> tags
     * 
     * @param textBlock: A block of text to process, string format.
     * @return processed: The marked-up string after being processed.
     **/
	public static String markPersonalNames(String textBlock, Cataloger mainCataloger){
	
		mainCataloger.identifyNamesIn(textBlock);					//Creates a list of names from the text block 
		
		String[] nameList = new String[mainCataloger.getNameList().size()];	//Create a copy of the nameList obtained by the Cataloger
		mainCataloger.getNameList().toArray(nameList);
	
		String markedUp = textBlock;
		for(int i = 0; i < nameList.length; i++){					//Runs through the list of names
			String marking = "<PER>" + nameList[i] + "</PER>";		//For each name in the list, create a string with <PER> tags surrounding it
			markedUp = markedUp.replace(nameList[i], marking);		//Replace the name in the textblock with the new, marked up version.
			}
		return markedUp;
	}
}
	