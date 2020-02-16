/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.IService.IService;
import edu.gestudent.entities.Club;
import edu.gestudent.entities.MemberClub;
import edu.gestudent.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author user
 */

    
    public class ServiceMemberClub implements IService<MemberClub> {

    private Connection con;
    private Statement ste;

    public ServiceMemberClub() {
        con = DataBase.getInstance().getConnection();

    }

   public void ajouter(MemberClub mc) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `MemberClub` (`id_member`, `id_club`) VALUES ( '" + mc.getId_club() + "', '" + mc.getId_member() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(MemberClub t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(MemberClub t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MemberClub> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public int supprimer(MemberClub mc) throws SQLException {

        String reqeute;
        reqeute = "delete  from MemberClub  where (id_member = ?) ";
        try {
            PreparedStatement pst = con.prepareStatement(reqeute);
            pst.setInt(1, mc.getId_member());
            // pst.setString(2, m.setDescription(reqeute));
            if (pst.executeUpdate() != 0) {
                System.out.println("MemberClub deleted");
            }
           // return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
       // return false;
        return 0;
   
}
 }