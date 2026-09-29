public class Tile {
    // encapsulated fields
    private String brandName;
    private double tileLength;
    private double tileWidth;
    private double tileCost;
    private int tilesNeeded;
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

    // getters that returns each field's value
    public String getBrand() {
        return this.brandName;
    }
    public double getTileArea() {
        return (this.tileLength / 100) * (this.tileWidth / 100);    // get tile area in meters
    }
    public int getTilesNeeded(double floorArea) {
        this.tilesNeeded = ((int)(floorArea / getTileArea())) + 1;  // divide the floor area to tile area in square meters, convert to int to round down, and add 1 to fill the gap
        return this.tilesNeeded;   
    }
    public double getTotalCost(double tilesNeeded) {
        this.totalCost = this.tileCost * tilesNeeded;   // assign the value to the totalCost field
        return this.totalCost;
    }
    public double getTotalCost() {
        return this.totalCost;
    }
}

