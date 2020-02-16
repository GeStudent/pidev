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
public class Student extends user {
    
    private int idclass;

    public Student(String lastname, String firstname, String email, String birthDay, int phone, String pays, String adress, String gender) {
        super(lastname, firstname, email, birthDay, phone, pays, adress, gender);
        
    }

    

    public Student( String lastname, String firstname, String email, String birthDay, int phone, String pays, String adress, String gender ,int idclass) {
        super(lastname, firstname, email, birthDay, phone, pays, adress, gender);
        this.idclass = idclass;
    }

    @Override
    public String toString() {
        return  super.toString();
    }
    
    
}
