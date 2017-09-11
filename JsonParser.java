import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;

public class JsonParser implements Parser {
    private String error;

    public JsonParser(){
        error = "";
    }

    @Override
    public List<Person> parse(String filename) {
        JsonReader jsonReader = null;

        try {
            jsonReader = new JsonReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            error = "file not found";
            return null;
        }

        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        List<Person> person = new ArrayList<Person>();

        try {
            person = Arrays.asList(gson.fromJson(jsonReader, Person[].class));
        }catch(JsonParseException e) {
            error = e.getMessage();
        }


        return person;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
