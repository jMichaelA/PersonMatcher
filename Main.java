import java.io.IOException;
import java.util.List;

public class Main{
    public static void main(String[] args){

        Parameter parameter = new Parameter("/home/jacob/gasp/output.txt", "/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/JSON_PersonTestSet_3.json", 2);
        parameter.checkParams();
        System.out.println(parameter.getError());

        // algorithms
        IdentByConfidence a = new IdentByConfidence();
        StrikeOut b = new StrikeOut();
        ScoreSystem c = new ScoreSystem();


        JsonParser jp = new JsonParser();
        List<Person> p = jp.parse("/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/JSON_PersonTestSet_3.json");

        XmlParser xp = new XmlParser();
        List<Person> p2 = xp.parse("/home/jacob/school/fall_2017/oo/cs5700f17-shared/hw1/Data/XML_PersonTestSet_1.xml");

        PersonCollection personCollection = new PersonCollection(p, b);
        personCollection.runMatches();

    }
}