package pageobjectdesignpattern_log;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({ReportListener.class})
public class SimpleReportTest {

    @BeforeSuite
    public void setUpSuite() {
        ExtentReportManager.initReports();
        System.out.println("=== Initialisation des rapports ===");
    }

    @Test
    @Description("Test simple qui réussit")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccess() {
        System.out.println("Exécution du test de succès");
        Assert.assertTrue(true, "Ce test doit réussir");
    }

    @Test
    @Description("Test simple qui échoue")
    @Severity(SeverityLevel.CRITICAL)
    public void testFailure() {
        System.out.println("Exécution du test d'échec");
        Assert.assertTrue(false, "Ce test doit échouer pour démontrer les rapports");
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReports();
        System.out.println("=== Rapports générés ===");
    }
}