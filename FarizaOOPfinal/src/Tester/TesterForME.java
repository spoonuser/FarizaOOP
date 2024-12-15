package Tester;

import java.io.IOException;

import UserSystem.Admin;
import data.DataManager;
import views.UserInterface;

public class TesterForME {

    public static void main(String[] args){
        // Создаем экземпляр DataManager
    	DataManager dataManager = new DataManager("user.txt");

        // Загружаем пользователей из файла
        dataManager.users = DataManager.loadUsers();

        // Проверяем, если список пуст, добавляем администратора
        if (dataManager.users.isEmpty()) {
            System.out.println("Данные пользователей не найдены. Список пуст.");
            dataManager.users.add(new Admin("admin", "admin", "AdminName", "AdminLastName", "001", "admin@kbtu.kz", 35));
            DataManager.saveUsers();
        } else {
            System.out.println("Данные пользователей успешно загружены:");
            for (UserSystem.User user : dataManager.users) {
                System.out.println(user.toString());
            }
        }

        // Запускаем интерфейс пользователя
        UserInterface userInterface = new UserInterface(dataManager);
        userInterface.start();
    }
}