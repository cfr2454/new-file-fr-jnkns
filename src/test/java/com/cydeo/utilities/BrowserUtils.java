package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {





    /*
    This method will accept int(in seconds) and execute Thread.sleep for given duration
     */

    public static void sleep (int second) {
        second *=1000;

        try {
            Thread.sleep(second);
        }catch(InterruptedException e){
        }
    }


    public static void switchWindowAndVerify (String expectedInUrl,  String expectedTitle){


        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        for (String each : allWindows) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current Url = " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }

        }

        //5. Assert: Title contains “Etsy"

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    /*
    This method accepts a String "expectedTitle" and Assrets if it is true
     */

    public static void verifyTitle(String expectedTitle ){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }


    public static void waitForInvisibilityOf(WebElement webElement){
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    //this method will verfy if the current URL contains expected value

    /**
     * this method will accept a String as expected value and verify actual URLCONTAINS the value
     * (:::::::>>>>>>TO MAKE THİS TYPE OF COMMENT ONE /(SLASH) AND TWO (**)STARS)
     * @param expectedInUrl
     */
    public static void verifyTitleContains(String expectedInUrl){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    /**
     * this method will accept a dropdown as a webelement
     * and returns all the options' text in a list of String.
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //create a list of string and pass all of the actual web element options' string into that new list

        List<String> actualOptionsAsStirng = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsStirng.add(each.getText());
        }
        return actualOptionsAsStirng;
    }

    /**
     * this method will accept a group radio buttons as a list of WebElement
     * it will loop through the list, and click to the radio button with provided attribute value
     * @param radioButtons
     * @param attributeValue
     */

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }

        }
    }

}
