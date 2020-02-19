/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.IService.Icrud;
import edu.gestudent.entities.classe;
import edu.gestudent.entities.cours;
import edu.gestudent.entities.tcc;
import edu.gestudent.utils.DataBase;
//import edu.gestudent.utils.myconnection;
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
public class tccCRUD {

    private Connection con;
    private Statement ste;

    public tccCRUD() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(tcc t) throws SQLException {
        PreparedStatement pre = con.prepareStatement(" INSERT INTO `tcc` ( `idclass`, `idteacher`,`idcours`) VALUES ( ?, ?, ?); ");
        pre.setInt(1, t.getIdclass());
        pre.setInt(3, t.getidteacher());
        pre.setInt(2, t.getIdcours());

        pre.executeUpdate();
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<tcc> affichertc(int idclass) throws SQLException {
        {
            List<tcc> arr = new ArrayList<>();
            PreparedStatement pre = con.prepareStatement("SELECT C.name,c.duration, Cl.nameC, u.firstname FROM cours C, class cl, user u, tcc t WHERE t.idcours = c.idcour AND t.idteacher = u.id and cl.idclass=t.idclass and t.idclass=? ");
            pre.setInt(1, idclass);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String nameC = rs.getString("nameC");                
                int duration = rs.getInt(2);
                String firstname = rs.getString("firstname");

                tcc t = new tcc(name, nameC, duration, firstname);
                arr.add(t);
            }
            return arr;
        }
    }
        
         public List<tcc> recherchecour(int idcours) throws SQLException {
        {
            List<tcc> arr = new ArrayList<>();
       
            
            PreparedStatement pre = con.prepareStatement("SELECT C.name,c.duration, Cl.nameC, u.firstname FROM cours C, class cl, user u, tcc t WHERE t.idcours = c.idcour AND t.idteacher = u.id and cl.idclass=t.idclass and t.idcours= ? ");   
             
            pre.setInt(1, idcours);
            ResultSet rs = pre.executeQuery(); 
            while (rs.next()) {
                     
                String name = rs.getString("name");
                
                String nameC = rs.getString("nameC");  
          
                int duration = rs.getInt(2);
                String firstname = rs.getString("firstname");

                tcc r = new tcc(name, nameC, duration, firstname);
                arr.add(r);
            }
            return arr;
        }
         
         }

         public List<tcc> rechercheprof(int idteacher) throws SQLException {
        {
            List<tcc> arr = new ArrayList<>();
            
            PreparedStatement pre = con.prepareStatement("SELECT C.name,c.duration, Cl.nameC, u.firstname FROM cours C, class cl, user u, tcc t WHERE t.idcours = c.idcour AND t.idteacher = u.id and cl.idclass=t.idclass and t.idteacher= ? ");   
          
            pre.setInt(1, idteacher);
             
            
       
            ResultSet rs = pre.executeQuery(); 
           
            while (rs.next()) {
                String name = rs.getString("name");
                
                String nameC = rs.getString("nameC");  
          
                int duration = rs.getInt(2);
                String firstname = rs.getString("firstname");

                tcc r = new tcc(name, nameC, duration, firstname);
                arr.add(r);
            }
            return arr;
            
        }
         
         
         }

        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
