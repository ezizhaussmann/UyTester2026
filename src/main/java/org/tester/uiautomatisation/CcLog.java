package org.tester.uiautomatisation;

/**
 * @created : 30/03/2026,15:23,lun.
 **/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tester.automation_method.TestMethod;

public class CcLog extends TestMethod {
    // Initialisation du micro (logger)
    private static final Logger logger = LogManager.getLogger(CcLog.class);

    public static void main(String[] args) {
        // Cette ligne DOIT afficher quelque chose dans la console ET créer le fichier
        logger.info("Lancement du test Log4j2 réussi !");

        // Ton code Selenium habituel...
    }
}
