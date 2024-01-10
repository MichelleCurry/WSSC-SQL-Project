/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wssc.objects;

/**
 *
 * @author Dev
 */
public class Property {
    
    private String address, property_type;
    private int water_meter, utility_worker_id, account_id;
    
    public Property(String address, String property_type, int water_meter, int utility_worker_id, int account_id){
        this.address = address;
        this.property_type = property_type;
        this.water_meter = water_meter;
        this.utility_worker_id = utility_worker_id;
        this.account_id = account_id;
    }
    
    public String get_address(){
        return address;
    }
    
    public String get_property_type(){
        return property_type;
    }
    
    public int get_water_meter(){
        return water_meter;
    }
    
    public int get_utility_worker_id(){
        return utility_worker_id;
    }
    
    public int get_account_id(){
        return account_id;
    }
}
