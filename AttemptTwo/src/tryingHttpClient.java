
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;




public class tryingHttpClient {

    public static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println( "Status Code:" + response.statusCode() + "\n" + response.body());
        // parse JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //now can ignore body data because of this
        List<Post> posts = mapper.readValue(response.body(), new TypeReference<List<Post>>() {});

       posts.forEach(post -> {
           System.out.println(post.toString());
        });
	   posts.forEach(System.out::println);
	   System.out.println(posts.get(0).getId());
	   
	   //Converting a post object back to JSON
	   String json = mapper.writeValueAsString(posts.get(0));
	   System.out.println(json);
	   
	   
	   
	  //Writes all posts to .json file in JSON format.
	   mapper.writeValue(  new FileOutputStream("C:\\Users\\micha\\Documents\\dataJSON.json"), posts);
	   
	   
	   JsonFactory factory = new JsonFactory();

	   JsonGenerator generator = factory.createGenerator(
	       new File("C:\\Users\\micha\\Documents\\data.json"), JsonEncoding.UTF8);
	   /*
	   generator.writeStartObject();
	   generator.writeStringField("brand", "Mercedes");
	   generator.writeNumberField("doors", 5);
	   generator.writeEndObject();
	   
	  generator.writeStartObject(); 
	  generator.writeFieldName("technologies");
      generator.writeStartArray();
      generator.writeString("SAP");
      generator.writeString("Java");
      generator.writeString("Selenium");
      generator.writeEndArray();
      generator.writeEndObject();
      
      //Last bit Looks like   {"technologies" : [ "SAP", "Java", "Selenium" ]}
       * 
       *Check out this page for writing JSON with JSON Generator :https://crunchify.com/java-jsongenerator-json-processing-api-and-how-to-enable-pretty-print-json-output-gson-jackson/
	   *Page explains how to write like the nested objects in json.
	   */

	   generator.writeStartObject();
	   generator.writeFieldName("IDs");
	   generator.writeStartArray();
	   for( int i=0; i<posts.size()-1; i++) {
		  generator.writeNumber(posts.get(i).getId());
	   };
	   generator.writeEndArray();
	   generator.writeEndObject();

	   generator.close();
	   //Creates JSON: {"IDs":[1,2,3,4,5,6,7,8......]}
	   
	   
	   // Example of a POST request
	   var values = new HashMap<String, String>() {{
           put("name", "John Doe");
           put ("occupation", "gardener");
       }};

       var objectMapper = new ObjectMapper();
       String requestBody = objectMapper.writeValueAsString(values);
       
       HttpRequest postRequest = HttpRequest.newBuilder()
               .uri(URI.create("https://httpbin.org/post"))
               .POST(HttpRequest.BodyPublishers.ofString(requestBody))
               .build();

       HttpResponse<String> postResponse = client.send(postRequest,
               HttpResponse.BodyHandlers.ofString());

       System.out.println(postResponse.body());
       
       String a = "2020-12-17";
       String b = "2020-12-17";
       System.out.println(a.equals(b));
	   
	}
}


