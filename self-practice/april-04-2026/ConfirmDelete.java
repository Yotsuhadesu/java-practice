// Description: Deletes a text file if it exists.
import java.io.File;

public class ConfirmDelete {
    public static void main(String[] args) {
        File file = new File("delete_me.txt");  // create file object
        if (file.exists()) {    // file existence verifier
            if (file.delete()) {    // file deletion output handler
                System.out.println("File deleted successfully");
            } else {
                System.out.println("File not deleted");
            }
        } else {
            System.out.println("File not found");
        }
    }
}
