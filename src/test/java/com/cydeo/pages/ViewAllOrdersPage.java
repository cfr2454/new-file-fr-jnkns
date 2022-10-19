package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllOrdersPage extends BasePage{


    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //we need to locate
    @FindBy(xpath = "//table[@class='table is-fullwidth']/tbody/tr[1]/td[1]")
    public WebElement newCustomerCell;

    //@FindBy(xpath = "//td")
    //html/body/div[1]/section/div/div[2]/div[2]/table/tbody/tr[1]/td[1]

//td




}
