package men.programmer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class ConnexionSteps {

    @Given("je suis sur la page de connexion")
    public void jeSuisSurLaPageDeConnexion() {
        // TODO: Implement step
    }

    @When("je saisis mon nom d'utilisateur {string}")
    public void jeSaisisMonNomDUtilisateur(String username) {
        // TODO: Implement step
    }

    @And("je saisis mon mot de passe {string}")
    public void jeSaisisMonMotDePasse(String password) {
        // TODO: Implement step
    }

    @And("je clique sur le bouton {string}")
    public void jeCliqueSurLeBouton(String buttonName) {
        // TODO: Implement step
    }

    @Then("je suis redirigé vers la page d'accueil")
    public void jeSuisRedirigeVersLaPageDAccueil() {
        // TODO: Implement step
    }

    @And("je vois le message {string}")
    public void jeVoisLeMessage(String message) {
        // TODO: Implement step
    }
}
