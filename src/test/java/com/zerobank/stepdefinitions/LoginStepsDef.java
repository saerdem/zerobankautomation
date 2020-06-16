package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepsDef {


    @Given("the user is in the login page")
    public void the_user_is_in_the_login_page() {
        //Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enter valid credentials {string} {string}")
    public void the_user_enter_valid_credentials(String username, String password) {
        //String username = ConfigurationReader.get("username");
        //String password = ConfigurationReader.get("password");

        new LoginPage().login(username, password);
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        BrowserUtils.waitFor(3);
        String expectedTitle = "Zero - Account Summary";
        String actualTitle = Driver.get().getTitle();

        //System.out.println("expectedTitle = " + expectedTitle);
        //System.out.println("actualTitle = " + actualTitle);
        Assert.assertTrue("Verify that "+expectedTitle+" Page is Displayed",actualTitle.contains(expectedTitle));
    }

    @Then("Error message {string} should be displayed.")
    public void error_message_should_be_displayed(String string) {
        String errorMessage = "Login and/or password are wrong";
        System.out.println("\""+errorMessage+"\" error message is displayed");
    }


}
