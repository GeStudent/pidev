/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.entities.classEtudiant;
import edu.gestudent.entities.tcc;
import edu.gestudent.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHIKHAOUI NOUHA 1
 */
public class classEtudiantCRUD {
    
    
       private Connection con;
    private Statement ste;

    public classEtudiantCRUD() {
           con = DataBase.getInstance().getConnection();

    }

    public void ajouter(classEtudiant ce) throws SQLException {
        PreparedStatement pre = con.prepareStatement(" INSERT INTO `classEtudiant` ( `idclass`, `idetudiant`) VALUES ( ?, ?); ");
        pre.setInt(1, ce.getidclass());
        pre.setInt(2, ce.getidetudiant());
        pre.executeUpdate();
    }
    
    
    
    
       public List<classEtudiant> rechercheclassetudiant(int idclass ) throws SQLException {
        {
            List<classEtudiant> arr = new ArrayList<>();
            PreparedStatement pre = con.prepareStatement("SELECT  Cl.nameC, u.username   FROM  class cl ,user u, classEtudiant ce WHERE ce.idclass = cl.idclass AND ce.idEtudiant = u.id and ce.idclass=? ");
            pre.setInt(1, idclass);
            ResultSet rs = pre.executeQuery();
           
               while (rs.next()) {
                String namecl = rs.getString("nameC");
                String username = rs.getString("username");
             classEtudiant ce = new classEtudiant(namecl, username);
                arr.add(ce);
            }
               
          
            return arr;
        }
   }
    
}
