import java.util.List;

public class Elixir {
    public String id;
    public String name;
    public String effect;
    public String sideEffects;
    public String characteristics;
    public String time;
    public String difficulty;
    public List<Ingredients> ingredients;
    public List<Inventor> inventors;
    public String manufacturer;

    private static class Ingredients {
        public String id;
        public String name;
    }

    private static class Inventor {
        public String id;
        public String firstName;
        public String lastName;
    }

}
