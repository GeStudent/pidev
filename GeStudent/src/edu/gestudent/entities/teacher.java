/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

/**
 *
 * @author Ayadi
 */
public class teacher extends user{
    private float Salary;

    public teacher(String lastname, String firstname, String email, String roles, String birthDay, int phone, String pays, String adress, String gender) {
        super(lastname, firstname, email, roles, birthDay, phone, pays, adress, gender);
    }

    public teacher(String lastname, String firstname, String email, String birthDay, int phone, String pays, String adress, String gender,float Salary ) {
        super(lastname, firstname, email, birthDay, phone, pays, adress, gender);
        this.Salary = Salary;
    }

    public float getSalary() {
        return Salary;
    }

    

    @Override
    public String toString() {
        return "teacher{"  + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email + ", birthDay=" + birthDay + ", phone=" + phone + ", pays=" + pays + ", adress=" + adress + ", gender=" + gender  + "Salary=" + Salary + '}';
         
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }
   
    
}
