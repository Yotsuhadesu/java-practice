public class Main {
    public static void main(String[] args) {
        ClassRecord classRecord = new ClassRecord();
        Input.showMenu();
        int choice;
        do {
            System.out.println();
            choice = Input.acceptInt("Select option:");
            System.out.println();
            switch (choice) {
                case 1:
                    classRecord.assignCollegeDetails();
                    classRecord.assignProgramDetails();
                    break;
                case 2:
                    classRecord.assignCourseDetails();
                    break;
                case 3:
                    classRecord.assignInstructorDetails();
                    break;
                case 4:
                    classRecord.addStudent();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Exiting system. Thank you for using UNC Class Record System!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 0);
    }
}