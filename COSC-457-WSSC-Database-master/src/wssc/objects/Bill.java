/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wssc.objects;

/**
 *
 * @author Dev
 */
public class Bill {
    
    private int bill_no, specialist_id, account_id;
    private double amount_owed;
    private String date;
    
    public Bill(int bill_no, int specialist_id, int account_id, double amount_owed, String date){
        this.bill_no = bill_no;
        this.specialist_id = specialist_id;
        this.account_id = account_id;
        this.amount_owed = amount_owed;
        this.date = date;        
    }
    
    public int get_bill_no(){
        return bill_no;
    }
    
    public int get_specialist_id(){
        return specialist_id;
    }
    
    public int get_account_id(){
        return account_id;
    }
    
    public double get_amount_owed(){
        return amount_owed;
    }
    
    public String get_date(){
        return date;
    }
    
}
