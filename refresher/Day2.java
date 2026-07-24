package refresher;

/*
    * Day 2 of gaining my Java programming skills.
    * Topics: 8 primitive types, pre-increment and post-increment, widening and narrowing, mixed expression, variable types
 */

public class Day2 {
    public static void main(String[] args) {
        /*
            Variable Types:
            1. Instance Variable - a separate variable created for each object
            2. Static Variable - belongs to the class
            3. Local Variable - belongs to the code/method block
            Widening - turning a smaller datatype to a bigger one (ex. short to int)
            Narrowing - turning a bigger datatype to a smaller one (ex. double to float)
         */
        System.out.println("The eight primitive variables: ");
        byte by = 124;
        System.out.println("1. Byte: " + by);
        short sh = 10000;
        System.out.println("2. Short: " + sh);
        int in = 1;
        System.out.println("3. Int: " + in);
        long lo = 10000000000L; // long needs L in the end
        System.out.println("4. Long: " + lo);
        float fl = 1.1f;    // float needs f in the end
        System.out.println("5. Float: " + fl);
        double db = 3.33;
        System.out.println("6. Double: " + db);
        int narrowed = (int) db;
        System.out.println("Narrowed Double: " + narrowed);
        char ch = 'a';
        System.out.println("7. Char: " + ch);
        boolean bo = false;
        System.out.println("8. Boolean: " + bo);

        System.out.println("Mixed Expression:");
        int a = 2;
        int b = 5;
        int c = 3;
        boolean result = a + c == b && b > c;
        // Predicted result: true
        System.out.println("Result: " + result);

        System.out.println("increment and final");
        /*
            final int x = 5;
            x++;
            System.out.println(x++);
            This won't compile because a variable with the final keyword cannot be changed.
         */
        // Corrected version
        int x = 5;
        x++;
        System.out.println(x++);
    }
}
