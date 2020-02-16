/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

/**
 *
 * @author ASUS
 */
public class Emprunt {

    private int id_emprunt;
    private String date_emprunt;
    private String date_retour;
    private int id;
    private int id_livre;

    public Emprunt(String date_emprunt, String date_retour, int id, int id_livre) {
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
        this.id = id;
        this.id_livre = id_livre;
    }

    public Emprunt() {
    }

    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public String getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(String date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }
    
    

}
