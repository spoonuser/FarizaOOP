package UserSystem;

import enums.Faculty;
import enums.Speciality;
import enums.StudentType;

public class Student extends User {
	
	private StudentType studentType ;
	private Faculty faculty ;
	private int year ;
	private Speciality speciality;
	

	public Student(String login, String password, String name, String lastName, String id, String email, int age,StudentType studentType, Faculty faculty ,int year , Speciality speciality ) {
		super(login, password, name, lastName, id, email, age);
		this.studentType = studentType ; 
		this.faculty = faculty ;
		this.year = year;
		this.speciality = speciality ; 
		
	}

	@Override
	public void getUserInfo() {
		// TODO Auto-generated method stub
		
	}

	

	
}
