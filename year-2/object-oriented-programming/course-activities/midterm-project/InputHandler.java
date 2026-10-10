import java.math.BigDecimal;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("""
                [1] ADD NEW TRANSACTION RECORD
                [2] UPDATE TRANSACTION RECORD
                [3] DELETE TRANSACTION RECORD
                [4] VIEW TRANSACTION RECORD
                [5] VIEW TRANSACTION LIST
                [6] EXIT APPLICATION""");
    }

    public static String acceptString(String prompt) {
        String str;
        do {
            System.out.print(prompt + ": ");
            str = scanner.nextLine();

            if (str != null && !str.isBlank()) {
                break;
            } else {
                System.out.println(">> Please enter a valid input.");
            }
        } while (true);
        return str;
    }

    public static int acceptInt(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println(">> Please enter a valid number.");
            System.out.print(prompt + ": ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return  num;
    }

    public static BigDecimal acceptBigDecimal(String prompt) {
        BigDecimal bDecimal = null;

        while (bDecimal == null) {
            System.out.print(prompt + ": ");

            if (scanner.hasNextBigDecimal()) {
                bDecimal = scanner.nextBigDecimal();
            } else {
                System.out.println(">> Please enter a valid amount.");
                scanner.next();
            }
        }

        return  bDecimal;
    }
}
