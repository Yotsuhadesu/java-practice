package string_manipulation;

public class ManualUpperCase {
    public static void main(String[] args) {
        String l = "uppercase 12";
        String u = "";
        for(char c : l.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                u += (char)(c - 32);    // differences between the lowercase and uppercase letters in the ASCII table
            } else {
                u += c; // for non letter symbols
            }
        }
        System.out.println(u);
    }
}
