package clientLourd;

import java.util.ArrayList ;
import clientLourd.File ;

public class Folder 
{
	private int id ; 
	private String path ; 
	private int version ;
	private String nom ;
	
	private ArrayList<File> files ; 
	private ArrayList<Folder> folders ;
	
	public Folder(	int id, 
					String path, 
					int version, 
					String nom, 
					ArrayList<File> files, 
					ArrayList<Folder> folders) 
	{
		super();
		this.id = id;
		this.path = path;
		this.version = version;
		this.nom = nom;
		this.files = files;
		this.folders = folders;
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

	public ArrayList<File> getFiles() 
	{
		return files;
	}

	public void setFiles(ArrayList<File> files) 
	{
		this.files = files;
	}

	public ArrayList<Folder> getFolders() 
	{
		return folders;
	}

	public void setFolders(ArrayList<Folder> folders) 
	{
		this.folders = folders;
	} 
	
	
}
