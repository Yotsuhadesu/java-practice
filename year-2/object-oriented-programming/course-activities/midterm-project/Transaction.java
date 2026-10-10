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

    public int getTranID() {
        return this.tranID;
    }

    public void setTranID(int tranID) {
        this.tranID = tranID;
    }

    public LocalDate getTranDate() {
        return this.tranDate;
    }

    public void setTranDate(LocalDate tranDate) {
        this.tranDate = tranDate;
    }

    public String getCusLastName() {
        return this.cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public String getCusFirstName() {
        return this.cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusConNum() {
        return this.cusConNum;
    }

    public void setCusConNum(String cusConNum) {
        this.cusConNum = cusConNum;
    }

    public String getDelAddress() {
        return this.delAddress;
    }

    public void setDelAddress(String delAddress) {
        this.delAddress = delAddress;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getItemQuantity() {
        return this.itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getDelFee() {
        return this.delFee;
    }

    public void setDelFee(BigDecimal delFee) {
        this.delFee = delFee;
    }

    public void compTotAmount() {
        this.totAmount = this.itemPrice.multiply(new BigDecimal(String.valueOf(this.itemQuantity))).add(this.delFee);
    }

    public BigDecimal getTotAmount() {
        return this.totAmount;
    }

    public void setTotAmount(BigDecimal totAmount) {
        this.totAmount = totAmount;
    }

    public String getpayMethod() {
        return this.payMethod;
    }

    public void setpayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getTranStatus() {
        return this.tranStatus;
    }

    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }
    private String tranStatus;

}
