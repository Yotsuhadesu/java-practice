// Description: Read only the first line of a text file
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFirstLine {
    public static void main(String[] args) {
        // try with resources, scanner and file object, omit close method
        try (Scanner sc = new Scanner(new File("note.txt"))) {
            if (sc.hasNext()) {
                System.out.println(sc.nextLine());  // read the first line only
            } else {
                System.out.println("Empty file.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
