package dao;

import java.io.*;

import model.User;
import model.UserRole;

import java.util.HashMap;
import java.util.Map;

public class UserFileDAOImplVer2 implements UserDAO {

    static Map<String, User> userMap2 = new HashMap<>();

    static {
        userMap2.put("admin", new User("admin", "admin", UserRole.ADMIN));
    }

    public static void writeInFile() {
        for (Map.Entry<String, User> entry : UserFileDAOImplVer2.userMap2.entrySet()) {
            UserFileDAOImplVer2.write(entry.getValue());

        }
    }


    public static void write(User user) {
        try {
            FileOutputStream outputStream = new FileOutputStream("user.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            outputStream.close();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }


    @Override
    public void save(User user) {
        userMap2.put(user.getUsername(), user);

    }

    @Override
    public void update(User user) {
        userMap2.put(user.getUsername(), user);
    }

    @Override
    public void delete(User user) {
        userMap2.remove(user.getUsername());
    }

    @Override
    public User get(String username) {
        return userMap2.get(username);
    }
}

