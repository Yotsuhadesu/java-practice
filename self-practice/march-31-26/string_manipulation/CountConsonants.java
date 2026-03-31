package string_manipulation;

public class CountConsonants {
    public static void main(String[] args) {
        String s = "programming";
        int count = 0;  // counter variable
        for (char c : s.toLowerCase().toCharArray()) {  // convert to lowercase then store characters to an array
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u')   // if not a vowel
                count++;
        }
        System.out.println(count);
    }
}
