import static io.appium.java_client.touch.TapOptions.tapOptions;

import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class HomePage {
    private Appium appium = new Appium();

    public HomePage() {

    }

    /*private WebElement myAccount() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("//android.view.ViewGroup/android.view.View/android.view.View[5]",7000);
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Till Mitt konto')]",7000);
        return mycAccountElement;
    }*/

    private WebElement myAccount2() throws InterruptedException {
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[4]",7000);
        return mycAccountElement;
    }

    private WebElement deliveriesPage() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Leveranser')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[2]",7000);
        return mycAccountElement;
    }

   /*public void clickMyAccount() throws InterruptedException {
        int x = myAccount().getLocation().getX();
        int y = myAccount().getLocation().getY();

        System.out.println("X:" + x  + " Y: "+y);
        //Action action = new Actions(appium.driver);
        //action.

        //TouchAction action = new TouchAction();
        //PointOption pointOption = PointOption.point(x ,y);
        //new TouchAction().press(pointOption).release();


        //TouchAction action = new TouchAction((PerformsTouchActions) appium.driver)
        //        .tap(tapOptions().withElement(element(appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000))));
                //.waitAction(waitOptions(ofSeconds(2)))
                //.tap(tapOptions().withElement(element(driver.findElementById("io.appium.android.apis:id/stop"))));
        //action.perform();

        Thread.sleep(7000);

        System.out.println("Enabled 1: " + myAccount().isEnabled());

        TouchAction action = new TouchAction((PerformsTouchActions) appium.driver)
                .tap(tapOptions().withPosition(PointOption.point(x, y)));
        //.waitAction(waitOptions(ofSeconds(2)))
        //.tap(tapOptions().withElement(element(driver.findElementById("io.appium.android.apis:id/stop"))));
        action.perform();

        //TouchAction(appium.driver).tap(AndroidElement).release().perform();


        myAccount().isEnabled();
        System.out.println("Enabled 2: " + myAccount().isEnabled());

        myAccount().click();
    }*/

    public void clickMyAccount2() throws InterruptedException {
        myAccount2().click();
    }

    public void clickDeliveries() throws InterruptedException {
        deliveriesPage().click();
    }
}
