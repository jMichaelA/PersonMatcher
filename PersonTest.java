import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void identifyNum() throws Exception {
        Integer socialSecurityNumber = 12234123;
        String stateNumberFile = "651568";
        Integer birthYear = 2008;
        Integer birthMonth = 10;
        Integer birthDay = 19;
        Person person = new Person(
                1,             "first",            "middle",
                "last",        birthYear,          birthMonth,
                birthDay,      stateNumberFile,    socialSecurityNumber,
                "male",        "t",                "392002",
                2,             "Mexico",           "930-293-3448",
                "944-748-4587","mom",              "mom",
                "mom");

        List num = person.identifyNum();

        assertEquals(num.get(0), socialSecurityNumber);
        assertNotSame(num.get(1), stateNumberFile);
        assertEquals(num.get(1), Integer.parseInt(stateNumberFile.replaceAll("\\s+","")));
        assertEquals(num.get(2), birthYear);
        assertEquals(num.get(3), birthMonth);
        assertEquals(num.get(4), birthDay);
    }



    @Test
    public void identifyName() throws Exception {
        String first = "first";
        String middle = "middle";
        String last = "last";

        Person person = new Person(
                1,             first,    middle,
                last,          1202,       12,
                15,            1232439,    4949,
                "male",        "t",       "392002",
                2,             "Mexico",   "930-293-3448",
                "944-748-4587","mom",      "mom",
                "mom");

        List personList = person.identifyName();
        assertEquals(first, personList.get(0));
        assertEquals(middle, personList.get(1));
        assertEquals(last, personList.get(2));
    }

    @Test
    public void info() throws Exception {
        String gender = "female";
        String birthCounty = "Davis";
        String motherFirstName = "Fauna";
        String motherLastName = "Flora";
        String motherMiddleName = "n/a";
        String first = "Jeezebel";
        String middle = "Fauna";
        String last = "Flora";
        String newbornScreeningNumber = "2093-jid";

        Person person = new Person(
                2,             first,    middle,
                last,        1202,       12,
                15,            1232439,    4949,
                gender,        "f",       newbornScreeningNumber,
                2,             birthCounty,   "930-293-3448",
                "944-748-4587", motherFirstName,      motherLastName,
                motherMiddleName);

        List personInfo = person.info();

        assertEquals(gender, personInfo.get(0));
        assertEquals(birthCounty, personInfo.get(1));
        assertEquals(motherFirstName, personInfo.get(2));
        assertEquals(motherLastName, personInfo.get(3));
        assertEquals(motherMiddleName, personInfo.get(4));
        assertEquals(first, personInfo.get(5));
        assertEquals(middle, personInfo.get(6));
        assertEquals(last, personInfo.get(7));
        assertEquals(newbornScreeningNumber, personInfo.get(8));
    }

    @Test
    public void tempInfo() throws Exception {
        Person person = new Person(3);
        String phone1 = "088-499-8844";
        String phone2 = "038-496-8844";
        person.setPhone1(phone1);
        person.setPhone2(phone2);

        List personTempInfo = person.tempInfo();

        assertEquals(phone1, personTempInfo.get(0));
        assertEquals(phone2, personTempInfo.get(1));
    }

    @Test
    public void outputId() throws Exception {
        Integer id = 5;
        Person person = new Person(id);
        assertNotSame(id, person.outputId());
        assertEquals(String.valueOf(id), person.outputId());
    }

    @Test
    public void output() throws Exception {
        Integer id = 5;
        Integer birthYear = 2018;
        Integer birthMonth = 2;
        Integer birthDay = 24;
        String first = "Jeezebel";
        String middle = "Fauna";
        String last = "Flora";


        Person person = new Person(id);
        person.setObjectId(id);
        person.setFirstName(first);
        person.setMiddleName(middle);
        person.setLastName(last);
        person.setBirthYear(birthYear);
        person.setBirthMonth(birthMonth);
        person.setBirthDay(birthDay);

        String result = "Id = " + String.valueOf(id) + ", Name = " + first + " " + middle
                + " " + last + ", BirthDate = " + String.valueOf(birthMonth) + "/" + String.valueOf(birthDay) + "/"
                + String.valueOf(birthYear);

        assertEquals(result, person.output());

    }

    //TODO test for null values
}