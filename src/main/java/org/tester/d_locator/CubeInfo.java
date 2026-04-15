package org.tester.d_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @created : 19/03/2026,20:20,jeu.
 **/
public class CubeInfo {
    private String user;
    private String pvd;

    public CubeInfo() {
    }

    public CubeInfo(String user, String pvd) {
        this.user = user;
        this.pvd = pvd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPvd() {
        return pvd;
    }

    public void setPvd(String pvd) {
        this.pvd = pvd;
    }
    public void login(){



    }

    @Override
    public String toString() {
        return "CubeInfo{" +
                "user='" + user + '\'' +
                ", pvd='" + pvd + '\'' +
                '}';
    }
}
