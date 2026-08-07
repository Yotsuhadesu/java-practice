import java.util.Scanner;

public class Floor {
    // encapsulated fields
    private double floorLength;
    private double floorWidth;

    // constructors
    public Floor(double floorLength, double floorWidth) {
        this.floorLength = floorLength;
        this.floorWidth = floorWidth;
    }
    public Floor() {
        this(0.0, 0.0);
    }

    // setters
     public void setFloorLength(double floorLength) {
        this.floorLength = floorLength;
    }
    public void setFloorWidth(double floorWidth) {
        this.floorWidth = floorWidth;
    }
    
    // getters
     public double getFloorLength() {
        return this.floorLength;
    }
    public double getFloorWidth() {
        return this.floorWidth;
    }

    public double computeFloorArea() {
        return (this.floorLength * this.floorWidth) * 100;
    }

    public void enterFloorDimensions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== FLOOR TILING CALCULATOR ===");
        System.out.print("Enter Floor Length (in meters): ");
        setFloorLength(scanner.nextDouble());
        System.out.print("Enter Floor Width (in meters): ");
        setFloorWidth(scanner.nextDouble());
    }
}
