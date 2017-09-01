public class Match{
    private Person person1;
    private Person person2;
    private Boolean isMatch;
    private List<Algorithm> algorithm;

    public Match(Person per1, Person per2){
        this.person1 = per1;
        this.person2 = per2;
        isMatch = 0;
        algorithm = new List<algorithm>();
        System.out.println("Match Created!\n");

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

    public List<Algorithm> getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(List<Algorithm> algorithm) {
        this.algorithm = algorithm;
    }
}