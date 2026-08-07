import java.util.Scanner;

public class Tile {
    // encapsulated fields
    private String brandName;
    private double tileLength;
    private double tileWidth;
    private double tileCost;
    private double totalCost;
    
    // constructors
    public Tile(String brandName, double tileLength, double tileWidth, double tileCost) {
        this.brandName = brandName;
        this.tileLength = tileLength;
        this.tileWidth = tileWidth;
        this.tileCost = tileCost;
    }

    // setters for each field for initialization or value assignment
    public void setBrand(String brandName) {
        this.brandName = brandName;
    }
    public void setTileLength(double tileLength) {
        this.tileLength = tileLength;
    }
    public void setTileWidth(double tileWidth) {
        this.tileWidth = tileWidth;
    }
    public void setTileCost(double tileCost) {
        this.tileCost = tileCost;
    }

    // getters
    public String getBrand() {
        return this.brandName;
    }
    public double getTileArea() {
        return (this.tileLength * this.tileWidth) / 100;
    }
    public double getTilesNeeded(double floorArea) {
        return floorArea / getTileArea();
    }
    public double getTotalCost(double tilesNeeded) {
        this.totalCost = this.tileCost * tilesNeeded;
        return this.totalCost;
    }
    public double getTotalCost() {
        return this.totalCost;
    }
    // misc methods
}

