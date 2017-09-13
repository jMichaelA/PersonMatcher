import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PersonCollection{
    private List<Person> person;
    private List<Match> match;
    private Algorithm algorithm;

    public PersonCollection(){
        person = Arrays.asList();
        match = Arrays.asList();
        IdentByConfidence identByConfidence = new IdentByConfidence();
    }

    public PersonCollection(List<Person> person, Algorithm algorithm){
        this.person = person;
        this.algorithm = algorithm;
        match = new ArrayList<Match>();
    }

    public void runMatches(){
        Match tempMatch = new Match(new Person(), new Person(), algorithm);

        for(int i = 0; i < person.size(); ++i){
            for(int j = i+1; j < person.size(); ++j){

                // I need a new instance of algorithm otherwise the attributes would not reset
                try {
                    algorithm = algorithm.getClass().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                tempMatch = new Match(person.get(i), person.get(j), algorithm);
                tempMatch.runAlgorithm();

                if(tempMatch.getMatch()) {
                    match.add(tempMatch);
                }
            }
        }
    }

    // Getters and Setters

    public List<Person> getPerson(){
        return person;
    }

    public void setPerson(List<Person> person){
        this.person = person;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}