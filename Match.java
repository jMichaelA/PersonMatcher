import java.util.List;

public class Match{
    private Person person1;
    private Person person2;
    private Boolean isMatch;
    private Algorithm algorithm;
    private List<Algorithm> algorithms;

    public Match(Person per1, Person per2, Algorithm algorithm){
        this.person1 = per1;
        this.person2 = per2;
        this.algorithm = algorithm;
        isMatch = false;
    }

    public Match(Person per1, Person per2, List<Algorithm> algorithms){
        this.person1 = per1;
        this.person2 = per2;
        this.algorithms = algorithms;
        isMatch = false;
    }

    public String outputId(){
        return isMatch ? person1.outputId() + ", " + person2.outputId() : "No Match";
    }

    public String output(){
        return isMatch ? "Match:\n" + person1.output() + "\n" + person2.output() + "\n" : "No Match";
    }

    public void runAlgorithm(){
        isMatch = algorithm.match(person1, person2);
    }

    // Getters And Setters

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public Boolean getMatch() {
        return isMatch;
    }

    public void setMatch(Boolean match) {
        isMatch = match;
    }

    public List<Algorithm> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }
}