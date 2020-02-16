/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.entities.Behaviour;
import edu.gestudent.entities.exams;
import edu.gestudent.utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class examsCRUD {
    Connection con;
     Statement ste;

    public examsCRUD() {
            con = DataBase.getInstance().getConnection();
    }
    public void ajoutex(exams e){
           String requete2= "INSERT INTO exams (nomex,dateex,duree)VALUES (?,?,?)";
         
        try {
             PreparedStatement pst = con.prepareStatement(requete2);
//            pre = con.prepareStatement("INSERT INTO behaviour (attendance,award)VALUES (?,?)");
            pst.setString(1, e.getNomex());
            pst.setDate(2, e.getDateex());
            pst.setInt(3, e.getDuree());
              pst.executeUpdate();
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
           
    }
      public boolean updateex(int idexa, Date dateex) throws SQLException {

        try {
            PreparedStatement pre = con.prepareStatement("update exams set dateex =? where idexa=? ;");
            pre.setDate(1, dateex);
              pre.setInt(2, idexa);
            if (pre.executeUpdate() != 0) {
                System.out.println("exam date is updated");
                return true;
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("id exam not found!!!");
            return false;
       

    }
      public boolean delete(int idexa) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from exams where idexa=? ;");
try{
        pre.setInt(1, idexa);
        if (pre.executeUpdate() != 0) {
            System.out.println("exam Deleted");
            return true;
        }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id exam not found!!!");
        return false;

    }
     public List<exams> afficherex(){
        ArrayList<exams> per =new ArrayList();

        try {
                    String requete3 = "SELECT * FROM exams";
            PreparedStatement pst2 = con.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();
            
            while(rs.next()){
              exams e = new exams();
              e.setIdexa(rs.getInt("idexa"));
              e.setNomex(rs.getString("1"));
              e.setDateex(rs.getDate("2"));
               e.setDuree(rs.getInt("3"));

            
              per.add(e);
            }
        } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
        }
        return per;
    }
}
