/*
    Description: A program that counts the line, words, and characters inside a file.
*/
import java.io.*;
import java.util.Scanner;

public class CountLWC {
    public static void main(String[] args) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try(
                FileReader fr = new FileReader("story.txt");
                Scanner sc = new Scanner(fr);
        ) {
            while(sc.hasNextLine()) {
                lineCount++;    // update line count
                String line = sc.nextLine();    // store the current line
                String[] words = line.split(" ");  // split by spaces
                wordCount += words.length;  // count array elements
                charCount += line.length(); // count characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}
