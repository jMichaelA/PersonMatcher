import java.io.IOException;
import java.util.List;

public class Main{
    public static void main(String[] args){
        // Persons
        Person per1 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");
        Person per2 = new Person(
                2,             "irst",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "f",       "392002",
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

        JsonParser jp = new JsonParser();
        List<Person> p = jp.parse("/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/JSON_PersonTestSet_3.json");
//        List<Person> p = jp.parse("/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/json_temp.json");
        if(p != null){
            for (Person i: p) {
//                System.out.println(i.output());
                i.setStateNumberFile();
//                System.out.println(i.getStateFileNumber());
//                System.out.println(i.getStateNumberFile());
            }
        }else{
            System.out.println(jp.getError());
        }

        XmlParser xp = new XmlParser();
        List<Person> p2 = xp.parse("/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/XML_PersonTestSet_1.xml");

        if(p != null){
            for (Person i: p2){
//                System.out.println(i.output());
                i.setStateNumberFile();
            }
        }

        PersonCollection personCollection = new PersonCollection(p, b);
        personCollection.runMatches();
    }
}