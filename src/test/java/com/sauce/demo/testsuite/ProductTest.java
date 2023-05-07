package com.sauce.demo.testsuite;

import com.sauce.demo.pages.LoginPage;
import com.sauce.demo.pages.ProductPage;
import com.sauce.demo.propertyreader.PropertyReader;
import com.sauce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    ProductPage productPage ;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
            public void inIt()
    {
        productPage = new ProductPage();
        loginPage = new LoginPage();
    }
    String username = PropertyReader.getInstance().getProperty("usernameField");
    String password = PropertyReader.getInstance().getProperty("passwordField");


    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        String productPerPage = "6";
        Assert.assertEquals(productPage.getProductPerPage(),productPerPage);
    }
}
