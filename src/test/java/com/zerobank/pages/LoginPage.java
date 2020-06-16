package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user_login")
    public WebElement usernameIB;

    @FindBy(id="user_password")
    public WebElement passwordIB;

    @FindBy(name = "submit")
    public WebElement submitBTN;


    public void login(String username, String password) {
        BrowserUtils.waitForVisibility(usernameIB,10);
        usernameIB.sendKeys(username);
        passwordIB.sendKeys(password);
        submitBTN.click();
    }


}
