package frames;

import javax.swing.*;

import data.DataManager;
import views.UserInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class WelcomeFrame extends JFrame {
	DataManager dataManager = new DataManager("user.txt");

    // Загружаем пользователей из файла
	UserInterface userInterface = new UserInterface(dataManager);
	LoginFrame logframe;
    public WelcomeFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(400, 200, 800, 500);
        this.setVisible(true);
        JLabel label = new JLabel("Welcome to Telepuziki University!");
        label.setBounds(200, 50, 500, 50);
        Font customFont = new Font("Arial", Font.BOLD, 24); 
        label.setFont(customFont);
        this.add(label);
        JButton RegistrateButton = new JButton("Registrate");
        JButton LoginButton = new JButton("Login");
        JButton ExitButton = new JButton("Exit");
        RegistrateButton.setBounds(100, 205, 150, 50);
        RegistrateButton.setFocusable(false);
        LoginButton.setBounds(300, 205, 150, 50);
        LoginButton.setFocusable(false);
        ExitButton.setBounds(500, 205, 150, 50);
        ExitButton.setFocusable(false);
        
        this.add(RegistrateButton);
        this.add(LoginButton);
        this.add(ExitButton);
        
        	LoginButton.addActionListener((ActionEvent e) -> {
        	logframe = new LoginFrame();
            this.setVisible(false);
        });
    }
    
}


