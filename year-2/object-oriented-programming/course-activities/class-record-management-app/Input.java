import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("=".repeat(50));
        System.out.println("\tUNIVERSITY OF NUEVA CACERES");
        System.out.println("\tClass Record Management System");
        System.out.println();
        System.out.println("=== MAIN MENU ===");
        System.out.println("""
                
                """;);
    }

    public static String acceptString(String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = scanner.nextLine();
            if (input == null || input.isBlank()) {
                scanner.next();
            } else {
                break;
            }
        } while(scanner.hasNext());

        return input;
    }

    public static int acceptInt(String prompt) {
        do {
            System.out.print(prompt + " ");
        } while (!scanner.hasNextInt());
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
