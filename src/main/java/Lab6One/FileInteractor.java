package Lab6One;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInteractor {
    public static void retriever(int salary) {
        try {FileOutputStream fos = new FileOutputStream("salaries.dat", true);
            fos.write(salary);
            fos.close();
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static List<Integer> returner() {
        try {
            List<Integer> salaries = new ArrayList<>();

            FileInputStream fis = new FileInputStream("salaries.dat");
            DataInputStream dis = new DataInputStream(fis);
            while(dis.read() != -1) {
                salaries.add(dis.readInt());
            }

            dis.close();
            return salaries;
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return null;
    }
}
