package views;

import java.io.IOException;
import java.util.Scanner;

import UserSystem.*;
import data.DataManager;
import frames.LoginFrame;
import frames.WelcomeFrame;

public class UserInterface {
	LoginFrame logFrame;
	WelcomeFrame welcome;
    private final DataManager dataManager;
    private boolean running = true;

    public UserInterface(DataManager dataManager) {
        this.dataManager = dataManager;
    }
    private void openRegistration() {
        System.out.println("Opening Registration Window...");
        new LoginFrame(); // Создаем и открываем окно регистрации
    }

    public void start() {
    	welcome = new WelcomeFrame();
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Welcome to the Telepuziki University System");
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Очистить некорректный ввод
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистить буфер ввода

        }

        scanner.close();
    }

    public void login(String login, String password) {
    	logFrame = new LoginFrame();

        System.out.println("Enter login: ");
        System.out.println("Enter password: ");
        System.out.println(login);
        System.out.println(password);

        User user = dataManager.authenticate(login, password);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getName());

            if (user instanceof Admin admin) {
                System.out.println("Opening Admin Panel...");
                AdminInterface adminInterface = new AdminInterface(admin, dataManager);
                adminInterface.startAdminPanel();
            } else if (user instanceof Student) {
                System.out.println("Opening Student Panel...");
                // Реализуйте вызов интерфейса для студента
            } else if (user instanceof Manager) {
                System.out.println("Opening Manager Panel...");
                // Реализуйте вызов интерфейса для менеджера
            } else {
                System.out.println("Unknown role. Access denied.");
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}




