package clientLourd;

public class Birthday 
{
	private int day ; 
	private int month ; 
	private int year ; 
	
	
	
	public Birthday(int day, int month, int year) 
	{
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}



	public String write()
	{
		String birthday = "" ; 
		
		birthday = day + "/" + month + "/" + year ; 
		
		return birthday ; 
 	}
}
