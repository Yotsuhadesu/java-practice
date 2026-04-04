// Description: Count the number of words inside a text file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File("hello.txt"))) { // Scanner object
            int wordCount = 0;
            while (reader.hasNext()) {  // if there is a next word
                wordCount++;    // counter increment
                reader.next();  // update reader object
            }
            System.out.println(wordCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
