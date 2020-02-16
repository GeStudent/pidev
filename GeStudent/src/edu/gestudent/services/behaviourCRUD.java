/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.entities.Behaviour;
import edu.gestudent.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class behaviourCRUD {

    Connection con;
    Statement ste;

    public behaviourCRUD() {
        con = DataBase.getInstance().getConnection();
    }

    public void ajouterbeh(Behaviour b) {
        String requete2 = "INSERT INTO behaviour (attendance,award)VALUES (?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(requete2);
//            pre = con.prepareStatement("INSERT INTO behaviour (attendance,award)VALUES (?,?)");
            pst.setInt(1, b.getAttendance());
            pst.setInt(2, b.getAward());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

//         public boolean updateaward(String idcode, String image) throws SQLException {
//
//        PreparedStatement pre = con.prepareStatement("update behaviour set image =? where idcode=? ;");
//        pre.setString(1, image);
//        pre.setString(2, idcode);
//        if (pre.executeUpdate() != 0) {
//            System.out.println("user's image is up to date");
//            return true;
//        }
//        System.out.println("id user not found!!!");
//        return false;
//
//    }
    public boolean updateatt(int idbeh, int attendance) throws SQLException {

        try {
            PreparedStatement pre = con.prepareStatement("update behaviour set attendance =? where idbeh=? ;");
            pre.setInt(1, attendance);
              pre.setInt(2, idbeh);
            if (pre.executeUpdate() != 0) {
                System.out.println("attendance is updated");
                return true;
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("id student not found!!!");
            return false;
       

    }

    public boolean updateawa(int idbeh, int award) throws SQLException {
        try {
            PreparedStatement pre = con.prepareStatement("update behaviour set award =? where idbeh=? ;");

            pre.setInt(1, award);
            pre.setInt(2, idbeh);

            if (pre.executeUpdate() != 0) {
                System.out.println("award is updated");
                return true;
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("id student not found!!!");
            return false;


    }

    public boolean delete(int idbeh) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from behaviour where idbeh=? ;");
try{
        pre.setInt(1, idbeh);
        if (pre.executeUpdate() != 0) {
            System.out.println("behaviour Deleted");
            return true;
        }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id user not found!!!");
        return false;

    }

    public List<Behaviour> afficherBehaviour() {
        ArrayList<Behaviour> per = new ArrayList();

        try {
            String requete3 = "SELECT * FROM behaviour";
            PreparedStatement pst2 = con.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Behaviour b = new Behaviour();
                b.setIdbeh(rs.getInt("idbeh"));
                b.setAttendance(rs.getInt(2));
                b.setAward(rs.getInt(3));

                per.add(b);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return per;
    }
}
