import org.junit.Test;

import static org.junit.Assert.*;

public class StrikeOutTest {
    @Test
    public void match() throws Exception {
        Person per1 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");

        Person per2 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");

        Person per3 = new Person(
                1,             "first",    "middle",
                "last",        1202,       12,
                16,            1232439,    null,
                "female",        "t",       "392002",
                2,             "gasp",   "930-293-3448",
                "944-748-4587","egads",      null,
                "mom");
        Person per4 = new Person(4);

        StrikeOut strike = new StrikeOut();
        assertEquals(true, strike.match(per1, per2));
        assertEquals(false, strike.match(per1, per3));
        assertEquals(false, strike.match(per1, per4));

    }

}