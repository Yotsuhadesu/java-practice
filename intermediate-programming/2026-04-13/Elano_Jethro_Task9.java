import java.io.*;
import java.util.Scanner;

public class Elano_Jethro_Task9 {
    static File file = new File("data.txt");
    public static boolean validateAccountNo(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        boolean isValid = sections.length == 3;   // if the entered account number doesn't have three sections

        for (String section : sections) {
            for (int j = 0; j < section.length(); j++) {
                if (!Character.isDigit(section.charAt(j)))  // if the characters aren't digit
                    isValid = false;
            }
        }
        if (isValid) {  // length per section validation
            if (sections[0].length() != 3)
                isValid = false;
            if (sections[1].length() != 2)
                isValid = false;
            if (sections[2].length() != 4)
                isValid = false;
        }
        return isValid;
    }
    public static String getZone(String accountNo) {
        String[] sections = accountNo.split("-");
        return sections[0]; // return first section
    }
    public static String getClassification(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        char firstDigit = sections[1].charAt(0);    // get second section, first digit
        System.out.print("Classification: ");
        if (firstDigit == '1') {
            return "Residential";
        }
        else if (firstDigit == '2') {
            return "Commercial";
        }
        else if (firstDigit == '3') {
            return "Industrial";
        }
        else if (firstDigit == '4') {
            return "Government";
        } else {
            return "Unclassified";
        }
    }
    public static String getPipeSize(String accountNo) {
        String[] sections = accountNo.split("-");
        char secondDigit = sections[1].charAt(1);
        String pipeSize = "";
        switch (secondDigit) {
            case '1' -> pipeSize += "1/2";
            case '2' -> pipeSize += "3/4";
            case '3' -> pipeSize += "1";
            case '4' -> pipeSize += "2";
            default -> pipeSize += "Unknown";
        }
        return pipeSize;
    }
    public static void createFile(boolean exists) {
        if(!exists) {
            try {
                file.createNewFile();
                System.out.println("File created.");
            } catch (IOException e) {
                System.out.println("Cannot create the file.");
            }
        }
    }
    public static void main(String[] args) {
        createFile(file.exists());
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(n != 5) {
            System.out.println("""
                    Menu:
                    1. Add Account Record
                    2. View All Records
                    3. View File Information
                    4. Delete File
                    5. Exit""");
            System.out.print("Choice: ");
            n = sc.nextInt();
            sc.nextLine();

            switch(n) {
                case 1:
                    // get credentials
                    boolean isValid;
                    String accountNumber;
                    do {
                        System.out.print("Enter Account Number: ");
                        accountNumber = sc.nextLine();
                        isValid = validateAccountNo(accountNumber); // assign validator flag
                        if(!isValid)
                            System.out.println("Invalid account number. Please try again.");
                    } while(!isValid);
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    // save the credentials to the text file
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                        bw.write("----- ACCOUNT INFORMATION -----" + "\n");
                        bw.write("Name: " + name+ "\n");
                        bw.write("Address: " + address+ "\n");
                        bw.write("Account Number: " + accountNumber+ "\n");
                        bw.write("Zone: " + getZone(accountNumber)+ "\n");
                        bw.write("Classification: " + getClassification(accountNumber) + "\n");
                        bw.write("Pipe Size: " + getPipeSize(accountNumber) + "\n");
                    } catch (IOException e) {
                        System.out.println("Error saving the data.");
                    }
                    break;
                case 2:
                    // read the text file
                    if(file.exists()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.out.println("Cannot read the file");
                        }
                    } else {
                        System.out.println("Cannot locate the file.");
                    }
                    break;
                case 3:
                        System.out.println("----- FILE INFORMATION -----");
                        System.out.println("File Name: " + file.getName());
                        System.out.println("File Path: " + file.getAbsolutePath());
                        System.out.println("File Size: " + file.length());
                        System.out.println("Readable: " + file.canRead());
                        System.out.println("Writable: " + file.canWrite());
                    break;
                case 4:
                    System.out.print("Delete file " + file.getName() + " (y/n): ");
                    char confirm = sc.next().toLowerCase().charAt(0);
                    if(confirm == 'y') {
                        if(file.exists()) {
                            file.delete();
                            System.out.println("File deleted.");
                        } else {
                            System.out.println("Cannot locate the file.");
                        }
                    } else {
                        System.out.println("File not deleted.");
                    }
                    break;
                default:
                    System.out.println("Exiting the program.");
                    break;
            }
        }
        sc.close();
    }
}
