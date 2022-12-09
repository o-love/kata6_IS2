import jakarta.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "elixir")
public class Elixir {
    public String id;
    public String name;
    public String effect;
    public String sideEffects;
    public String characteristics;
    public String time;
    public String difficulty;

    @XmlElementWrapper
    @XmlElement(name = "ingredient")
    public List<Ingredients> ingredients;

    @XmlElementWrapper
    @XmlElement(name = "inventor")
    public List<Inventor> inventors;
    public String manufacturer;

    @XmlRootElement(name = "ingredient")
    private static class Ingredients {
        public String id;
        public String name;
    }

    @XmlRootElement(name = "inventor")
    private static class Inventor {
        public String id;
        public String firstName;
        public String lastName;
    }
}
