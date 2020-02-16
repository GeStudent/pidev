/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.tests;

import edu.gestudent.entities.Emprunt;
import edu.gestudent.entities.Livre;
import edu.gestudent.services.EmpruntCrud;
import edu.gestudent.services.LivreCrud;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class mainclassFares {

    public static void main(String[] args) {
        LivreCrud lcr = new LivreCrud();
        Livre l = new Livre("Jou7a wal Fa2r", "/image", "fares baccouche", "/http:", "comedie", 12);
        Livre l2 = new Livre("da vinci code", "/image", "dan brown", "/http:", "drama", 20);
        Livre l3 = new Livre("al ayem", "/image", "tah hsin", "/http:", "histoire", 16);
        //lcr.ajouterLivre(l);
        //lcr.ajouterLivre(l2);
        //lcr.ajouterLivre(l3);
        //System.out.println(lcr.afficherlivre());
        //System.out.println(lcr.rechrecherlivre("da vinci code"));
        //lcr.Update("al ayem", "/image", "/http", "categorie", 14);
        //lcr.supprimerlivre(l2);
        //EmpruntCrud emc = new EmpruntCrud();
        //Emprunt e1 = new Emprunt("2020-04-04", "2021-12-25", 1, 2);
        //Emprunt e2 = new Emprunt("2020-02-01", "2021-01-20", 1, 2);
        //Emprunt e3 = new Emprunt("2020-12-12", "2021-03-19", 1, 2);
        //emc.ajouterEmprunt(e1);
        //emc.ajouterEmprunt(e2);
        //emc.ajouterEmprunt(e3);
        //System.out.println(lcr.afficherEmprunt());
        //lcr.supprimeremprunt(l2);



        
        
        

        

    }

}
