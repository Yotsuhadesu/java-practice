package refresher;

import java.util.Scanner;   // import Scanner class

public class Day3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // create Scanner object

        int choice;
        do {
            System.out.print("""
                    1. Say hello
                    2. Show a random number
                    3. Exit
                    Choice: """);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hello!");
                    break;  // the next case will execute if this was omitted
                case 2:
                    System.out.printf("%.2f\n", Math.random());
                    break;
                case 3:
                    System.out.println("Exiting the loop.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while(choice != 3);    // the loop will keep running if the choice is not 3

        scanner.close();
    }
}
