import model.Gender;
import model.User;
import model.UserRole;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test3 {
    static Map<String, User3> userMap3 = new HashMap<>();
    static {
        userMap3.put("Taras",new User3("Taras","23"));
        userMap3.put("Ivan",new User3("Taras","28"));
        try {
            FileOutputStream outputStream = new FileOutputStream("user3.txt", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(userMap3.get("Taras"));
            objectOutputStream.writeObject(userMap3.get("Ivan"));
            outputStream.close();
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    static Map<String, User3> userMap4 = new HashMap<>();
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("user3.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        while (true) {

            try {
                Test3.userMap4.put(((User3) oin.readObject()).getUsername(), (User3) oin.readObject());
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }



    }

}

class User3 implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int age;

    public User3(String username, String password) {
        this.username = username;
        this.password = password;

    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }





    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +


                ", age=" + age +
                '}';
    }

}