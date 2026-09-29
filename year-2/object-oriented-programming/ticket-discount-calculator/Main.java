import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();
        Discount discount = new Discount();

        discount.askAttendeesCount(scanner);
        int attendeesCount = discount.getAttendeesCount();
        boolean hasDiscount = discount.getHasDiscount();

        int i = 1;
        char choice;
        do {
            scanner.nextLine();
            System.out.printf("--- Enter Package Option %d ---\n", i);
            System.out.print("Package Name: ");
            String packageName = scanner.nextLine();
            System.out.print("Base Price per Ticket (PHP): ");
            double pricePerTicket = scanner.nextDouble();
            System.out.print("Discount Rate (%) [applies if 10+ attendees]: ");
            double discountRate = scanner.nextDouble();

            tickets.add(new Ticket(packageName, pricePerTicket, discountRate));

            Ticket ticket = tickets.get((i - 1));
            ticket.setSubTotal(attendeesCount);
            double subTotal = ticket.getSubTotal();
            discount.setDiscountAmount(subTotal, discountRate);
            double discountAmount = (hasDiscount) ? discount.getDiscountAmount() : 0.0;
            ticket.setFinalTotal(discountAmount);
            double finalTotal = ticket.getFinalTotal();
            System.out.println("Result: ");
            System.out.printf("- Subtotal: %,.2f\n", subTotal);
            System.out.printf("- Discount: %,.2f\n", discountAmount);
            System.out.printf("- Final Total: %,.2f\n", finalTotal);

            System.out.print("Do you want to enter another package? (Y/N): ");
            choice = scanner.next().toLowerCase().charAt(0);
            i++;
        } while(choice == 'y');


        scanner.close();
    }
}
