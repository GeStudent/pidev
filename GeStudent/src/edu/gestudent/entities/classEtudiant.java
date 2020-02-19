/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

/**
 *
 * @author CHIKHAOUI NOUHA 1
 */
public class classEtudiant {
    
    
      private String namecl ;
     private String username ;
        private int idetudiant;
    
      private int idclass;
   
    

    public classEtudiant( int idclass,int idetudiant ) {
        this.idetudiant = idetudiant;
        this.idclass = idclass;
      

    }
      public classEtudiant ( String namecl , String username) 
       {
        this.namecl = namecl;
        this.username = username;
      
       
        }
     
   public classEtudiant( int idetudiant) {
        this.idetudiant = idetudiant;
     
      

    }
  

   

   
 public int getidetudiant() {
        return idetudiant;
    }

    public int getidclass() {
        return idclass;
    }

   
   

   

    public void setidetudiant(int idetudiant) {
        this.idetudiant = idetudiant;
    }
     public void setIdclass(int idclass) {
        this.idclass = idclass;
    }

  

    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idetudiant;
        return hash;
    }

  /*public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final classe other = (classe) obj;
        return this.idetudiant == other.idetudiant;
    }*/

   
        @Override
    public String toString() {
        return "classEtudiant{" + "namecl=" + namecl + ", username=" + username +  '}';
          
    }
    
}
