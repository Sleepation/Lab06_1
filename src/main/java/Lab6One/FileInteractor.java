package Lab6One;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInteractor {
    public static void retriever(int salary) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("salaries.dat", true))) {
            dos.writeInt(salary);
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static List<Integer> returner() {
        List<Integer> salaries = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(new FileInputStream("salaries.dat"))) {
            while(true) {
                salaries.add(dis.readInt());
            }
        }

        catch (EOFException e) {
            // End of file reached, normal case
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return salaries;
    }
}
