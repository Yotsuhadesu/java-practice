import java.math.BigDecimal;

public class Money {
    public static void main(String[] args) {
        int n = 5;

        // construction of Big Decimal
        BigDecimal bigDecimal = new BigDecimal("10.0"); // store strings
        BigDecimal bigDecimal2 = new BigDecimal("10.0");
    
        // oprations
        System.out.println(bigDecimal.multiply(bigDecimal2));
        System.out.println(bigDecimal.multiply(BigDecimal.valueOf(n))); // .multiply() expects another BigDecimal object

        // comparing values
        if (bigDecimal.compareTo(bigDecimal2) == 0) {
            System.out.println("The two BigDecimal values are equal.");
        } else {
            System.out.println("The two BigDecimal values are not equal.");
        }

        // printing
        System.out.println(bigDecimal.toString());
    }
}
