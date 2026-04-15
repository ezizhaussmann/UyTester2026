package org.tester.tekrar.h_excelLog;

import org.tester.aa_base.BaseClass;

import java.util.List;

/**
 * @created : 31/03/2026,20:20,mar.
 **/
public class Trst1 extends BaseClass {
    public static void main(String[] args) {
        setBrowser("https://demo.cubecart.com/admin_5xArPd.php");
//        String fileName="TestDataFolders/log.xlsx";
        ExcelTest excelTest = new ExcelTest();
        List<AdminCredentials> credentials = excelTest.readAdminCredentials();
        for (AdminCredentials cc : credentials) {
            login(cc.getUserName(), cc.getPassword());
            logOut();
        }
        closeBrowser();
    }
}
