package test;

import java.io.IOException;
import Communication.Httptools;
import clientLourd.* ;
import org.json.*;


public class TestHttpUser 
{

	public static void doIt() throws IOException  
	{
		String login = "Testclientlourd";
		String pwd = "hahaha";
		User userTest = new User(-2, "clientlourdtest2", "password2", "NameTest1", "FirstNameTest1", new Birthday(02, 04, 1998), "monMail2@SMail.com", "mon/petit/chemin") ;
		
		/*
		System.out.println("Test Insert 1 :") ;
		// user non créé
		try 
		{
			insertuser(userTest);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("get token test:") ;
		try 
		{
			userTest.generateToken();
			System.out.println(userTest.getToken());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//createtree(userTest);
		gettree(userTest);
		
		
	}
	
	
	//obsolète
	public static void authentification(String ipserv, String login, String pwd)
	{
		String testget;
		String urlauth= "/auth/?login="+login+"&pwd="+pwd;
			
			//Test pour la methode Get
			try {
				testget = Httptools.get(urlauth);
				System.out.println(testget);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	//obsolète
	public static void authentification( User user)
	{
		String testget;
		String urlauth= "/auth/?login="+user.getLogin()+"&pwd="+user.getPwd();
			
			//Test pour la methode Get
			try {
				testget = Httptools.get(urlauth);
				System.out.println(testget);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
// obsolète 
	public static void insertuser(String ipserv) throws IOException
	{
		String urlinsert = "auth/";
		String login = "login=Testclientlourd3";
		String pwd = "&pwd=hahaha";
		String fname= "&fname=Letest3";
		String lname= "&lname=duclient3";
		String mail = "&mail=mail@factice2.com";
		String birthday ="&birthday=29/07/1993";
	  String urlParameters = login+pwd+fname+lname+mail+birthday;
	  
		System.out.println(urlinsert);
		System.out.println(urlParameters);
		String valret = Httptools.sendPOST(urlinsert, urlParameters);
		System.out.println(valret);
		
	}
	
	public static void insertuser(User u) throws IOException
	{
		String url = "auth/";
		
		String login = "login=" + u.getLogin();
		String pwd = "&pwd=" + u.getPwd() ;
		String fname= "&fname=" + u.getFirstName() ;
		String lname= "&lname=" + u.getName() ;
		String mail = "&mail=" + u.getMail() ;
		String birthday ="&birthday=" + u.getMessBirthday() ;
	    String urlParameters = login+pwd+fname+lname+mail+birthday;
	  
		System.out.println(urlParameters);
		String valret = Httptools.sendPOST(url, urlParameters);
		System.out.println(valret);
		
	}
	
	public static void gettoken(User u) throws IOException, JSONException
	{
		String url = "token/";
		String login = "username=" + u.getLogin();
		String pwd = "&password=" + u.getPwd() ;
	    String urlParameters = login+pwd;
	  
		System.out.println(urlParameters);
		String valret = Httptools.sendPOST(url, urlParameters);
		System.out.println(valret);
		JSONObject gson = new JSONObject(valret);
		System.out.println(gson.getString("token"));
		
	}
	
	
	
	public static void createtree(User u) throws IOException
	{
		String url = "tree/";
		String token = u.getToken();
		String name = "name=Dossier1";
		String valret = Httptools.sendPOST(url,name, token);
		System.out.println(valret);
	}
	
	public static void gettree(User u) throws IOException
	{
		String url = "tree/";
		String token = u.getToken();
		String valret = Httptools.get(url, token);
		System.out.println(valret);
	}
	
}
