public class Main {
    public static void main(String[] args) {
        ClassSection classSection = new ClassSection();
        int choice;
        do {
            System.out.println();
            UserInput.showMenu();
            choice = UserInput.pickAction();
            switch (choice) {
                case 1:
                    classSection.viewClassDirectory(classSection);
                    break;
                case 2:
                    classSection.assignAdviser(classSection);
                    break;
                case 3:
                    classSection.addStudent(classSection);
                    break;
                case 4:
                    FileProcess.editStudent(classSection);
                    break;
                case 5:
                    FileProcess.saveDirectory(classSection);
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
