package org.tester.tekrar.h_excelLog;

/**
 * @created : 31/03/2026,19:25,mar.
 **/
public class AdminCredentials {
    private  String userName;
    private  String password;

    public AdminCredentials() {
    }

    public AdminCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
