package com.sauce.demo.pages;

import com.aventstack.extentreports.Status;
import com.sauce.demo.customlisteners.CustomListeners;
import com.sauce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement productText;
    // By productText = By.xpath("//span[@class='title']");

    @CacheLookup
    By productList = By.xpath("//div[@class='inventory_item']");




    public String getProductPerPage() {
        List<WebElement> productElementList = driver.findElements(productList);
        int size = productElementList.size();
        return String.valueOf(size);

          }


    public String getProductText() {
        CustomListeners.test.log(Status.PASS,"Verify Product Text is displayed on page:  " + productText);
        return getTextFromElement(productText);
    }


}
