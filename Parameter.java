import java.io.File;
import java.util.Scanner;

public class Parameter {
    private String outputToFile;
    private Algorithm algorithm;
    private String inputFile;
    private String algorName;
    private Integer algorId;
    private String error;
    private String[] args;

    public Parameter(){
        algorithm = new IdentByConfidence();
        inputFile = "input.json";
    }

    public Parameter(String args[]){
        if(args.length < 2){
            error = "Please specify arguments:\n algorithm input output\n" +
                    "algorithm: (1,2,3) or (\"confidence\", \"score\", \"strike\")\n\n";
            return;
        }
        Integer algorithmInt;
        String algoritmString;
        algorithm = new IdentByConfidence();
        inputFile = "input.json";

        try {
            algorithmInt = Integer.parseInt(args[0]);
            algorId = algorithmInt;
        }
        catch( Exception e ) {
            algoritmString = args[0];
            algorName = algoritmString;
        }

        inputFile = args[1];
        if(args.length > 2){
            outputToFile = args[2];
        }
    }

    public Parameter(String outputToFile, Algorithm algorithm, String inputFile, String[] args) {
        this.outputToFile = outputToFile;
        this.algorithm = algorithm;
        this.inputFile = inputFile;
        this.args = args;
    }

    public Parameter(String outputToFile, String inputFile, Integer algorId, String[] args) {
        this.outputToFile = outputToFile;
        this.inputFile = inputFile;
        this.algorId = algorId;
        this.args = args;
        algorithm = new IdentByConfidence();

        switch (algorId){
            case 1: algorithm = new IdentByConfidence();
                break;
            case 2: algorithm = new ScoreSystem();
                break;
            case 3: algorithm = new StrikeOut();
                break;
            default: error = "\n\nBad Input for algorithm. Please specify an algorithm by the values (1,2, or 3) or (\"confidence\", \"score\", \"strike\")\n\n";
                break;
        }
    }

    public Parameter(String outputToFile, String inputFile, String algorName, String[] args) {
        this.outputToFile = outputToFile;
        this.inputFile = inputFile;
        this.algorName = algorName;
        this.args = args;
        algorithm = new IdentByConfidence();
        switch (algorName.toLowerCase()){
            case "confidence": algorithm = new IdentByConfidence();
                break;
            case "score": algorithm = new ScoreSystem();
                break;
            case "strike": algorithm = new StrikeOut();
                break;
            default: error = "\n\nBad Input for algorithm. Please specify an algorithm by the values (1,2, or 3) or (\"confidence\", \"score\", \"strike\")\n\n";
                break;
        }
    }

    public void checkParams(){
        File file = new File(inputFile);
        if(!file.exists() || file.isDirectory()) {
            error = "\n\nInput file does not exists!\n\n";
            return;
        }

        if(outputToFile != null){
            if(outputToFile.lastIndexOf(File.separator) > -1){
                String outputDirectory = outputToFile.substring(0, outputToFile.lastIndexOf(File.separator));
                File outputFile = new File(outputDirectory);
                if(!outputFile.exists() && !outputFile.isDirectory()){
                    error = "\n\nOutput directory must be within an existing directory.\n\n";
                }
            }
        }
    }

    public String getInputType(){
        String inputType;
        int index = inputFile.lastIndexOf(".");
        if(index > 0){
            ++index;
            inputType = inputFile.substring(index);
            return inputType;
        }
        error = "\n\nInput File needs an extension\n\n";
        return "";
    }

    // Getters and Setters

    public String getOutputToFile() {
        return outputToFile;
    }

    public void setOutputToFile(String outputToFile) {
        this.outputToFile = outputToFile;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAlgorName() {
        return algorName;
    }

    public void setAlgorName(String algorName) {
        this.algorName = algorName;
        switch (algorName.toLowerCase()) {
            case "confidence":
                algorithm = new IdentByConfidence();
                break;
            case "score":
                algorithm = new ScoreSystem();
                break;
            case "strike":
                algorithm = new StrikeOut();
                break;
            default:
                error = "\n\nBad Input for algorithm. Please specify an algorithm next time by the values (1,2, or 3) or (\"confidence\", \"score\", \"strike\")\n\n";
                break;
        }
    }

    public Integer getAlgorId() {
        return algorId;
    }

    public void setAlgorId(Integer algorId) {
        this.algorId = algorId;
        switch (algorId){
            case 1: algorithm = new IdentByConfidence();
                break;
            case 2: algorithm = new ScoreSystem();
                break;
            case 3: algorithm = new StrikeOut();
                break;
            default: error = "\n\nBad Input for algorithm. Please specify an algorithm next time by the values (1,2, or 3) or (\"confidence\", \"score\", \"strike\")\n\n";
                break;
        }
    }

}
