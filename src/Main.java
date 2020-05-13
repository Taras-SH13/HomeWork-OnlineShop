import view.LoginMenu;
import dao.UserFileDAOImplVer2;

import java.io.IOException;

public class Main {

    public static void main(String[] jj) throws IOException {
        //UserFileDAOImplVer2.readFromFile();
        new LoginMenu().show();

    }
}

