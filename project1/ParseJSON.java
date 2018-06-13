import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseJSON {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {

    // Read the given json file and parse it using JSONParser
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject)parser.parse(new FileReader("data/simplewiki-abstract.json"));

    // Once we have the JSONObject, we can access the different fields by using the 'get' method.
    // The 'get' method returns a value of type Object. We must cast the returned value to the correct type.
    JSONObject simplewiki = (JSONObject)jsonObject.get("simplewiki");
    JSONArray pages = (JSONArray)simplewiki.get("page");

    //Create a file that contains the documents in a format that can be indexed using the Elasticsearch bulk API.
    PrintWriter writer = new PrintWriter("data/out.txt", "UTF-8");

    int idCount = 1;
    for(Object page : pages) {
      // Use the bulk indexing api from elasticsearch to index the file.
      // TODO: Add the headers needed for using bulk indexing API.
      // Ensure that the _id for the entry in the index matches the line number of that document.
      
      // Create JSON object and add id and type
      JSONObject field = new JSONObject();
      field.put("_type", "wikipage");
      field.put("_id", idCount++);

      // Create JSON object and add fields to the document
      JSONObject json = new JSONObject();
      json.put("index", field);
      writer.println(json.toJSONString());
      
      // Write Json Page entry to file
      writer.println(page);
    }

    writer.close();
  }
}