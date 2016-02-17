package clientLourd;

public class File 
{
	
	private int id ; 
	private String path ; 
	private int version ;
	private String nom ;
	
	public File(int id, String path, int version, String nom) 
	{
		super();
		this.id = id;
		this.path = path;
		this.version = version;
		this.nom = nom;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}

	public int getVersion() 
	{
		return version;
	}

	public void setVersion(int version) 
	{
		this.version = version;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}
}
