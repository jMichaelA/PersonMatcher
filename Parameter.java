import java.io.File;
import java.util.Scanner;

public class Parameter {
    private String outputToFile;
    private Algorithm algorithm;
    private String inputFile;
    private String algorName;
    private Integer algorId;
    private String error;

    public Parameter(){
        algorithm = new IdentByConfidence();
        inputFile = "input.json";
    }

    public Parameter(String outputToFile, Algorithm algorithm, String inputFile) {
        this.outputToFile = outputToFile;
        this.algorithm = algorithm;
        this.inputFile = inputFile;
    }

    public Parameter(String outputToFile, String inputFile, Integer algorId) {
        this.outputToFile = outputToFile;
        this.inputFile = inputFile;
        this.algorId = algorId;
        algorithm = new IdentByConfidence();

        switch (algorId){
            case 1: algorithm = new IdentByConfidence();
                break;
            case 2: algorithm = new ScoreSystem();
                break;
            case 3: algorithm = new StrikeOut();
                break;
            default: error = "Bad Input for algorithm";
                break;
        }
    }

    public Parameter(String outputToFile, String inputFile, String algorName) {
        this.outputToFile = outputToFile;
        this.inputFile = inputFile;
        this.algorName = algorName;
        algorithm = new IdentByConfidence();
        switch (algorName.toLowerCase()){
            case "confidence": algorithm = new IdentByConfidence();
                break;
            case "score": algorithm = new ScoreSystem();
                break;
            case "strike": algorithm = new StrikeOut();
                break;
            default: error = "Bad Input for algorithm. Please specify an algorithm next time by the values (1,2, or 3) or (\"confidence\", \"score\", \"strike\")";
                break;
        }
    }

    public void checkParams(){
        File file = new File(inputFile);
        if(!file.exists() || file.isDirectory()) {
            error = "Input file does not exists!";
            return;
        }

        if(outputToFile != null){
            String outputDirectory = outputToFile.substring(0, outputToFile.lastIndexOf(File.separator));
            File outputFile = new File(outputDirectory);
            if(!outputFile.exists() && !outputFile.isDirectory()){
                error = "output directory must be within an existing directory.";
            }
        }
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
    }

    public Integer getAlgorId() {
        return algorId;
    }

    public void setAlgorId(Integer algorId) {
        this.algorId = algorId;
    }

}
