import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingPractice {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("notes.txt");
                Scanner sc = new Scanner(fr)
        ) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);   // print current line
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
