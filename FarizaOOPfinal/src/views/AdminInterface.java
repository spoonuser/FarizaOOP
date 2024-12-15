package views;

import UserSystem.*;
import data.DataManager;
import enums.Faculty;
import enums.ManagerType;
import enums.Role;
import enums.Speciality;
import enums.StudentType;
import enums.TeacherType;

import java.util.Scanner;

public class AdminInterface {
	
	private Admin admin ;
	public DataManager dataManager;

	public AdminInterface(Admin admin, DataManager dataManager) {
		this.admin = admin ; 
		this.dataManager = dataManager;
	}

	public void startAdminPanel() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			System.out.println("\n---Admin Panel---");
            System.out.println("1. View all users");
            System.out.println("2. Add new user");
            System.out.println("3. Delete user");
            System.out.println("4. Save changes");
            System.out.println("5. Exit admin panel");
            System.out.print("Enter your choice: ");
            
            try {
            	int choice = Integer.parseInt(scanner.nextLine());
            	switch(choice) {
            		case 1:
            			viewAllUsers();
            			break;
            		case 2:
            			addNewUser(scanner);
            			break;
            		case 3:
            			deleteUser(scanner);
            			break;
            		case 4:
            			saveChanges();
            			break;
            		case 5:
            			System.out.println("Exiting admin panel...");
            			running = false; 
            			break;	
            		default : 
            			System.out.println("Invalid choice. Please try again.");
            		}
            	}
            	catch(NumberFormatException e){
            		System.out.println("Please enter a valid number."); 
            }
		}	
	}

	// 1. View all users
	public void viewAllUsers() {
		System.out.println("\n--- List of Users ---");
		if(dataManager.users.isEmpty()) {
			System.out.println("No users found");
		}
		else {
			for(int i=0 ; i<DataManager.users.size() ; i++) {
				User user = DataManager.users.get(i);
				System.out.println((i+1) + ". " + user);
			}
		}
	}
	
	// 2. Add new user
	public void addNewUser(Scanner scanner) {
		System.out.println("Enter Login: ");
		String login = scanner.nextLine();
		
		//для уникальности 
		for(User user : dataManager.users) {
			if(user.getLogin().equals(login)) {
				System.out.println("This login is already taken. Please choose a different login.");
	            return;
			}
		}
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		System.out.print("Enter Name: ");
	    String name = scanner.nextLine();
	    System.out.print("Enter Last Name: ");
	    String lastName = scanner.nextLine();
	    System.out.print("Enter ID: ");
	    String id = scanner.nextLine();
	    System.out.print("Enter Email: ");
	    String email = scanner.nextLine();
	    System.out.print("Enter Age: ");
	    int age = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("Enter role (ADMIN, STUDENT, TEACHER, MANAGER, FINANCEMANAGER): ");
	    String role = scanner.nextLine().toLowerCase();
	    
	    User newUser = null; 
	    
	    switch(Role.valueOf(role.toUpperCase())) {
	    	case ADMIN:
	    		newUser = new UserSystem.Admin(login , password , name , lastName, id, email , age);
	    		break ;
	    	case STUDENT:
	    		System.out.println("Available Student Type:");
	    		 for(StudentType studentType : StudentType.values()) {
	    			 	System.out.println("- " + studentType );
	    		 }
	    		 StudentType selectedStudentType = null ; 
	    		 while(selectedStudentType == null) { 
	    			 System.out.println("Enter StudentType from the list above: ");
	    			 String studentTypeInput = scanner.nextLine().toUpperCase();
	    			 try {
	    				 selectedStudentType = StudentType.valueOf(studentTypeInput);
	    			 }
	    			 catch(IllegalArgumentException e){
	    				 System.out.println("Invalid faculty. Please try again.");
	    			 } 
	    		 }
	    		 
	    		 
	    		 System.out.println("Available faculties: ");
	    		 for(Faculty faculty : Faculty.values()) {
	    			 	System.out.println("- " + faculty );
	    		 }
	    		 Faculty selectedFaculty = null ; 
	    		 while(selectedFaculty == null) { 
	    			 System.out.println("Enter faculty from the list above: ");
	    			 String facultyInput = scanner.nextLine().toUpperCase();
	    			 try {
	    				 selectedFaculty = Faculty.valueOf(facultyInput);
	    			 }
	    			 catch(IllegalArgumentException e){
	    				 System.out.println("Invalid faculty. Please try again.");
	    			 } 
	    		 }
	    		//3
	            System.out.print("Enter year of study : ");
	            int year = scanner.nextInt();
	            scanner.nextLine();
	            //4
	            System.out.println("Available specialties : ");
	            for(Speciality speciality : Speciality.values()) {
	            	System.out.println("- " + speciality );
	            }
	            
	            Speciality selectedSpeciality = null ;
	            while(selectedSpeciality == null) {
	            	System.out.println("Enter speciality from the list above: ");
	            	String specialityInput = scanner.nextLine().toUpperCase();
	            	try {
	            		selectedSpeciality = Speciality.valueOf(specialityInput);
	            	}
	            	catch(IllegalArgumentException e) {
	            		System.out.println("Invalid faculty. Please try again.");
	            	}
	            }
	            newUser = new UserSystem.Student(login, password, name, lastName, id, email, age, selectedStudentType ,selectedFaculty ,year ,selectedSpeciality);
	            break; 
	    	case TEACHER:
	    		//1 
	    		System.out.println("Available Teacher Type: ");
	            for(TeacherType teacherType : TeacherType.values()) {
	            	System.out.println("- " +teacherType);
	            }
	            
	            TeacherType selectedTeacherType = null; 
	            while(selectedTeacherType == null) {
	            	System.out.println("Enter teacher type from the list above: ");
	            	String teacherTypeInput = scanner.nextLine().toUpperCase();
	            	try {
	            		selectedTeacherType = TeacherType.valueOf(teacherTypeInput);
	            	}
	            	catch(IllegalArgumentException e) {
	            		System.out.println("Invalid faculty. Please try again;");
	            	}
	            }
	            newUser = new UserSystem.Teacher(login, password, name, lastName, id, email, age, 0, selectedTeacherType );
	            break;
	    	case MANAGER: 
	    		//1 
	    		System.out.println("Available Manager Type: ");
	            for(ManagerType managerType : ManagerType.values()) {
	            	System.out.println("- " +managerType);
	            }
	            
	            ManagerType selectedManagerType = null; 
	            while(selectedManagerType == null) {
	            	System.out.println("Enter manager type from the list above: ");
	            	String managerTypeInput = scanner.nextLine().toUpperCase();
	            	try {
	            		selectedManagerType = ManagerType.valueOf(managerTypeInput);
	            	}
	            	catch(IllegalArgumentException e) {
	            		System.out.println("Invalid faculty. Please try again;");
	            	}
	            }
	            newUser = new UserSystem.Manager(login, password, name, lastName, id, email, age, 0, selectedManagerType);
	            break;
	    	case FINANCEMANAGER :
	    		newUser = new UserSystem.FinanceManager(login, password, name, lastName, id, email, age, 0);
	    		break; 
	    	
	    	default: 
	    		System.out.println("Invalid role. User not added");
	    		return ;	
	    }
	    dataManager.users.add(newUser);
	    System.out.println("User added successfully!");
	}
	
	// 3. Delete user
	private void deleteUser(Scanner scanner) {
		viewAllUsers();
		System.out.println("Enter the number of the user to delete: ");
		try {
			int index = Integer.parseInt(scanner.nextLine()) -1 ;
			if(index >=0 && index < dataManager.users.size()) {
				User removedUser = dataManager.users.remove(index);
				System.out.println("User " + removedUser.getLogin() + " removed successfully.");
			}
			else {
				System.out.println("Invalid number");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a valid number");
		}
	}
	
	//4. Save changes
	public void saveChanges() {
		DataManager.saveUsers();
	}

}
