package dao;

import model.User;
import dao.UserInMemDAO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import java.util.Set;

public class UserFileDaoImpl {

    public void userFileDaoImpl() throws IOException {
        File file = new File("C:\\Users\\M2\\Desktop\\user.txt");

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);
        for (Map.Entry<String, User> entry : UserInMemDAO.userMap.entrySet()) {
            // Запись содержимого в файл
            writer.write("Пользователь -  " + entry.getKey() + " Описание : " + entry.getValue() + System.getProperty("line.separator"));
            writer.flush();
            writer.close();

            // Создание объекта FileReader
            FileReader fr = new FileReader(file);
            char[] a = new char[200];   // Количество символов, которое будем считывать
            fr.read(a);   // Чтение содержимого в массив

            for (char c : a)
                System.out.print(c);   // Вывод символов один за другими
            fr.close();
        }
    }
}








