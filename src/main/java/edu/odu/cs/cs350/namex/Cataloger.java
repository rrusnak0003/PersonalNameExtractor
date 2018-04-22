package edu.odu.cs.cs350.namex;

import java.util.ArrayList;
import java.util.Collections;

public class Cataloger {

	private LearningMachine theBrain;		//The learning machine
	private ArrayList<String> nameList;		//An ArrayList to store identified personal names
	
    /**
     * Constructor, default to a cataloger with a new learning machine and a empty nameList.
     **/
	public Cataloger (){							
		theBrain = null;
		nameList = new ArrayList<String>();
	}
	
	 /**
     * Constructor, create a cataloger with a pre-built learning machine and a empty nameList.
     * @param lm: a pre-built learning machine
     **/
	public Cataloger(LearningMachine lm){							
		theBrain = lm;
		nameList = new ArrayList<String>();
	}
	
	 /**
     * Constructor, create a cataloger with a specified list of names.
     * @param names: An array of names
     **/
	public Cataloger(String[] names){	
		theBrain = null;
		nameList = new ArrayList<String>();
		Collections.addAll(nameList, names);
	}
	 /**
     * A get function to retrieve the nameList.
     * @return nameList
     **/
	public ArrayList<String> getNameList(){ return nameList; }
	
    /**
     * A get function to retrieve the learning machine.
     * @return Cataloger's learning machine.
     **/
	public LearningMachine getLearningMachine(){ return theBrain; }	
	
    /**
     *  Search through given text for personal names, classify them, and add the names to an ArrayList
     *  @param text: The specified block of text to extract names from.
     **/
	public void identifyNamesIn (String text){ 
		
		/**
		 * 	text would have to be converted into instances of data for the lm, may want to make a new function for better readability
		 *  String[] wordList = text.split(" "); splits words into a new array based on spaces, may need to change split criteria or process it further later. May be useful for building instances for lm from text
		**/
		
		
		 //for(int i = 0; i < wordList.length(); i++)
		 //		if(wordList[i] == personalName) nameList.add(wordList[i]);	Placeholder if statement, should be a classification by the lm
		 
	}
	
}
