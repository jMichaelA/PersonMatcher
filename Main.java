import com.fasterxml.jackson.databind.ObjectMapper;

public class Main{
    public static void main(String[] args){
        // Persons
        Person per1 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        true,       392002,
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");
        Person per2 = new Person(
                2,             "irst",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        true,       392002,
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");
        Person per3 = new Person(3);

        // algorithms
        IdentByConfidence a = new IdentByConfidence();
        StrikeOut b = new StrikeOut();
        ScoreSystem c = new ScoreSystem();

        // match
        Match match = new Match(per1, per2, c);
        match.runAlgorithm();

        // match.setMatch(true);
        // System.out.println(match.outputId());
        // System.out.println(match.output());

        ObjectMapper mapper = new ObjectMapper();


    }
}