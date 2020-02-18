/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.Student;
import edu.gestudent.entities.teacher;
import edu.gestudent.services.ServiceStudent;
import edu.gestudent.services.ServicesTeacher;
import edu.gestudent.services.ServicesUsers;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ayadi
 */
public class MainAyadi {

    public static void main(String[] args) {
        ServicesUsers sur = new ServicesUsers();
        ServiceStudent usr = new ServiceStudent();
        ServicesTeacher stc = new ServicesTeacher();

        Student s = new Student("amin", "benchiekh", "amin.benchiekh@esprit.tn", "1998-02-12", 44128252, "Tunisia", "Bellvue", "male");

         usr.ajouterStudent(s);
        usr.ajouterAccount("amin01", "img/amin", "amin123", usr.getQRcode("amin.benchiekh@esprit.tn"));
        //usr.affcterclass("137GEF1315",2);
        //System.out.println(usr.readAllStudent());
        teacher t = new teacher("lotfi", "abed el naser", "lotfi.naser", "1970-12-02", 71230201, "France", "lac2", "Male", (float) 2150);
        //stc.ajouterAccount("lotfi007", "img/lotfi", "123456", "145GEF1327");
        // stc.ajouterTeacher(t);
        //System.out.println(stc.readAllTeachers());
        // sur.checkUser("amin01", "amin1f23");
        System.out.println(sur.findbyidcode("145GEF1327"));
        // System.out.println(stc.readAllTeachersSortedBySalary());

    }

}
