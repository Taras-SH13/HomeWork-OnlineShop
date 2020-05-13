import dao.UserFileDAOImplVer2;
import model.User;

import java.io.*;
import java.util.ArrayList;

public class Test2 {
    public Test2() throws IOException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point("First point", 1, 2, 3));
        points.add(new Point("Second point", 2, 3, 4));
        points.add(new Point("Third point", -5, 10, 16));

        for (Point point : points) {
            oos.writeObject(point);
        }

        oos.flush();
        oos.close();

        ArrayList<Point> points2 = new ArrayList<>();
        FileInputStream fis = new FileInputStream("temp.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);

        while (true) {
            try {
                points2.add((Point) oin.readObject());
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }

        fis.close();
        for (Point point2 : points) {
            System.out.println(point2.getName());
        }

    }


}
class Point implements Serializable{


    private String mName;
    private int mX;
    private int mY;
    private int mZ;

    public Point(String name, int x, int y, int z) {
        mName = name;
        mX = x;
        mY = y;
        mZ = z;
    }

    public String getName() {
        return mName;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public int getZ() {
        return mZ;
    }


}