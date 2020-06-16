package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypesWE;

    @FindBy(xpath = "//div[3]//div[1]//table[1]//thead[1]//tr[1]/th")
    public List<WebElement> creditAccountsWE;



    public void goToAccountType (String accountType){
        Driver.get().findElement(By.linkText(accountType)).click();
    }



}
