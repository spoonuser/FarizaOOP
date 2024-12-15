package UserSystem;

import enums.TeacherType;

public class Teacher extends Employee{
	
	private TeacherType teacherType;
	
	public Teacher(String login, String password, String name, String lastName, String id, String email, int age,int salary , TeacherType teacherType) {
		super(login, password, name, lastName, id, email, age, salary);
		this.teacherType = teacherType;
	}
	
	
	
	 
	
	
	

	

	

}
