package refresher;

/**
 * This is a refresher java program.
 */

public class Day1 {
    /*
    This a method that prints
    concatenated strings in-console.
     */
    public static void introduction(String name, int age) {
        System.out.printf("Hello, this is %s!\n", name);
        System.out.printf("I am %d years old.\n", age);
    }
    public static void main(String[] args) {
        String name = "Jethro";
        String date = "July 23, 2026";
        int age = 19;
        introduction(name, age);    // call the introduction method
        System.out.println("It is " + date + " today.");
    }
}

class Time {
}

