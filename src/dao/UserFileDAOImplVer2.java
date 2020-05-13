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
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    public static void write(User user) {
        try {
            FileOutputStream outputStream = new FileOutputStream("user.txt", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            outputStream.close();
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public static void readFromFile() throws IOException {
        FileInputStream fis = new FileInputStream("user.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        while (true) {

            try {
                UserFileDAOImplVer2.userMap2.put(((User) oin.readObject()).getUsername(), (User) oin.readObject());
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }

        fis.close();
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

