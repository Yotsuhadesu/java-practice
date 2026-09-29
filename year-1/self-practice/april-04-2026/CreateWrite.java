// Description: Create a file and write a statement on it.
import java.io.FileWriter;
import java.io.IOException;

public class CreateWrite {
    public static void main(String[] args) {
        // try with resources: writer and file object, omit close method
        try (FileWriter writer = new FileWriter("hello.txt")) {
            writer.write("Hello World");
            System.out.println("File created and written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
