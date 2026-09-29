// Description: Copy the contents of a source text file to a duplicate text file
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        try (
            Scanner reader = new Scanner(new File("source.txt"));   // Scanner object
            FileWriter writer = new FileWriter("copy.txt")  // FileWriter object
        ) {
            while (reader.hasNextLine()) {  // if there is still a text content next line
                writer.write(reader.nextLine() + "\n");    // print the next line
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
