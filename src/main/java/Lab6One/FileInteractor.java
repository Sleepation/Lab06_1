/**
 * Santiago A. Bejarano P., 2430065
 * Thomas A., 2430853
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
        try {
            FileOutputStream fos = new FileOutputStream("salaries.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(salary);
            dos.close();
            fos.close();
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
     * The process is stopped by an EOF exception.
     * The list is returned. All IO exceptions are handled within.
     * @param numberOfSalaries
     * @return
     */
    public static List<Integer> returner(int numberOfSalaries) {
        List<Integer> salaries = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("salaries.dat"))){

            while(true) {
                salaries.add(dis.readInt());
            }

        } catch (EOFException e) {
            // End of file reached, normal case
            return salaries;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return null;
    }
}
