package Lab6One;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInteractor {
    public static void retriever(int salary) {
        try {
            FileOutputStream fos = new FileOutputStream("salaries.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.flush();
            dos.writeInt(salary);
            dos.close();
            fos.close();
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static List<Integer> returner(int numberOfSalaries) {
        try {
            List<Integer> salaries = new ArrayList<>();

            FileInputStream fis = new FileInputStream("salaries.dat");
            DataInputStream dis = new DataInputStream(fis);


            for(int i = 0; i < numberOfSalaries; i++){
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
