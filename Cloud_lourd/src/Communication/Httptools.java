package Communication;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class Httptools {

public static String ipserver = "http://149.91.83.84:80/";
	
public static String get(String url,String token) throws IOException
	{	 
		url = ipserver+url;
		String source ="";
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		yc.setRequestProperty ("Authorization","Token " + token);
		System.out.println(yc.getRequestProperty("Authorization"));
		BufferedReader in = new BufferedReader(
		new InputStreamReader(yc.getInputStream()));
		String inputLine;
		 
		while ((inputLine = in.readLine()) != null)
			source +=inputLine;
			in.close();
		return source;
	}	
	

public static String get(String url) throws IOException
{	 
	url = ipserver+url;
	String source ="";
	URL oracle = new URL(url);
	URLConnection yc = oracle.openConnection();
	BufferedReader in = new BufferedReader(
	new InputStreamReader(yc.getInputStream()));
	String inputLine;
	 
	while ((inputLine = in.readLine()) != null)
		source +=inputLine;
		in.close();
	return source;
}	


// TODO : verification erreur serveur ou fonction. 
// Obsoléte. 
/*
public static String excutePost(String targetURL, String urlParameters) {
	  HttpURLConnection connection = null;  
	  try {
	    //Create connection
	    URL url = new URL(targetURL);
	    connection = (HttpURLConnection)url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

	    connection.setRequestProperty("Content-Length", 
	        Integer.toString(urlParameters.getBytes().length));
	    connection.setRequestProperty("Content-Language", "en-US");  

	    connection.setUseCaches(false);
	    connection.setDoOutput(true);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.writeBytes(urlParameters);
	    wr.close();

	    //Get Response  
	    InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder(); // Stringbuffer à utiliser pour les version antérieures de java 5
	    String line;
	    while((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    return response.toString();
	  }
	  catch (Exception e) {
	    e.printStackTrace();
	    return null;
	  } finally {
	    if(connection != null) {
	      connection.disconnect(); 
	    }
	  }
	}
*/




public static String sendPOST(String targetURL, String urlParameters) throws IOException {
	targetURL = ipserver+targetURL;
    URL obj = new URL(targetURL);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    // debut du post
    con.setDoOutput(true);
    OutputStream os = con.getOutputStream();
    os.write(urlParameters.getBytes());
    os.flush();
    os.close();
    // FIn du post

    int responseCode = con.getResponseCode();
    System.out.println("POST Response Code :: " + responseCode);

    if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 201 || responseCode==200) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
      return (response.toString());
    } else {
        System.out.println("POST request not worked");
        return ("error");
    }
}


//TODO : à compléter
public static String sendPOST(String targetURL, String urlParameters,String token) throws IOException {
	targetURL = ipserver+targetURL;
    URL obj = new URL(targetURL);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    con.setRequestProperty ("Authorization","Token "+token);

    // debut du post
    con.setDoOutput(true);
    OutputStream os = con.getOutputStream();
    os.write(urlParameters.getBytes());
    os.flush();
    os.close();
    // FIn du post

    int responseCode = con.getResponseCode();
    System.out.println("POST Response Code :: " + responseCode);

    if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 201 || responseCode==200) { //success
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
      return (response.toString());
    } else {
        System.out.println("POST request not worked");
        return ("error");
    }
}


}