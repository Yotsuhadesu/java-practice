import java.util.Scanner;
public class Input {
    public static Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("""
                --- MENU ---
                1. Place Order
                2. View Orders
                3. Update Order Status
                0. Exit\s""");
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
        return string.trim();
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

    public static double acceptDouble(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextDouble()) {
            System.out.print(prompt + " ");
            scanner.next();
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }

    public static boolean acceptBoolean(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextBoolean()) {
            System.out.print(prompt + " ");
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        scanner.nextLine();
        return bool;
    }
}
