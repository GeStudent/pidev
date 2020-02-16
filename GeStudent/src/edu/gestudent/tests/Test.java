/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.Behaviour;
import edu.gestudent.entities.user;
import edu.gestudent.services.ServicesUsers;
import edu.gestudent.services.behaviourCRUD;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayadi
 */
public class Test {

    public static void main(String[] args) {
        behaviourCRUD be = new behaviourCRUD();
//            ServicesUsers su =new ServicesUsers();
//             user u = new user("gh","ayadi","dd.dd@esprit.tn","student","1995-05-06",22901120,"Tunisia","bellvue","female");
        Behaviour b = new Behaviour(1, 2);

      
        
        try {
            // be.ajouterbeh(b);
            //be.updateatt(6,5);
            be.delete(6);
            // su.ajouter(u);
            // su.updateimage("171JMTB216","cssphoto");
            //su.delete("171JMT212");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   
        

        System.out.println(be.afficherBehaviour());

    }

}
