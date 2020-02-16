/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

/**
 *
 * @author user
 */
public class MemberClub {
    private int id_club;
    private int id_member;

    public MemberClub(int id_club, int id_member) {
        this.id_club = id_club;
        this.id_member = id_member;
    }

    public int getId_club() {
        return id_club;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_club;
        hash = 29 * hash + this.id_member;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MemberClub other = (MemberClub) obj;
        if (this.id_club != other.id_club) {
            return false;
        }
        if (this.id_member != other.id_member) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MemberClub{" + "id_club=" + id_club + ", id_member=" + id_member + '}';
    }
    
}
