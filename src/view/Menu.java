package view;

import dao.UserFileDAOImplVer2;

import java.io.IOException;
import java.util.Scanner;

public interface Menu {
    void show() throws IOException;
    void back() throws IOException;

    default void exitProgram() {
        UserFileDAOImplVer2.writeInFile();
        System.exit(0);
    }

    default double getDoubleInput(String request, Scanner s) {
        System.out.println(request);
        try {
            String age = s.nextLine();
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return getDoubleInput(request, s);
        }
    }
}
