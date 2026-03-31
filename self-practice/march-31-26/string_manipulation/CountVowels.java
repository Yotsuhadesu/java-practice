package string_manipulation;

public class CountVowels {
    public static void main(String[] args) {
        String s = "programming";
        int count = 0;  // counter variable
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;
        }
        System.out.println(count);
    }
}
