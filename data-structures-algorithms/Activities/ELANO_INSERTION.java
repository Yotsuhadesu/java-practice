import java.util.Scanner;

public class ELANO_INSERTION {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    public static void inputNumbers() {
        System.out.print("Enter number of elements: ");
        int length = sc.nextInt();
        arr = new int[length];
        for(int i = 0; i < length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }
    public static void sortNumbers(int[] arr) {
        System.out.print("""
                Choose sorting order:
                1. Ascending
                2. Descending
                Enter choice:""");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                ascendingSort(arr);
                break;
            case 2:
                descendingSort(arr);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }
    public static void ascendingSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void descendingSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void printNumbers(int[] arr) {
        System.out.println("Sorted Output:");
        for(int n : arr)
            System.out.print(n + " ");
    }
    public static void main(String[] args) {
        inputNumbers();
        System.out.println();
        sortNumbers(arr);
        System.out.println();
        printNumbers(arr);
    }
}
