package string_manipulation;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "programming";
        String trim = "";
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            boolean isFound = false;

            for (int j = 0; j < trim.length(); j++) {
                if (trim.charAt(j) == current) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound)
                trim += current;
        }
        System.out.println(trim);
    }
}
