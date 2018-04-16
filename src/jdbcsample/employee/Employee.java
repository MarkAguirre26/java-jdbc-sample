/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsample.employee;

/**
 *
 * @author AGUIRREMR
 */
public class Employee {
    private  int Id = 0;
    private  String firstName = "";
    private    String lastName = "";

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        

    public  String getFirstName() {
        return firstName;
    }

    public  String getLastName() {
        return lastName;
    }

   

    

    
    
    
}
