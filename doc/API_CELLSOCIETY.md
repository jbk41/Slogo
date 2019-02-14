## Net-IDS
* aam79
* jbk41
* bh179
* sk531

## Api Critique
writeGameConfig, writeCellConfig, and writeParameters should remain public because 
that is how the backend (a separate package) creates the XML files. The only 
way that could happen is by keeping these methods public. 

However, the following methods should be private: 

    public void convertToFile(Document doc, String fileName) throws TransformerException 
    public void writeProbabilities(Element root, Map<String, ArrayList<Double>> cellInfo, Document doc)
    public void writeInitialStates(Element root, Document doc, CellSpace[][] myCellSpace)
    public void writeCellParameters(Element root, Document doc, Map<String, ArrayList<Double>> cellInfo)
    public void writeGridParameters(Element root, Document doc, Map <String, ArrayList<Double>> cellInfo)
    public void writeTitleAndAuthor(Element root, Document doc, String fileName, Map<String, ArrayList<String>> gameInfo) 
    public void writeShapes(Element root, Document doc, Map<String, ArrayList<String>> gameInfo)
    public void writeColors(Element root, Document doc, Map<String, ArrayList<String>> gameInfo)
    public void writeNeighbors(Element root, Document doc, Map<String, ArrayList<String>> gameInfo)
    
These methods are only used by the XML Package to create the XML files from the 
inputs through writeGameConfig, writeCellConfig, and write Parameters. These should be 
private because we need to encapsulate the inner workings of the code from other packages
so other methods do not mess up with the logic of the XML class. 

## SLogo Architecture Design 
1. Parsing needs happen when the front end recieves a string which 
    user input. The front end takes this user input and passes it 
    to the backend. The backend should have a method that parses through
    this input string and spits out an instruction for the turtle to
    do. The front end takes the instruction and moves the turtle 
    on the front end. 
2. The result of the parsing should be an instruction that updates 
    visualization. 
3. The errors are detected through the parsing methods provided by the 
    backend. We would do a try catch method when passing in the strings
    and we could catch a wrongly formatted input strings. 
4. User types in a command and the parser reads it and sends it to back     
   end where the turtle is updated, sent back to frond end where screen is 
    then updated.
5.  The GUI is updated by accessing history and then updating the turtle. 



