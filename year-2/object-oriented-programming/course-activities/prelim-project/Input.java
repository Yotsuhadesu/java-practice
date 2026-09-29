import java.util.Scanner;
public class Input {
    public static Scanner scanner = new Scanner(System.in);
    public static void menu(int choice) {
        switch (choice) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }

    public static String acceptString(String prompt) {
        String string;
        do {
            System.out.print(prompt + " ");
            string = scanner.nextLine();
            if (string != null && !string.isBlank()) {
                break;
            }
        } while(true);
        return string;
    }

    public static int acceptInt(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.print(prompt + " ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
