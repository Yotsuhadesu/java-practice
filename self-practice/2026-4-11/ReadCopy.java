import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadCopy {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("notes.txt");
                Scanner sc = new Scanner(fr);
                FileWriter fw = new FileWriter("numbered.txt")
        ) {
            int lineCount = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();    // read current line
                fw.write(lineCount + ". " + line + "\n");   // copy current line with line number
                lineCount++;    // update line count
            }
        } catch (IOException e) {
            System.out.println("Error copying the file.");
            e.printStackTrace();
        }
    }
}
