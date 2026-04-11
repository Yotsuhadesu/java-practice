import java.io.*;
import java.util.Scanner;

public class Writer {
    public static void main(String[] args) {
        try (
                FileWriter fw = new FileWriter("story.txt", true);
                Scanner sc = new Scanner(System.in)
        ) {
            char ch;
            do {
                System.out.print("Enter word: ");
                String line = sc.nextLine();
                fw.write(line + "\n");
                System.out.print("Add a line? ");
                ch = sc.nextLine().charAt(0);
            } while(ch != 'n'); // will continue asking until user types n
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
