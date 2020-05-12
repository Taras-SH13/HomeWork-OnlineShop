package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.User;
import model.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserFileDAOImplVer2 implements UserDAO {

    static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("admin", new User("admin", "admin", UserRole.ADMIN));
    }

    public void write(User user) {
        try {
            FileOutputStream outputStream = new FileOutputStream("user.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }


    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User get(String username) {
        return null;
    }
}

