/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wssc.objects;

/**
 *
 * @author Dev
 */
public class Account {
    private int user_id, credit_card;
    private String owner;
    
    public Account(int user_id, int credit_card_no, String owner){
        this.user_id = user_id;
        this.credit_card = credit_card_no;
        this.owner = owner;
    }
    
    public Account(int user_id, int credit_card_no){
        this.user_id = user_id;
        this.credit_card = credit_card_no;
    }
    
    public int get_user_id(){
        return user_id;
    }
    
    public int get_credit_card(){
        return credit_card;
    }
    
    public String get_owner(){
        return owner;
    }
}
