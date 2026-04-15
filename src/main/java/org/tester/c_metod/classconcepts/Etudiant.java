package org.tester.c_metod.classconcepts;



/**
 * @created : 18/03/2026,15:23,mer.
 **/
public class Etudiant {
    public  int id;
    public  String nom;
    public String prenom;

    public Etudiant() {
    }

    public Etudiant(int id,String nom, String prenom) {
        this.id = id;
        this.nom=nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(113);
        System.out.println(etudiant.getId());
        Etudiant etudiant1 = new Etudiant(112,"Dragon","luffy");
        System.out.println(etudiant1);
    }
}
