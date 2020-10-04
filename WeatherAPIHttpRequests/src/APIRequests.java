import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIRequests {
	public static final String WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q=London&appid=ba0bd319629bb3eb606ce77f7d8349d5";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .headers("accept", "application/json")
                .uri(URI.create(WEATHER_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode() +"\n" + response.body());
        
        // parse JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //Allows us to ignore bits of JSON data
        		// that we don't want without the object mapper failing

        weather weather1 = mapper.readValue(response.body(), new TypeReference<weather>() {} );
      //  List<weather> weather1 = mapper.readValue(response.body(), new TypeReference<List<weather>>() {});


		/*
       weather1.forEach(post -> {
           System.out.println(post.toString());
        });
	   weather1.forEach(System.out::println);
	   */
       System.out.println(weather1.getBase());;
    }
}
