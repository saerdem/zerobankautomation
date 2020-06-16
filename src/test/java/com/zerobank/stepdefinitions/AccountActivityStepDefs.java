package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityStepDefs {


    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
       new AccountSummaryPage().goToAccountType(accountType);
       BrowserUtils.waitFor(1);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String accountType) {
        //System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());
        Assert.assertTrue("Verify Title is " + accountType, Driver.get().getTitle().contains("Account Activity")) ;
}

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {

        Assert.assertTrue("First option is " + expectedOption, new AccountActivityPage().isDropdownSelected(expectedOption));
    }
}
