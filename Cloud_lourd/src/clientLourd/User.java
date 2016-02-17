package clientLourd;

import java.io.* ;
import java.nio.charset.Charset;
import java.nio.file.* ;

import org.json.JSONException;
import org.json.JSONObject;

import Communication.Httptools;

public class User 
{
	private int 		id 			; 
	private String 		login 		;
	private String 		pwd 		;
	private String 		name 		; 
	private String 		firstName 	; 
	private Birthday 	birthday 	; 
	private String 		mail 		;  
	
	private String 		path 		; 
	private String	 	token		;

	// Test uniquement. TODO remettre tout ça en ordre. 
	public User() 
	{
		
		this.id = -1 ;
		this.login = "A71" ; 
		this.pwd = "bbbaaa" ; 
		this.name = "Peage";
		this.firstName = "DDE" ;
		this.birthday = new Birthday(0,0,0) ;
		this.mail = "blabla@ghblabla.gla" ;
		this.path = "la/ou/je/veux/dans/le/pc" ;
	}
	
	public User(int id, String login, String pwd, String name, String firstName, Birthday birthday, String mail, String path) 
	{
		super();
		this.id = id;
		this.login = login ; 
		this.pwd = pwd ; 
		this.name = name;
		this.firstName = firstName;
		this.birthday = birthday;
		this.mail = mail;
		this.path = path;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getPwd() 
	{
		return this.pwd;
	}

	public String getToken()
	{
		return this.token;
	}
	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	private Birthday getBirthday() 
	{
		return birthday;
	}

	public void setBirthday(Birthday birthday) 
	{
		this.birthday = birthday;
	}

	
	public String getMessBirthday()
	{
		return (this.getBirthday().write() ) ;
	}
	
	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}

	// fonction qui enregistre dans un fichier défini les infos du dernier user co sur le pc. 
	public void saveCurrentUser() 
	{
		Charset charset = Charset.forName("UTF-8") ;
		Path pathDocSauv = Paths.get("C:/Users/Jerome/workspace/Cloud_lourd/currentUser.txt") ; 
		boolean sauvExist = Files.exists(pathDocSauv) ; 
		
		if(sauvExist)
		{
			try (BufferedWriter writer = Files.newBufferedWriter(pathDocSauv,charset) )
			{
				String mess = "" ;
				mess = mess + this.getId() + "\n" ;
				mess = mess + this.getFirstName() + "\n" ;
				mess = mess + this.getName() + "\n" ;
				mess = mess + this.getMail() + "\n" ;
				mess = mess + this.getPath() + "\n" ;
				mess = mess + this.getMessBirthday() + "\n" ;
				
				writer.write(mess, 0, mess.length() ) ;
				
				writer.close();
			}
			catch (IOException ioe) 
			{
				ioe.printStackTrace();
			} 
		}
	}
	
	public void generateToken() throws IOException, JSONException
	{
		String url = "token/";
		String login = "username=" + this.login;
		String pwd = "&password=" + this.pwd;
	    String urlParameters = login+pwd;
	  
		System.out.println(urlParameters);
		String valret = Httptools.sendPOST(url, urlParameters);
		JSONObject gson = new JSONObject(valret);
		this.token = gson.getString("token");
	}
	
	

	// TODO : fonction ajoutant les users dans un fichier peu à peu, si déjà co sur le pc.  
}
