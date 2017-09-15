import java.io.*;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Parameter parameter = new Parameter(args);
        if(error(parameter)){
            return;
        }
        parameter.checkParams();
        if(error(parameter)){
            return;
        }

        String inputType = parameter.getInputType();
        if(error(parameter)){
            return;
        }

        Parser parser;

        if(inputType.toLowerCase().equals("json")){
            parser = new JsonParser();
        }else if(inputType.toLowerCase().equals("xml")){
            parser = new XmlParser();
        }else{
            System.out.println("Sorry we have no parser for this type of file");
            return;
        }

        List<Person> people = parser.parse(parameter.getInputFile());
        PersonCollection personCollection = new PersonCollection(people, parameter.getAlgorithm());
        personCollection.runMatches();

        List<Match> matches = personCollection.getMatch();

        // initialize file writer
        BufferedWriter fileBuff = null;
        FileWriter file = null;

        if(parameter.getOutputToFile() != null) {
            try {
                file = new FileWriter(parameter.getOutputToFile());
                fileBuff = new BufferedWriter(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // loop through matches and output accordingly
        for (Match match : matches) {
            output(match, fileBuff);
        }

        // close file writers
        if(parameter.getOutputToFile() != null) {
            try {
                if (fileBuff != null) {
                    fileBuff.close();
                }

                if (file != null) {
                    file.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void output(Match match, BufferedWriter outputFile){
        if(outputFile == null){
            System.out.println(match.output());
        }else{
            try {
                outputFile.write(match.outputId() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Boolean error(Parameter parameter){
        if(parameter.getError() != null){
            System.out.println(parameter.getError());
            return true;
        }
        return false;
    }
}