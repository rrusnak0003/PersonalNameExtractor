/**
 * [ ] Implement Weka object in this class
 * [ ] As a dev, I'd like to have an interface that accepts a string that contain an authors name and return the that author's name.
 * [ ] As a dev, I'd like to train the Learning Machine using a Weka .arff file.
 */

package edu.odu.cs.cs350.namex;

import weka.core.Instances;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Trainer {
	private LearningMachine theBrain;
	
    /**
     * Constructor, default to a Trainer with a new learning machine.
     **/
	public Trainer (){							
		theBrain = new LearningMachine();
	}
	
    /**
     * A get function to retrieve the learning machine.
     * @Return Trainer's learning machine.
     **/
	public LearningMachine getLearningMachine(){
		return theBrain;
	}	
	
    /**
     *  Read lines of text to array, split into lines of text by 
     *  </NER> delimeter, then split in to word tokens array
     **/
	public void prepareTrainingMaterials(){
		BufferedReader in = null;
		try{
			in	= new BufferedReader(new FileReader("testTrainingData2.txt"));
			ArrayList<String> inputText = new ArrayList<String>();
			String line = "";
			while(in.read() != -1){
				line = in.readLine();
				inputText.add(line);						
			}
			String[] simpleTextArray = new String[ inputText.size() ];
			inputText.toArray( simpleTextArray );
			String [] tokens;
			for(String l : simpleTextArray){
				String [] linesOfText = l.split("</NER>");
				for(String t : linesOfText){
					tokens = t.split("\\s+");
				}
				//todo test each attribute for each word and save as CSV
				// pass to codeTrainingTokens(tokens)
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		

	
	}

    /**
     * Provide a string block and locate the author's name from it.
     * 
     * @param block
     * @param author
     **/
	public void train(String block, String author){
		// TODO We would want to shingle here
		for(String word : block.split("\\s+")){
			
		}
	}
	


    /**
     * Load a Weka .arff file.
     *
     * @param filePath: Absolute path to the .arff file.
     **/
    public void loadTrainingFile(String filePath) throws FileNotFoundException, IOException{
       Instances dataset = new Instances(new BufferedReader(new FileReader(filePath)));     // load the training file

        // Store training dataset into Learning Machine obj
    }

    /**
     * Load individual training instances.
     * 
     * @param attributes:  
     **/
    public void loadTrainingText(String[] attributes){
    }
    
    /**
     * Verify the training data is actually correct.
     */
    public void verifyTraining(){
    	
    }
}
