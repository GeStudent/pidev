/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.classEtudiant;
import edu.gestudent.entities.classe;
import edu.gestudent.entities.cours;
import edu.gestudent.entities.tcc;
import edu.gestudent.services.classCRUD;
import edu.gestudent.services.classEtudiantCRUD;
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
      
         classEtudiantCRUD ce = new classEtudiantCRUD();
         
      // `idclass`, `idteacher`,`idcours`) ce1/farah/philo/10
       // tcc t = new tcc(6,6,22);
        classEtudiant e = new classEtudiant(1,1);
         classEtudiant el = new classEtudiant(1,2);
          classEtudiant ell = new classEtudiant(1,3);
           classEtudiant elll = new classEtudiant(1,4);
           
      // classe cl = new classe("bac ");
           
      //  cours c = new cours("anglais","past ",2);
        
        try {
                       //ce.ajouter(e);
                   // ce.ajouter(el);
                 //     ce.ajouter(ell);
                      // ce.ajouter(elll);
            
            //a.modifierclass( "bac",1);
           // ser.modifiercours(12, 22) ;
           // ser.supprimercour(21);
           // a.supprimerclass(7);
            // te.ajouter(t);//ajout tcc
         // List<tcc> list3 = te.rechercheclass(6);//recherche classe
          // System.out.println(list3);
             List<classEtudiant> list10 = ce.rechercheclassetudiant(1);//rechercheclasseetudiant
            System.out.println(list10);
             
            // List<tcc> list4 = te.rechercheprof(9);//recherche prof
            //System.out.println(list4);
             
            // List<tcc> list5 = te.recherchecour(22);//recherche cours
            // System.out.println(list5);
              
         //      a.ajouter(cl); //ajout classe
         
             // ser.ajouter(c);//ajout cours
               
             // List<cours> list = ser.readAll();
             // System.out.println(list);
               
              // List<classe> list2 = a.readAll();
             // System.out.println(list2);
          
           
        } catch (SQLException ex) {
            ex.getMessage();        }
    }
    
}
