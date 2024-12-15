package UserSystem;

import java.io.Serializable;
/*
 login 
 password 
 name
 lastName 
 id
 */
public abstract class User implements Serializable{
	private String login ;
	private String password ;
	private String name; 
	private String lastName;
	private  String id ;
	private String email;
	private int age;
	
	public User(String login, String password, String name , String lastName, String id, String email ,int age ) {
		this.login = login ; 
		this.password = password;
		this.name = name;
		this.lastName = lastName ;  
		this.id = id;
		this.email = email;
		this.age = age; 
	}
	
	public String getLogin() {
		return login; 
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}

	public abstract void getUserInfo();
	
	public String toString() {
		return "Login = " + getLogin() + ", Password = " + getPassword();
	}
	
		
}
