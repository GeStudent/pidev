/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.classe;
import edu.gestudent.entities.cours;
import edu.gestudent.entities.tcc;
import edu.gestudent.services.classCRUD;
import edu.gestudent.services.coursCRUD;
import edu.gestudent.services.tccCRUD;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author CHIKHAOUI NOUHA
 */
public class mainclassNouha {
    
    public static void main(String[] args) throws SQLException {
        coursCRUD ser = new coursCRUD();
         tccCRUD te = new tccCRUD();
         classCRUD a = new classCRUD(); 
      
       //tcc t = new tcc(5,6,2);
        
         
             //classe cl = new classe("ce1");
           
       // cours c1 = new cours("physique","ph",1);
        //
      
        
        try {
             //te.ajouter(t);
                List<tcc> list3 = te.affichertc(6);
        System.out.println(list3);
           //a.ajouter(cl);
         
            //ser.ajouter(c2);
          // List<cours> list = ser.readAll();
          // List<classe> list2 = a.readAll();
       
          //System.out.println(list);
         // System.out.println(list2);
           
        } catch (SQLException ex) {
            ex.getMessage();        }
    }
    
}
