package com.sauce.demo.testsuite;

import com.sauce.demo.pages.LoginPage;
import com.sauce.demo.pages.ProductPage;
import com.sauce.demo.propertyreader.PropertyReader;
import com.sauce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage ;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }
    String username = PropertyReader.getInstance().getProperty("usernameField");
    String password = PropertyReader.getInstance().getProperty("passwordField");

    //ProductPage productPage = new ProductPage();
    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValid() {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(productPage.getProductText(), "Products");


    }
}