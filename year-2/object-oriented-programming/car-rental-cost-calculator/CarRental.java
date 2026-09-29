public class CarRental {
    // fields
    private int driveDistance;
    private String companyName;
    private double rentalPrice;
    private int includedDistance;
    private double excessRate;
    public int excessDistance;
    public double excessCharge;
    public double totalCost;


    // constructor
    public CarRental(int driveDistance, String companyName, double rentalPrice, int includedDistance, double excessRate) {
        this.driveDistance = driveDistance;
        this.companyName = companyName;
        this.rentalPrice = rentalPrice;
        this.includedDistance = includedDistance;
        this.excessRate = excessRate;
    }
    public CarRental() {
        this(0, null, 0.0, 0, 0.0);
    }

    // setters
    public void setDriveDistance(int driveDistance) {
        this.driveDistance = driveDistance;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public void setIncludedDistance(int includedDistance) {
        this.includedDistance = includedDistance;
    }
    public void setExcessRate(double excessRate) {
        this.excessRate = excessRate;
    }
    public void setExcessDistance() {
        this.excessDistance = (this.includedDistance < this.driveDistance) ? this.driveDistance - this.includedDistance : 0;
    }
    public void setExcessCharge() {
        this.excessCharge = this.excessDistance * this.excessRate;
    }
    public void setTotalCost() {
        this.totalCost = this.rentalPrice + this.excessCharge;
    }

    // getters
    public int getDriveDistance() {
        return this.driveDistance;
    }
    public String getCompanyname() {
        return this.companyName;
    }
    public double getRentalPrice() {
        return this.rentalPrice;
    }
    public int getIncludedDistance() {
        return this.includedDistance;
    }
    public double getExcessRate() {
        return this.excessRate;
    }
    public int getExcessDistance() {
        return this.excessDistance;
    }
    public double getExcessCharge() {
        return this.excessCharge;
    }
    public double getTotalCost() {
        return this.totalCost;
    }
}
