package string_manipulation;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "msmsmo".toLowerCase();
        int count;  // occurrence counter variable
        char nRep = ' ';
        for (char c : s.toCharArray()) {  // convert to lowercase then store characters to an array
            count = 0;  // reset
            for (char c1 : s.toLowerCase().toCharArray()) {
                if (c == c1)
                    count++;
            }
            if (count == 1) {
                nRep = c;
                break;
            }
        }
        System.out.println(nRep);
    }
}
