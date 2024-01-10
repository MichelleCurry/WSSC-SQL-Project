package wssc.objects;

/**
 *
 * @author Deven
 */
public class Transaction {
    
    private int transaction_id, bill_no, account_id;
    private double amount_paid;
    private String date_paid;
    
    public Transaction(int transaction_id, int bill_no, int account_id, double amount_paid, String date_paid){
        this.transaction_id = transaction_id;
        this.bill_no = bill_no;
        this.account_id = account_id;
        this.amount_paid = amount_paid;
        this.date_paid = date_paid;
    }
    
    public int get_transaction_id(){
        return transaction_id;
    }
    
    public int get_bill_no(){
        return bill_no;
    }
    
    public int get_account_id(){
        return account_id;
    }
    
    public double get_amount_paid(){
        return amount_paid;
    }
    
    public String get_date_paid(){
        return date_paid;
    }
}
