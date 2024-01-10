package wssc.objects;

import java.util.*;
/**
 *
 * @author Dev
 */
public class Claim {
    
    private int claim_id, service_rep_id, customer_account_id;
    private String date, result;
    
    public Claim(int claim_id, String date, String result, int service_rep_id, int customer_account_id){
        this.claim_id = claim_id;
        this.service_rep_id = service_rep_id;
        this.customer_account_id = customer_account_id;
        this.date = date;
        this.result = result;        
    }
    
    public int get_claim_id(){
        return claim_id;
    }
    
    public int get_service_rep_id(){
        return service_rep_id;
    }
    
    public int get_customer_account_id(){
        return customer_account_id;
    }
    
    public String get_date(){
        return date;
    }
    
    public String get_result(){
        return result;
    }
}
