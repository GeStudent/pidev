/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.IService.IService;
import edu.gestudent.entities.Club;
import edu.gestudent.entities.Evenement;
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
public class ServiceEvenement implements IService<Evenement> {

    private  Connection con;
    private Statement ste;
    public ServiceEvenement() {
        con = DataBase.getInstance().getConnection();

    }
     @Override
    public void ajouter(Evenement e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `evenement` (`id_event`, `nom`, `description`, `date`,`place`,`id_club`) VALUES (NULL, '" + e.getNom() + "', '" + e.getDescription() + "', '" + e.getDate() + "','" + e.getPlace() + "','" + e.getId_club() + "');";
        ste.executeUpdate(requeteInsert);

    }          

 

    public boolean update(Evenement e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    public boolean supprimer(Evenement e) throws SQLException {

        String reqeute = "delete from Evenement  where (nom = ?) ;";
        try {
            PreparedStatement pst = con.prepareStatement(reqeute);
            pst.setString(1, e.getNom());
            // pst.setString(2, m.setDescription(reqeute));
            if (pst.executeUpdate() != 0) {
                System.out.println("Evenement deleted");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return false;
//To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public boolean delete(Evenement t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evenement> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    


   
    
   
    
}

