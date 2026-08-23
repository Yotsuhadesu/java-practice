public class Main {
    public static void main(String[] args) {
        ClassSection classSection = new ClassSection();
        int choice;
        do {
            UserInput.showMenu();
            choice = UserInput.pickAction();
            switch (choice) {
                case 1:
                    classSection.viewClassDirectory(classSection);
                    break;
                case 2:
                    // update/assign an adviser
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    FileProcess.loadDirectory(classSection);
                    break;
                case 7:
                    System.out.println("Exiting Program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 7);
    }
}
