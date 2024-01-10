/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wssc.objects;

/**
 *
 * @author Dev
 */
public class Permits {
    
    private int permit_num, permit_officer_id;
    private String date_issued, date_expiring, address;
    
    public Permits(int permit_num, int permit_officer_id, String date_issued, String date_expiring, String address){
        this.permit_num = permit_num;
        this.permit_officer_id = permit_officer_id;
        this.date_issued = date_issued;
        this.date_expiring = date_expiring;
        this.address = address;        
    }
    
    public int get_permit_num(){
        return permit_num;
    }
    
    public int get_permit_officer_id(){
        return permit_officer_id;
    }
    
    public String get_date_issued(){
        return date_issued;
    }
    
    public String get_date_expiring(){
        return date_expiring;
    }
    
    public String get_address(){
        return address;
    }
}
