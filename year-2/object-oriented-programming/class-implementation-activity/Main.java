import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Floor floor = new Floor();
        ArrayList<Tile> tiles = new ArrayList<>();

        floor.enterFloorDimensions();
        double floorArea = floor.computeFloorArea();
        char choice;
        int i = 0;  // counter variable
        do {
            System.out.println("--- Enter Tile Option " + (i + 1) + " ---");
            System.out.print("Tile Brand/Name: ");
            String tileBrand = scanner.nextLine();
            System.out.print("Tile Length (in cm): ");
            double tileLength = scanner.nextDouble();
            System.out.print("Tile Width (in cm): ");
            double tileWidth = scanner.nextDouble();
            System.out.print("Cost per Tile (in PHP): ");
            double tileCost = scanner.nextDouble();

            tiles.add(new Tile(tileBrand, tileLength, tileWidth, tileCost));

            int tilesNeeded = (int) (tiles.get(i).getTilesNeeded(floorArea) + 0.5);
            double totalCost = tiles.get(i).getTotalCost(tilesNeeded);
            
            System.out.println("Result:");
            System.out.println("- Tiles Needed: " + tilesNeeded + " tiles");
            System.out.printf("- Total Cost: P%.2f\n", totalCost);

            System.out.print("Do you want to enter another tile option? (Y/N): ");
            choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
            i++;
        } while(choice == 'Y');

        int highIndex = 0;
        for (int j = 1; j < tiles.size(); j++) {
            if (tiles.get(j).getTotalCost() > tiles.get(highIndex).getTotalCost()) {
                highIndex = j;
            }
        }
        String highBrand = tiles.get(highIndex).getBrand();
        double highCost = tiles.get(highIndex).getTotalCost();
        int lowIndex = 0;
         for (int j = 1; j < tiles.size(); j++) {
            if (tiles.get(j).getTotalCost() < tiles.get(lowIndex).getTotalCost()) {
                lowIndex = j;
            }
        }
        String lowBrand = tiles.get(lowIndex).getBrand();
        double lowCost = tiles.get(lowIndex).getTotalCost();

        System.out.println("=".repeat(10) + " SUMMARY " + "=".repeat(10));
        System.out.println("Highest Budget Needed:");
        System.out.printf("- Brand: %s (P%.2f)", highBrand, highCost);
        System.out.println("Lowest Budget Needed:");
        System.out.printf("- Brand: %s (P%.2f)", lowBrand, lowCost);
        System.out.println("=".repeat(25));

        scanner.close();
    }
}
