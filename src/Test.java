

import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class Test {
    static Map<String, User2> myNewMap = new HashMap<>();

    static {
        myNewMap.put("admin", new User2("admin", 24, "male"));
    }

    public static void main(String[] args) throws IOException {
        User2 user2 = new User2("Taras", 43, "male");
        User2 user3 = new User2("Ostap", 6, "male");
        Test test=new Test();
        Test.myNewMap.put(user2.name,user2);
        Test.myNewMap.put(user3.name,user3);
        test.writeInFile2();

    }
    public void writeInFile2(){
        for(Map.Entry<String,User2>entry :Test.myNewMap.entrySet()){
            Test.write2(entry.getValue());

        }
    }
    public void readFromFile() throws IOException {
        try {
            FileInputStream fi = new FileInputStream("user.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            User2 user1=(User2)oi.readObject();
            User2 user2=(User2)oi.readObject();
            System.out.println(user1);
            System.out.println(user2);
            fi.close();
            oi.close();
        }catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public static void write2(User2 user){
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

}

class User2 implements Serializable {
    private static final long serialVersionUID = 1L;
     String name;
     int age;
     String gender;

    User2() {
    }

    ;

    User2(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}