package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String endDate) {
        BrowserUtils.waitFor(1);
        accountActivityPage.fromDate.clear();
        accountActivityPage.fromDate.sendKeys(startDate);
        BrowserUtils.waitFor(1);

        accountActivityPage.toDate.clear();
        accountActivityPage.toDate.sendKeys(endDate);
        BrowserUtils.waitFor(1);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findBTN.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromD, String toD) throws ParseException {
        //List<String> foundDatesStr = BrowserUtils.getElementsText(accountActivityPage.foundTransactionsDates);

        BrowserUtils.waitForVisibility(accountActivityPage.transactionTable,5);
        Assert.assertTrue("Verify the dates on the table are between the input 2 dates",
                isDateBetween(fromD,toD,accountActivityPage.foundTransactionsDates));
        //System.out.println("Dates on the table are between the input 2 dates");
    }

    public boolean isDateBetween(String fromD, String toD, List<WebElement> foundDates) throws ParseException {

        boolean isBetween = true;
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromD);
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toD);
/*        System.out.println("-----");
        System.out.println("fromD = " + fromD);
        System.out.println("fromDate :" + fromDate);
        System.out.println("toD = " + toD);
        System.out.println("toDate   :" + toDate);*/
        for (WebElement each : foundDates){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(each.getText());
/*            System.out.println("date: " + date);
            System.out.println("date.compareTo(fromDate) --> " + date.compareTo(fromDate));
            System.out.println("date.compareTo(toDate)   --> " + date.compareTo(toDate));*/
            if (date.before(fromDate) && date.after(toDate)) {
                isBetween = false;
            }
/*          //same function with .before&.after
            if (date.compareTo(fromDate) < 0 && date.compareTo(toDate) > 0){
                isbetween = false;
            }*/
        }
        //System.out.println("-----");
        return isBetween;
    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() throws ParseException {
        BrowserUtils.waitForVisibility(accountActivityPage.transactionTable,5);
        Assert.assertTrue("Verify the dates on the table are sorted DESC",
                isDateSortedDecs(accountActivityPage.foundTransactionsDates));
        System.out.println("Dates on the table are sorted DESC");
    }

    public boolean isDateSortedDecs(List<WebElement> foundDates) throws ParseException {

        boolean isSortedDesc = true;
        //System.out.println("-----");
        if (foundDates.size()>1) {
            for (int i=0;i<foundDates.size()-1;i++) {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(foundDates.get(i).getText());
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(foundDates.get(i+1).getText());
                if (date1.before(date2)) {
                    isSortedDesc = false;
                }
            }
        }
        //System.out.println("-----");
        return isSortedDesc;
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) throws ParseException {
        BrowserUtils.waitForVisibility(accountActivityPage.transactionTable,5);
        Assert.assertFalse("Verify the date is NOT on the table",
                isDateOnTheTable(date,accountActivityPage.foundTransactionsDates));
        System.out.println("The Date "+date+", is NOT on the table");
    }

    private boolean isDateOnTheTable(String date, List<WebElement> foundDates) throws ParseException {

        boolean isOnTheTable = false;
        Date isDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        System.out.println("-----");
        System.out.println("isDate = " + isDate);
        for (WebElement each : foundDates){
            Date eachDate = new SimpleDateFormat("yyyy-MM-dd").parse(each.getText());
            if (eachDate.equals(isDate)) {
                isOnTheTable = true;
                break;
            }
        }
        System.out.println("-----");
        return isOnTheTable;
    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String description) {
        accountActivityPage.findDescription.clear();
        accountActivityPage.findDescription.sendKeys(description);
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String description) {

        for (WebElement element: accountActivityPage.foundDescriptions) {
            Assert.assertTrue("verify the results table should include \""+description+"\"",
                    description.contains(element.getText()));
        }
        System.out.println("the results table only show descriptions containing \""+description+"\"");
    }
}
