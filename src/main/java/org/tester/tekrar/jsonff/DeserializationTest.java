package org.tester.tekrar.jsonff;

/**
 * @created : 03/04/2026,18:32,ven.
 **/
import com.fasterxml.jackson.databind.ObjectMapper;
import org.tester.jjj_json.Api;
import org.tester.jjj_json.WebAutomation;

import java.io.File;

public class DeserializationTest {
    public static void main(String[] args) {
        try {
            // 1. Créer l'objet principal de Jackson
            ObjectMapper mapper = new ObjectMapper();

            // 2. Lire le fichier JSON (nommé ici "course.json")
            // Jackson utilise le constructeur par défaut et les annotations @JsonProperty
//
//            SDETCourse data = mapper.readValue(new File("Gemini1"+File.separator+"course2.json"), SDETCourse.class);
mapper.writeValue(new File("Gemini1"+File.separator+"course2.json"),SDETCourse.class);
            SDETCourse data = new SDETCourse();
            // 3. Test de récupération des données via les Getters
            System.out.println("--- Informations Générales ---");
            System.out.println("Formateur : " + data.getInstructor());
            System.out.println("Expertise : " + data.getExpertise());

            System.out.println("\n--- Liste Web Automation ---");
            for(WebAutomation web : data.getCourses().getWebAutomation()) {
                System.out.println("- " + web.getCourseTitle() + " : " + web.getPrice() + "$");
            }

            System.out.println("\n--- Liste API ---");
            for(Api api : data.getCourses().getApi()) {
                System.out.println("- " + api.getCourseTitle() + " : " + api.getPrice() + "$");
            }

        } catch (Exception e) {
            System.err.println("Erreur lors de la désérialisation !");
            e.printStackTrace();
        }
    }
}