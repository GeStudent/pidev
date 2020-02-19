/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.Behaviour;
import edu.gestudent.entities.exams;
import edu.gestudent.entities.user;
import edu.gestudent.services.ServicesUsers;
import edu.gestudent.services.behaviourCRUD;
import edu.gestudent.services.examsCRUD;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayadi
 */
public class Test {

    public static void main(String[] args) {
        //behaviourCRUD be = new behaviourCRUD();
                examsCRUD ex = new examsCRUD();

//            ServicesUsers su =new ServicesUsers();
//             user u = new user("gh","ayadi","dd.dd@esprit.tn","student","1995-05-06",22901120,"Tunisia","bellvue","female");

            exams e = new exams("nn", "1998-02-12", "10");


      
            // be.ajouterbeh(b);
            //be.updateatt(6,5);
            ex.ajoutex(e);
   
           // ex.delete(6);
            // su.ajouter(u);
            // su.updateimage("171JMTB216","cssphoto");
            //su.delete("171JMT212");
     
        

        System.out.println(ex.afficherex());

    }

}
