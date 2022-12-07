import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class Main {
    private static final String API_URL = "https://wizard-world-api.herokuapp.com/";

    public static void main(String[] args) {
        String jsonTest = readFromUrlStr(API_URL+"Elixirs");

        Elixir[] elixirs = new Gson().fromJson(jsonTest, Elixir[].class);

        for (Elixir elixir: elixirs) {
            System.out.println(elixir.id);
        }
    }

    private static String readFromUrlStr(String url) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return reader.lines().collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON from URL", e);
        }
    }
}