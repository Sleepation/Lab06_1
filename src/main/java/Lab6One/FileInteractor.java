/**
 * Santiago A. Bejarano P., 2430065
 */

package Lab6One;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInteractor {

    /**
     * This method will retrieve a given integer number from the program.
     * A data output stream is initialled, with a file output stream being able to append being passed to its constructor.
     * The value is transformed to binary by the data output stream; the file output stream saves it to the file.
     * The method might throw an IOException, handled from within.
     * @param salary
     */
    public static void retriever(int salary) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("salaries.dat", true))) {
            dos.writeInt(salary);
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * This method will return an array list containing all the salaries.
     * A data input stream is initialized with a file input stream in its constructor.
     * The data input stream will read each int value from the dat file through the file input stream.
     * Each value is added to the array list.
     * The process stops one an EOF exception is reached, stopping ultimately the loop when no more data is available.
     * The list is returned. All IO exceptions are handled within.
     * @return
     */
    public static List<Integer> returner() {
        List<Integer> salaries = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(new FileInputStream("salaries.dat"))) {
            while(true) {
                salaries.add(dis.readInt());
            }
        }

        catch (EOFException e) {
            // End of file reached, stop loop
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return salaries;
    }
}
