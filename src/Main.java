import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Main {
    private static final String API_URL = "https://wizard-world-api.herokuapp.com/";

    @XmlRootElement(name = "elixirs")
    static class Elixirs {
        public Elixirs(){
            elixirsList = new ArrayList<>();
        }

        private Elixirs(Elixir[] elixirs) {
            elixirsList = List.of(elixirs);
        }

        @XmlElement(name = "elixir")
        List<Elixir> elixirsList;
    }

    public static void main(String[] args) throws JAXBException {
        parseAPI();
    }

    private static void parseAPI() throws JAXBException {
        String jsonTest = readFromUrlStr(API_URL+"Elixirs");

        Elixir[] elixirs = new Gson().fromJson(jsonTest, Elixir[].class);

        Marshaller marshaller = JAXBContext.newInstance(Elixirs.class).createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(new Elixirs(elixirs), System.out);
    }

    private static String readFromUrlStr(String url) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON from URL", e);
        }
    }
}