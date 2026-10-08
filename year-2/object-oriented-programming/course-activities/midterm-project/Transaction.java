import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Transaction implements Record {
    private int tranID;
    private LocalDate tranDate;
    private String cusLastName;
    private String cusFirstName;
    private String cusContactNumber;
    private String delAddress;
    private String item;
    private int itemQuantity;
    private BigDecimal itemPrice;
    private BigDecimal delFee;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String tranStatus;

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
        transactionData.add(this.cusContactNumber);
        transactionData.add(this.delAddress);
        transactionData.add(this.item);
        transactionData.add(this.itemQuantity);
        transactionData.add(this.itemPrice);
        transactionData.add(this.delFee);
        transactionData.add(this.totalAmount);
        transactionData.add(this.paymentMethod);
        transactionData.add(this.tranStatus);
        return transactionData;
    }
}
