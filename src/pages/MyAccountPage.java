import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.interactions.touch.TouchActions;

public class MyAccountPage {

    private Appium appium = new Appium();

    public MyAccountPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appium.driver),this);
    }
    private WebElement addCustomerNumberElement() throws InterruptedException {
        WebElement addCustomerNumber = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till kundnummer')]",7000);

        return addCustomerNumber;
    }
    private WebElement addCustomerNumberElement2()  {
        WebElement addCustomerNumber2 =  appium.driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Lägg till kundnummer\"))"));
        return addCustomerNumber2;
    }
    WebElement shelflableElement() throws InterruptedException {
        WebElement shelflableElement =  appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Hyllkantsetiketter\"))"));
        return shelflableElement;
    }
    WebElement shelflableElementWithSleep() throws InterruptedException {
        Thread.sleep(7000);
        WebElement shelflableElementWithSleep =  appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Hyllkantsetiketter\"))"));
        return shelflableElementWithSleep;
    }

    WebElement selectCustomerForShelflabelElement() throws InterruptedException {
        WebElement selectCustomerElement = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Fortsätt med detta konto')])[2]", 7000);
        return selectCustomerElement;
    }
    WebElement logoutButtonElement()  {
        WebElement logoutButton = appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"ProfileLogoutButton\"))"));
        //appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT')]",7000);
        return logoutButton;
    }
    private WebElement logoutFromAppButtonElement() throws InterruptedException {
        //WebElement logoutFromAppButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT FRÅN APPEN')]",7000);
        WebElement logoutFromAppButton = appium.GetElementByXpath("//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]",7000);
        return logoutFromAppButton;
    }
    private WebElement customerLink() throws InterruptedException {
        //link to profile page - nr2 in list:
        //WebElement selectCustomerElement = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][@index='4']", 7000);
        //(//*[contains(@class,'android.widget.TextView')][@text='Se kontouppgifter'])[2]
        WebElement selectCustomerElement = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Se kontouppgifter')])[2]", 7000);
        return selectCustomerElement;
    }

    private WebElement stockCount() throws InterruptedException {
        WebElement stockCountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[3]",7000);
        return stockCountElement;
    }

    public void ClickAddCustomerNumberMenu() throws InterruptedException {
        addCustomerNumberElement().click();
    }
    public void ClickAddCustomerNumberMenu2() throws InterruptedException {
        addCustomerNumberElement2().click();
    }
    public void ClickShelflableMenu() throws InterruptedException {
        shelflableElement().click();
    }

    public void ClickShelflableMenuAfterLogin() throws InterruptedException {
        shelflableElementWithSleep().click();
    }

    public void ClickSelectCustomer() throws InterruptedException {
        selectCustomerForShelflabelElement().click();
    }

    public void clickOnCustomer() throws InterruptedException {
        customerLink().click();
    }

    public void clickStockCountPage() throws InterruptedException {
        stockCount().click();
    }



    /*public void ClickLogoutButton() throws InterruptedException {
        //logoutButtonElement().click();

        int x = logoutButtonElement().getLocation().getX();
        int y = logoutButtonElement().getLocation().getY();

        Thread.sleep(7000);

        TouchAction action = new TouchAction((PerformsTouchActions) appium.driver)
                .tap(tapOptions().withPosition(PointOption.point(x, y)));
        action.perform();
    }*/

    /*public void ClickLogoutFromAppButton() throws InterruptedException {
        logoutFromAppButtonElement().click();
    }*/

    /*public void logout() throws InterruptedException {
        //scrollToProfileLogoutButton();
        ClickLogoutButton();
        ClickLogoutFromAppButton();
    }*/

    public void logout() throws InterruptedException {
        logoutButtonElement();
        WebElement element = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'ProfileLogoutButton')]", 7000);
        element.click();
        //Thread.sleep(4000);
        logoutFromAppButtonElement().click();
        Thread.sleep(7000);
    }
    private WebElement logoutSpecificCustomerElement(String customerNr) throws InterruptedException {
        WebElement logoutSpecific = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'LogoutSingleContactButton_"+customerNr+"')]", 7000);
        return logoutSpecific;
    }

    public void logoutSpecificCustomer(String customerNr) throws InterruptedException {
        logoutButtonElement().click();
        appium.WaitForContent(3000);
        logoutSpecificCustomerElement(customerNr).click();
    }
}
