package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//ul[@class=\"nav nav-tabs\"]/li")
    public List<WebElement> menuOptions;

    @FindBy(id = "searchTerm")
    public WebElement searchBox;

    @FindBy(xpath = ("(//a[@class='dropdown-toggle'])[1]"))
    public WebElement settingsBtn;

    @FindBy(xpath = ("(//a[@class='dropdown-toggle'])[2]"))
    public WebElement userMenu;

    @FindBy(xpath = "//a[contains(text(),'My Profile')]")
    public WebElement myProfile;

    @FindBy(id="logout_link")
    public  WebElement logOutBtn;




    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    */

    public void goToTab(String tabName){

        switch (tabName){
            case "Account Summary":
                menuOptions.get(0).click();
                break;
            case "Account Activity":
                menuOptions.get(1).click();
                break;

            case "Transfer Funds":
                menuOptions.get(2).click();
                break;

            case "Pay Bills":
                menuOptions.get(3).click();
                break;

            case "My Money Map":
                menuOptions.get(4).click();
                break;

            case "Online Statements":
                menuOptions.get(5).click();
                break;

        }

    }




    public String getUserName(){
        BrowserUtils.waitForVisibility(userMenu, 5);
        return userMenu.getText();
    }


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userMenu);
        BrowserUtils.clickWithJS(logOutBtn);
    }
    public void goToMyUser(){

        BrowserUtils.waitForClickablility(userMenu, 5).click();
        BrowserUtils.waitForClickablility(myProfile, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */


    /*
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }


    }

     */

}
