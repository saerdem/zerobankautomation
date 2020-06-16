package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String pageTitle) {

        Driver.get().findElement(By.linkText(pageTitle)).click();
    }

    @Then("page should have the title {string}")
    public void page_should_have_the_title(String pageTitle) {
        System.out.println("         pageTitle = " + pageTitle);
        System.out.println("Current Page Title = " + Driver.get().getTitle());
        Assert.assertTrue("Verify the page title should be\"" + pageTitle+"\"", Driver.get().getTitle().equals(pageTitle));
    }


    @Then("page should have to following account types:")
    public void page_should_have_to_following_account_types(List<String> accountTypes) {
        BrowserUtils.waitFor(2);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String>actualAccounts = BrowserUtils.getElementsText(accountSummaryPage.accountTypesWE);

        Assert.assertEquals(accountTypes, actualAccounts);
        //System.out.println("actualAccounts = " + actualAccounts);
        //System.out.println("accountTypes = " + accountTypes);
    }

    @Then("Credit Accounts table must have the following columns")
    public void table_must_have_columns(List<String> columnsCreditAccount) {
        BrowserUtils.waitFor(2);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualCredAccColumns = BrowserUtils.getElementsText(accountSummaryPage.creditAccountsWE);
        BrowserUtils.waitFor(2);
        //System.out.println("actualCredAccColumns = " + actualCredAccColumns);
        //System.out.println("columnsCreditAccount = " + columnsCreditAccount);

        Assert.assertEquals(columnsCreditAccount, actualCredAccColumns);

    }


}
