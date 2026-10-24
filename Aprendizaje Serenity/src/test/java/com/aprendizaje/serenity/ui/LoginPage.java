package com.aprendizaje.serenity.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("/")
public class LoginPage extends PageObject {

    public static final By USERNAME = By.id("user-name");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public void loginAs(String username, String password) {
        $(USERNAME).clear();
        $(USERNAME).sendKeys(username);
        $(PASSWORD).clear();
        $(PASSWORD).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public String errorMessage() {
        return $(ERROR_MESSAGE).waitUntilVisible().getText();
    }
}
