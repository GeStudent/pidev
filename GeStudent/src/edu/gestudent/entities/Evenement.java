/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

import java.util.Date;

/**
 *
 * @author user
 */
public class Evenement {
    private int id_event;
    private String nom;
    private String description;
    private String date;
    private String place;
    private int id_club;

    public Evenement() {
    }
    

    public Evenement(int id_event, String nom, String description, String date, String place, int id_club) {
        this.id_event = id_event;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.place = place;
        this.id_club = id_club;
    }

    public int getId_evenement() {
        return id_event;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_evenement(int id_event) {
        this.id_event = id_event;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nom=" + nom + ", description=" + description + ", date=" + date + ", place=" + place + ", id_club=" + id_club + '}';
    }
    
    
}
