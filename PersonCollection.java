import java.util.List;
import java.util.Arrays;

public class PersonCollection{
    private List<Person> person;

    public PersonCollection(){
        person = Arrays.asList();
    }

    public PersonCollection(List<Person> person){
        this.person = person;
    }

    public List<Person> getPerson(){
        return person;
    }

    public void setPerson(List<Person> person){
        this.person = person;
    }
}