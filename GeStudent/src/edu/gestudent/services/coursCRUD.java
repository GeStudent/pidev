/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.services;

import edu.gestudent.IService.Icrud;
import edu.gestudent.entities.cours;
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
 * @author CHIKHAOUI NOUHA
 */
public class coursCRUD implements Icrud<cours> {

    private Connection con;
    private Statement ste;

    public coursCRUD() {
        con = DataBase.getInstance().getConnection();

    }


    public void ajouter(cours c) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `cours` ( `name`, `lesson`, `duration`) VALUES ( ?, ?, ?);");
    pre.setString(1, c.getName());
    pre.setString(2, c.getlesson());
     pre.setInt(3, c.getduration());
    pre.executeUpdate();
    }
            

    
    public boolean delete(cours c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public boolean update(cours c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
    public List<cours> readAll() throws SQLException {
    List<cours> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from cours");
     while (rs.next()) {                
               int idcour=rs.getInt(2);
               String name=rs.getString("name");
               String lesson=rs.getString(3);
               int duration=rs.getInt("duration");
               cours c=new cours( name,idcour, lesson, duration);
     arr.add(c);
     }
    return arr;
    }
}
 

