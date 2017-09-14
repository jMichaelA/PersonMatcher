import java.io.*;
import java.util.List;

public class Main{
    public static void main(String[] args){
        Integer algorithmInt;
        String algoritmString;
        Parameter parameter = new Parameter();

        try {
            algorithmInt = Integer.parseInt(args[0]);
            parameter.setAlgorId(algorithmInt);
        }
        catch( Exception e ) {
            algoritmString = args[0];
            parameter.setAlgorName(algoritmString);
        }

        parameter.setInputFile(args[1]);
        if(args.length > 2){
            parameter.setOutputToFile(args[2]);
        }

        parameter.checkParams();
        if(parameter.getError() != null){
            System.out.println(parameter.getError());
            return;
        }

        String inputType = parameter.getInputType();
        if(parameter.getError() != null){
            System.out.println(parameter.getError());
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
}