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

