/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

//import edu.gestudent.Service.ServiceClub;
import edu.gestudent.services.ServiceClub;
import edu.gestudent.services.ServiceEvenement;
import edu.gestudent.entities.Club;
import edu.gestudent.entities.Evenement;
import edu.gestudent.entities.MemberClub;
import edu.gestudent.services.ServiceMemberClub;
import edu.gestudent.utils.DataBase;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public class mainclassNader {

    public static void main(String[] args) {
        ServiceClub ser = new ServiceClub();
        ServiceEvenement ser1 = new ServiceEvenement();
        ServiceMemberClub ser2 = new ServiceMemberClub();

        Club c1 = new Club(1, "nader", "1996-04-26", "rotary@gmaiil.com", 1, "le club est magnifique", 1, 7);
        Club c2 = new Club(2, "yassine", "1996-04-27", "rotary@gmaail.com", 1, "le club est magnifique", 1, 17);
        Club c3 = new Club(3, "pipo", "1996-04-28", "rotary@gmaiaal.com", 1, "le club est magnifique", 1, 117);
        Club c4 = new Club(1, "nouha", "1996-04-29", "rotary@gmaaaail.com", 1, "le club est magnifique", 1, 1117);

        MemberClub mc1 = new MemberClub(7, 10);
        Evenement e1 = new Evenement(2, "nhebek heegfghjeeeedi", "le film est magnifique", "2020-02-26", "bloc e", 1);

        ser.triByDate();
//System.out.println(ser.rechercher("evefrnt"));
// ser1.ajouter(e1);
// ser2.ajouter(mc1);
// ser2.supprimer(mc1);
//ser.ajouter(c1);
//ser1.supprimer(e1);
// System.out.println(ser.readyByNom("evefrnt"));
// ser.supprimer(c1);
// ser.Update(0, "evefrnt");
//System.out.println(ser.readAll());
// List<Club> list = ser.readAll();
//   System.out.println(list);

    }

}
