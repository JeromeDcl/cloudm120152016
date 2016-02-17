package test;

import java.io.IOException;

import clientLourd.User;

public class TestGlobal {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		User u = new User() ; 
		u.saveCurrentUser() ;
		
		try {
			TestHttpUser.doIt() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
