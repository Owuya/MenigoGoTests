import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CustomerPage {

    private Appium appium = new Appium();

    public CustomerPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appium.driver),this);
    }

    WebElement logoutButton1Element() throws InterruptedException {
        WebElement logoutButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT KUNDNUMMER')]", 7000);
        ////android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]
        return logoutButton;
    }

    WebElement logoutButton2Element() throws InterruptedException {
        WebElement logoutButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LOGGA UT KONTO')]", 7000);
        return logoutButton;
    }

    public void clickLogout() throws InterruptedException {
        logoutButton1Element().click();
    }

    public void clickLogoutButton() throws InterruptedException {
        logoutButton2Element().click();
    }
}
