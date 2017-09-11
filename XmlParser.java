import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class XmlParser implements Parser {
    private String error;

    public XmlParser(){
        error = "";
    }

    @Override
    public List<Person> parse(String filename) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filename);

        List<Person> people = new ArrayList<Person>();

        try {

            Document document = builder.build(xmlFile);
            List<Element> ch = document.getRootElement().getChildren("Person");
            for (Element element : ch) {
                Person person = new Person();

                try{
                    person.setObjectId(Integer.parseInt(element.getChildText("ObjectId")));
                }catch(NumberFormatException e){

                }
                try{
                    person.setSocialSecurityNumber(Integer.parseInt(element.getChildText("SocialSecurityNumber")));
                }catch(NumberFormatException e){

                }
                try{
                    person.setBirthYear(Integer.parseInt(element.getChildText("BirthYear")));
                }catch(NumberFormatException e){

                }
                try{
                    person.setBirthMonth(Integer.parseInt(element.getChildText("BirthMonth")));
                }catch(NumberFormatException e){

                }
                try{
                    person.setBirthDay(Integer.parseInt(element.getChildText("BirthDay")));
                }catch(NumberFormatException e){

                }
                try{
                    person.setBirthOrder(Integer.parseInt(element.getChildText("BirthOrder")));
                }catch(NumberFormatException e){

                }

                person.setStateFileNumber(element.getChildText("StateFileNumber"));
                person.setFirstName(element.getChildText("FirstName"));
                person.setMiddleName(element.getChildText("MiddleName"));
                person.setLastName(element.getChildText("LastName"));
                person.setGender(element.getChildText("Gender"));
                person.setPhone1(element.getChildText("Phone1"));
                person.setPhone2(element.getChildText("Phone2"));
                person.setNewbornScreeningNumber(element.getChildText("newbornScreeningNumber"));
                person.setIsPartOfMultipleBirth(element.getChildText("isPartOfMultipleBirth"));
                person.setMotherFirstName(element.getChildText("MotherFirstName"));
                person.setMotherMiddleName(element.getChildText("MotherMiddleName"));
                person.setMotherLastName(element.getChildText("MotherLastName"));

                people.add(person);
            }

        } catch (IOException io) {
            error = io.getMessage();
        } catch (JDOMException jdomex) {
            error = jdomex.getMessage();
        }

        return people;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
