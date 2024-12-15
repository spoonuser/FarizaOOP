package UserSystem;

public abstract class Employee extends User {
	
	private int salary = 0 ;
	

	public Employee(String login, String password, String name, String lastName, String id, String email, int age, int salary) {
		super(login, password, name , lastName, id,email ,age);
		this.salary = 0;
	}

	@Override
	public void getUserInfo() {
		// TODO Auto-generated method stub
		
	}

}
