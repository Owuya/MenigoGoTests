import org.openqa.selenium.WebElement;

public class InventoryOnboardPage {// extends Appium {
    //private AppiumDriver driver;

    /*public InventoryOnboardPage(AppiumDriver driver) {
        this.driver = driver;
    }*/

    private Appium appium = new Appium();

    private WebElement closeOnboarding()  throws InterruptedException {
        WebElement closeButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Stäng')]", 5000);
        return closeButton;
    }

    private WebElement inventoryOnboardArrow1() throws InterruptedException {
        WebElement inventoryOnboardArrow = appium.GetElementById("00000000-0000-0216-ffff-ffff00000196",5000);
        return inventoryOnboardArrow;
    }

    private WebElement inventoryOnboardArrow2() throws InterruptedException{
        WebElement inventoryOnboardArrow = appium.GetElementById("00000000-0000-0216-ffff-ffff000002be",5000);
        return inventoryOnboardArrow;
    }

    private WebElement inventoryOnboardArrow3() throws InterruptedException{
        WebElement inventoryOnboardArrow = appium.GetElementById("00000000-0000-0216-ffff-ffff000002eb",5000);
        return inventoryOnboardArrow;
    }

    private WebElement inventoryOnboardLater() throws InterruptedException{
        WebElement inventoryOnboardLater = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'SENARE')]",5000);
        return inventoryOnboardLater;
    }

    private void ClickArrowButton1() throws InterruptedException{
        inventoryOnboardArrow1().click();
    }
    private void ClickArrowButton2() throws InterruptedException{
        inventoryOnboardArrow2().click();
    }
    private void ClickArrowButton3() throws InterruptedException{
        inventoryOnboardArrow3().click();
    }

    private void ClickLaterButton() throws InterruptedException{
        inventoryOnboardLater().click();
    }

    public void InventoryOnboarding() throws InterruptedException {
        ClickArrowButton1();
        //Thread.sleep(500);
        ClickArrowButton2();
        //Thread.sleep(500);
        ClickArrowButton3();
        //Thread.sleep(500);
        ClickLaterButton();
    }

    public void CloseInventoryOnboarding() throws InterruptedException {
        closeOnboarding().click();
    }
}
