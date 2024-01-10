package wssc.objects;

/**
 *
 * @author Dev
 */
public class Employee {
    private String name, phone_num, sex, password;
    private int employee_id, dnum;
    
    public Employee(int id, String e_name, String phone_number, String gender,  int dnumber, String password){
        this.name = e_name;
        this.phone_num = phone_number;
        this.sex = gender;
        this.employee_id = id;
        this.dnum = dnumber;
        this.password = password;
    }
    
    public String get_name(){
        return name;
    }
    
    public String get_phone_num(){
        return phone_num;
    }
    
    public String get_sex(){
        return sex;
    }
    
    public int get_employee_id(){
        return employee_id;
    }
    
    public int get_dnum(){
        return dnum;
    }
    
    public String get_password(){
        return password;
    }
}