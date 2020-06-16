package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy (id = "aa_accountId")
    public WebElement accountID;

    @FindBy (id = "aa_description")
    public WebElement findDescription;

    @FindBy (xpath = "//body//option")
    public List<WebElement> accountOptions;

    @FindBy (xpath = "//a[@href='#ui-tabs-1']")
    public WebElement showTransactions;

    @FindBy (xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransactions;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy (xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findBTN;

    @FindBy(id = "filtered_transactions_for_account")
    public WebElement transactionTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> foundTransactionsDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> foundDescriptions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> foundDeposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> foundWithdrawals;


    @FindBy(id = "aa_description")
    public WebElement descrptInBox;

    @FindBy(id="aa_type")
    public WebElement transactionTypeDD;


    public boolean isDropdownSelected(String expectedOption) {
        Select select = new Select(accountID);
        String act = select.getFirstSelectedOption().getText();
        return act.equals(expectedOption);
    }


    public void goToTransaction(String linkName){
        Driver.get().findElement(By.linkText(linkName)).click();
    }



}
