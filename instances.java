String[] capLetterNames = {"capLetter", "other"};
Attribute capLetter = new Attribute("capLetter", fastV(capLetterNames)); 
String[] allCapsNames = {"allCapsWord", "other"};
Attribute allCaps = new Attribute("allCaps", fastV(allCapsNames)); 
String[] nameClassification = {"beginPersonal", "continuePersonal", "other"};
Attribute personalName = new Attribute("personalName", fastV(nameClassification)); 

FastVector attrInfo = new FastVector();
attrInfo.addElement(capLetter);
attrInfo.addElement(allCaps);
attrInfo.addElement(personalName);


final int numberOfAttributes = attrInfo.size();

String[] trainingData = {
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        "other, other, other",
        
        
};

Instances training = new Instances(
                "TrainingData", attrInfo, 
                trainingData.length);
training.setClass(personalName); // Which attribute holds the
                         // class/category that we want
                         // to predict?
for (String sdata: trainingData) {
        String[] values = sdata.split(",");
        Instance instance = new Instance(numberOfAttributes);
        instance.setValue(0, values[0]); // capLetter
        instance.setValue(1, values[1]); // allCaps
        instance.setValue(2, values[2]); // personalName

        training.add(instance); // Add new instance to training data
}

  /**
   * Utility to build a FastVector from an array of Strings.
   * (This will be easier in later versions of WEKA where
   * FastVector will be a subclass of ArrayList.)  
   * @param data array of strings
   * @return a FastVector cotnaining those strings
   */
  private FastVector fastV(String[] data) {
      FastVector result = new FastVector(data.length);
      for (String s: data) {
          result.addElement(s);
      }
      return result;
  }