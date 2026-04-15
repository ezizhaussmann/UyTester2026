package org.tester.aa_base;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @created : 02/04/2026,18:24,jeu.
 **/
public class MultipleLoginT extends BaseClass{
    public static void main(String[] args) throws InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        UsersObject usersObject = null;
        try {
//            usersObject= objectMapper.readValue(new File("jsonfiles/users.json"), UsersObject.class);
            usersObject=objectMapper.readValue(new File("jsonfiles/users.json"), UsersObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<User> loginUsers=usersObject.getUser();
        setBrowser("https://demo.cubecart.com/admin_5xArPd.php");
        implicitWait();
        for (User loginUser : loginUsers) {
            login(loginUser.getUserName(),loginUser.getPassword());
            tryForBrowser();
            ccAlert();
            logOut();

        }
        closeBrowser();
    }
}
