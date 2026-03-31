package string_manipulation;

public class MostFrequentChar {
    public static void main(String[] args) {
        String s = "banana";
        int highCount = Integer.MIN_VALUE;
        char fChar = ' ';

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char current = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == current) {
                    count++;
                }
            }

            if (count > highCount) {
                highCount = count;
                fChar = current;
            }
        }
        System.out.println(fChar);
    }
}
