package UserSystem;

import enums.ManagerType;

public class Manager extends Employee {
	
	private ManagerType managerType; 

	public Manager(String login, String password, String name, String lastName, String id, String email, int age,int salary, ManagerType managerType) {
		super(login, password, name, lastName, id, email, age, salary);
		this.managerType = managerType;
	}
	

	
	
	

	
}
