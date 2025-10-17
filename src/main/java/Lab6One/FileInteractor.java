package Lab6One;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileInteractor {
    public void retrieve(int salary) {
        try {FileOutputStream fos = new FileOutputStream("salaries.dat", true);
            fos.write(salary);
            fos.close();
        }

        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
