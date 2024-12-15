package frames;

import javax.swing.*;

import data.DataManager;
import views.UserInterface;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class LoginFrame extends JFrame {
	public String LOGIN;
	public String PASSWORD;
	DataManager dataManager = new DataManager("user.txt");

	public boolean cycle = true;
    // Загружаем пользователей из файла
	UserInterface userInterface = new UserInterface(dataManager);

    public LoginFrame() {
        // Установка параметров окна
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(400, 200, 500, 300);

        // Создание компонентов
        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton LoginButton = new JButton("Login");

        // Установка размеров и положения компонентов
        loginLabel.setBounds(50, 50, 100, 30);
        loginField.setBounds(150, 50, 250, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 250, 30);
        LoginButton.setBounds(150, 150, 200, 50);

        // Добавление компонентов в окно
        this.add(loginLabel);
        this.add(loginField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(LoginButton);

        
        // Обработка события для кнопки регистрации
        LoginButton.addActionListener((ActionEvent e) -> {
        	LOGIN = loginField.getText();
        	PASSWORD = passwordField.getText();
        	userInterface.login(LOGIN,PASSWORD);
        });

        // Показать окно
        this.setVisible(true);
    }
    public String getLogin() {
		return LOGIN;
    }
    public String getPassword() {
    	return PASSWORD;
    }
}
