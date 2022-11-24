package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import static javax.swing.UIManager.get;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, JAXBException, IOException {
        URL url = new URL("https://pokeapi.co/api/v2/pokemon/salamence");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonObject.class)
                .get("abilities").getAsJsonArray()
                .get(0).getAsJsonObject();
                              
        Abilities abilities = gson.fromJson(jsonObject, Abilities.class);
        System.out.println(abilities.toString());
        JAXBContext context = JAXBContext.newInstance(Abilities.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(abilities, System.out);
    }
    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
}
