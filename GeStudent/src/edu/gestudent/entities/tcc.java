/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestudent.entities;

/**
 *
 * @author CHIKHAOUI NOUHA
 */ 

public class tcc {
   
     
     private String name ;
     private int duration ;
     private String nameC ;
     private String firstname ;
     private int idclass;
     private int idcours;
    public int idteacher;
   
    
 public tcc(int idteacher,int idclass, int idcours)
    {
       this.idteacher = idteacher; 
         this.idclass = idclass;
        this.idcours = idcours;
    }
   public tcc( int idteacher,String name ,int duration ,String nameC,String firstname,int idclass,int idcours)
    {
        this.idteacher = idteacher;
        this.name = name;
         this.duration = duration;
        this.nameC = nameC;
        this.firstname = firstname;
        this.idclass = idclass;
        this.idcours = idcours;
      

    } 
       public tcc ( String name , String nameC,int duration ,String firstname) 
       {
        this.name = name;
        this.nameC = nameC;
        this.duration = duration;
        this.firstname = firstname;
       
        }

  

   
 public String getName()
    {
        return name;
    }
 
  public String getNameC() 
    {
        return nameC;
    }
  
 public String getfirstName()
    {
        return firstname;
    }

    public int getIdclass() {
        return idclass;
    }
     public int getIdcours() {
        return idcours;
    }
      public int getidteacher() {
        return idteacher;
    }


   
   

   

    public void setName(String name)
    {
        this.name = name;
    }
    
        public void setNameC(String nameC) 
        {
        this.nameC = nameC;
         }
        
     public void setIdclass(int idclass)
     {
        this.idclass = idclass;
     }
      public void setIdcours(int idcours) 
      {
        this.idcours = idcours;
      }
      public void setIdteacher(int idteacher) 
      {
        this.idteacher = idteacher;
      }

  

    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idclass;
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
        final tcc other = (tcc) obj;
        return this.idcours == other.idcours;
    }

    @Override
    public String toString() {
        return "tcc{" + "name=" + name + ", duration=" + duration + ", nameC=" + nameC + ", firstname=" + firstname + '}';
    }

    

    

}

