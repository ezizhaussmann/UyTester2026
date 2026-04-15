package org.tester.l_ioExel;

import org.apache.commons.math3.analysis.function.Log;
import org.tester.uiautomatisation.CubeCartLoginTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.logging.LogManager.*;

/**
 * @created : 30/03/2026,14:23,lun.
 **/
public class ReadColumnValue {
  static Logger logger = LogManager.getLogger(ReadColumnValue.class);
    public static void main(String[] args) {

        ExcelUtility excelUtility = new ExcelUtility();
        String fileN="TestDataFolders/cc.xlsx";
        String firstN= excelUtility.readDataFromExcelColum(fileN,"CustomerInfo",0,2);

        logger.info(firstN);
        // Exemple : on vérifie que le prénom est bien "Jean"
        String valeurAttendue = "Jean";
        String tt="Phone";

        if (firstN.equals(valeurAttendue)) {
            logger.info("Vérification réussie : La valeur correspond bien à " + valeurAttendue);
        } else if(firstN.contains(tt)) {
            logger.info("Phone mushuning ichide bar"+tt);

        } else {
            logger.error("Vérification échouée ! Attendu : " + valeurAttendue + " mais reçu : " + firstN);
        }




    }
}
