/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.entities.teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayadi
 */
public class ServicesTeacher extends ServicesUsers {

    public ServicesTeacher() {
        super();
    }
    


    public void ajouterTeacher(teacher t) {
  PreparedStatement pre;
        try {
            super.ajouter(t);
            pre = con.prepareStatement("update user set roles='teacher' , salary=? where idcode= ?");
            pre.setDouble(1,t.getSalary());
            pre.setString(2, super.getQRcode(t.getEmail()));
            pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }
 public List<teacher> readAllTeachers() {

        List<teacher> lu = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select firstname,lastname,email,birthDay,phone,pays,adress,gender,salary from user where roles='teacher'");
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String birthDay = rs.getString("birthDay");
                int phone = rs.getInt("phone");
                String pays = rs.getString("pays");
                String adress = rs.getString("adress");
                String gender = rs.getString("gender");
                float salary = rs.getFloat("salary");
                teacher t = new teacher(lastname,firstname,email, birthDay, phone, pays, adress, gender,salary);
                lu.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lu;
    }
 public List<teacher> readAllTeachersSortedBySalary() {

        List<teacher> lu = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select firstname,lastname,email,birthDay,phone,pays,adress,gender,salary from user where roles='teacher' order by salary ");
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String birthDay = rs.getString("birthDay");
                int phone = rs.getInt("phone");
                String pays = rs.getString("pays");
                String adress = rs.getString("adress");
                String gender = rs.getString("gender");
                float salary = rs.getFloat("salary");
                teacher t = new teacher(lastname,firstname,email, birthDay, phone, pays, adress, gender,salary);
                lu.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lu;
    }
    
    
    
}
