package com.cydeo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://web-table-2.cydeo.com/create-order:blank
public class WebTable2CydeoCreateOrderPage {

    public WebTable2CydeoCreateOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}