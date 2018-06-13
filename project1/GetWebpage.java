import java.net.*;
import java.io.*;

public class GetWebpage {
	public static void main(String args[]) throws Exception {

		// args[0] has the URL passed as the command parameter.
		// You need to retrieve the webpage corresponding to the URL and print it out on console
		// Here, we simply printout the URL
		// System.out.println(args[0]);

		StringBuilder content = new StringBuilder();

		// many of these calls can throw exceptions, so I've just wrapped them all in one try/catch
		// statement.
		try {
			// create a url object
			URL url = new URL(args[0]);

			// create a urlconnection object
			URLConnection urlConnection = url.openConnection();

			// wrap the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));

			String line;

			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null)
			{
				content.append(line + "\n");
			}
			bufferedReader.close();

			System.out.print(content);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}		      
	}
}
