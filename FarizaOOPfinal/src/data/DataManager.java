package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import UserSystem.User;

/*
ДЛЯ КОМАНДЫ
Работа с данными пользавателей (сохранение - загрузка в файл(сер/десер))
*/
public class DataManager {
	
	private static final String FILE_PATH = "/Users/fariza/eclipse-workspace/FarizaOOPfinal/src/data/user.txt";
	
	public static List<User> users; 
	
	public DataManager(String string) {
		this.users = new ArrayList<>();
	}
	//сохраняет данные в файл
	public static void saveUsers() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
			oos.writeObject(users);
			System.out.println("Данные успешно добавлены");
		}
		catch (IOException e){
			System.out.println("Возникла Ошибка");
		}
	}
	
	//загружает данные из файла
	public static List<User> loadUsers() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
			return (List<User>) ois.readObject(); 
		}
		catch(FileNotFoundException e){
			System.out.println("Файл не найден. Создается новый пустой список");
			return new ArrayList<>();
		}
		catch(IOException | ClassNotFoundException e) {
			System.out.println("Ошибка при загрузки данных. Создается новый пустой список");
			return new ArrayList<>();
		}	
	}
	// проверка логин/пароля для входа в систему 
	public User authenticate(String login , String password) {
		for(User user : users) {
			if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
}
