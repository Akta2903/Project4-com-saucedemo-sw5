package com.sauce.demo.pages;

import com.aventstack.extentreports.Status;
import com.sauce.demo.customlisteners.CustomListeners;
import com.sauce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id="user-name")
    WebElement usernameField;

   //By usernameField = By.id("user-name");

    @CacheLookup
    @FindBy(name="password")
    WebElement passwordField;

    //By passwordField = By.name("password");

    @CacheLookup
    @FindBy(id="login-button")
            WebElement loginLink;

  //  By loginLink = By.id("login-button");


    public void enterUsername(String username)
    {
        sendTextToElement(usernameField,username);
        CustomListeners.test.log(Status.PASS,"Enter username : " + username);
    }

    public void enterPassword(String password)
    {
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS,"Enter password : " + password);
    }

    public void clickOnLoginButton()

    {
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS,"Click on Login button :" );
    }



}
