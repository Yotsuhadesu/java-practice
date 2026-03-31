package string_manipulation;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "madam";
        boolean isPalindrome = true;
        for (int front = 0; front < s.length()/2; front++) {
            int back = s.length() - front - 1;
            if (s.charAt(front) != s.charAt(back)) {
                isPalindrome = false;
            }
            if (!isPalindrome)
                break;
        }
        System.out.println(isPalindrome);
    }
}
