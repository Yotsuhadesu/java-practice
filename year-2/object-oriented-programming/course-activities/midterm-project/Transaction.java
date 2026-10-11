import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction implements Record {
    private int tranID;
    private LocalDate tranDate;
    private String cusLastName;
    private String cusFirstName;
    private String cusConNum;
    private String delAddress;
    private String item;
    private int itemQuantity;
    private BigDecimal itemPrice;
    private BigDecimal delFee;
    private BigDecimal totAmount;
    private String payMethod;
    private String tranStatus;

    public Transaction(int tranID, LocalDate tranDate, String cusLastName, String cusFirstName, String cusConNum, String delAddress, String item, int itemQuantity, BigDecimal itemPrice, BigDecimal delFee, BigDecimal totAmount, String payMethod, String tranStatus) {
        this.tranID = tranID;
        this.tranDate = tranDate;
        this.cusLastName = cusLastName;
        this.cusFirstName = cusFirstName;
        this.cusConNum = cusConNum;
        this.delAddress = delAddress;
        this.item = item;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.delFee = delFee;
        this.totAmount = totAmount;
        this.payMethod = payMethod;
        this.tranStatus = tranStatus;
    }
    public Transaction() {
        
    }
    
    @Override 
    public int getRecordID() {
        return this.tranID;
    }
    @Override 
    public ArrayList<Object> getRecordData() {
        ArrayList<Object> transactionData = new ArrayList<>();
        transactionData.add(this.tranID);
        transactionData.add(this.tranDate);
        transactionData.add(this.cusLastName);
        transactionData.add(this.cusFirstName);
        transactionData.add(this.cusConNum);
        transactionData.add(this.delAddress);
        transactionData.add(this.item);
        transactionData.add(this.itemQuantity);
        transactionData.add(this.itemPrice);
        transactionData.add(this.delFee);
        transactionData.add(this.totAmount);
        transactionData.add(this.payMethod);
        transactionData.add(this.tranStatus);
        return transactionData;
    }
    
    public void setTranID(int tranID) {
        this.tranID = tranID;
    }
    public void setTranDate(LocalDate tranDate) {
        this.tranDate = tranDate;
    }
    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }
    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }
    public void setCusConNum(String cusConNum) {
        this.cusConNum = cusConNum;
    }
    public void setDelAddress(String delAddress) {
        this.delAddress = delAddress;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
    public void setDelFee(BigDecimal delFee) {
        this.delFee = delFee;
    }
    public void setTotAmount(BigDecimal totAmount) {
        this.totAmount = totAmount;
    }
     public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }
   

    public int getTranID() {
        return this.tranID;
    }
    public LocalDate getTranDate() {
        return this.tranDate;
    }
    public String getCusLastName() {
        return this.cusLastName;
    }
    public String getCusFirstName() {
        return this.cusFirstName;
    }
    public String getCusConNum() {
        return this.cusConNum;
    }
    public String getDelAddress() {
        return this.delAddress;
    }
    public String getItem() {
        return this.item;
    }
    public int getItemQuantity() {
        return this.itemQuantity;
    }
    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }
    public BigDecimal getDelFee() {
        return this.delFee;
    }
    public void compTotAmount() {
        this.totAmount = this.itemPrice.multiply(new BigDecimal(String.valueOf(this.itemQuantity))).add(this.delFee);
    }
     public BigDecimal getTotAmount() {
        return this.totAmount;
    }
    public String getPayMethod() {
        return this.payMethod;
    }
    public String getTranStatus() {
        return this.tranStatus;
    }
}