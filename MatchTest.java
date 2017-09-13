import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    @Test
    public void outputId() throws Exception {
        Person per1 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");
        Person per2 = new Person(
                2,             "irst",    "middled",
                "last",        1202,       12,
                15,            12323,    2434,
                "male",        "f",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","egads",      "mother",
                "mom");


        IdentByConfidence a = new IdentByConfidence();
        StrikeOut b = new StrikeOut();
        ScoreSystem c = new ScoreSystem();

        Match match = new Match(per1, per1, a);
        match.runAlgorithm();
        assertEquals(per1.outputId() + ", " + per1.outputId(), match.outputId());

        match = new Match(per1, per1, b);
        match.runAlgorithm();
        assertEquals(per1.outputId() + ", " + per1.outputId(), match.outputId());

        match = new Match(per1, per1, c);
        match.runAlgorithm();
        assertEquals(per1.outputId() + ", " + per1.outputId(), match.outputId());

        match = new Match(per1, per2, b);
        match.runAlgorithm();
        assertEquals("No Match", match.outputId());
    }

    @Test
    public void output() throws Exception {
        Person per1 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");
        Person per2 = new Person(
                2,             "irst",    "middled",
                "last",        1202,       12,
                15,            12323,    2434,
                "male",        "f",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","egads",      "mother",
                "mom");


        IdentByConfidence a = new IdentByConfidence();
        StrikeOut b = new StrikeOut();
        ScoreSystem c = new ScoreSystem();

        Match match = new Match(per1, per1, a);
        match.runAlgorithm();
        assertEquals("Match:\n" + per1.output() + "\n" + per1.output() + "\n", match.output());

        match = new Match(per1, per1, b);
        match.runAlgorithm();
        assertEquals("Match:\n" + per1.output() + "\n" + per1.output() + "\n", match.output());

        match = new Match(per1, per1, c);
        match.runAlgorithm();
        assertEquals("Match:\n" + per1.output() + "\n" + per1.output() + "\n", match.output());

        match = new Match(per1, per2, b);
        match.runAlgorithm();
        assertEquals("No Match", match.output());
    }

    @Test
    public void runAlgorithm() throws Exception {
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

        IdentByConfidence a = new IdentByConfidence();
        StrikeOut b = new StrikeOut();
        ScoreSystem c = new ScoreSystem();
        Match match = new Match(per1, per2, c);
        match.runAlgorithm();

    }

}