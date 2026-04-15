package org.tester.addCustomer;

import com.microsoft.playwright.CLI;

import java.io.IOException;

/**
 * @created : 18/03/2026,00:07,mer.
 **/
public class AddInfo {
    private String prenom;
    private String nom;
    private String email;
    private int  age;
    private long  salaire;
    private String departement;

    public AddInfo() {
    }

    public AddInfo(String prenom, String nom, String email, int age, long salaire, String departement) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.age = age;
        this.salaire = salaire;
        this.departement = departement;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalaire() {
        return salaire;
    }

    public void setSalaire(long salaire) {
        this.salaire = salaire;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public void play(String uu) throws IOException, InterruptedException {
        CLI.main(new String[] {"codegen", uu});
    }

    @Override
    public String toString() {
        return "AddInfo{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salaire=" + salaire +
                ", departement='" + departement + '\'' +
                '}';
    }
}
