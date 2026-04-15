package org.tester.stremapi;

/**
 * @created : 14/04/2026,19:05,mar.
 **/
import java.util.*;
import java.util.stream.Collectors;

class Employe {
    String nom;
    double salaire;

    Employe(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }

    String getNom() { return nom; }
    double getSalaire() { return salaire; }
}

public class CoursStream {
    public static void main(String[] args) {
        List<Employe> staff = Arrays.asList(
                new Employe("Alice", 3500),
                new Employe("Bob", 2200),
                new Employe("Charlie", 4000),
                new Employe("Damien", 1800)
        );

        // --- LE PIPELINE STREAM ---
        List<String> resultat = staff.stream()
                .filter(e -> e.getSalaire() > 2500)      // Étape 1 : Filtrage
                .map(Employe::getNom)                    // Étape 2 : Transformation (Raccourci !)
                .sorted()                                // Étape 3 : Tri alphabétique
                .collect(Collectors.toList());           // Étape 4 : Conclusion

        System.out.println("Employés bien rémunérés : " + resultat);

        // On crée un petit conteneur léger
        record EmployeInfo(String nom, double salaire) {}

        List<EmployeInfo> resultat1 = staff.stream()
                .filter(e -> e.getSalaire() > 2500)
                .map(e -> new EmployeInfo(e.getNom(), e.getSalaire())) // On crée le nouvel objet
                .collect(Collectors.toList());
        System.out.println(resultat1);

        boolean allmatch=staff.stream().allMatch(employe -> employe.getSalaire()>=2200);
        System.out.println(allmatch);
        boolean anymatch=staff.stream().anyMatch(employe -> employe.getSalaire()<=3000);
        System.out.println(anymatch);
        boolean nonmatché=staff.stream().noneMatch(employe -> employe.getSalaire()>5000);
        System.out.println(nonmatché);
    }
}
