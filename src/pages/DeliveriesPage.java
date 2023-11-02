import org.openqa.selenium.WebElement;

public class DeliveriesPage {
    private Appium appium = new Appium();

    public DeliveriesPage() {    }

    /*private WebElement quickOrder() throws InterruptedException {
        WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Snabborder')]",7000);
        return mycAccountElement;
    }*/
    private WebElement stockCount() throws InterruptedException {
        //WebElement stockCountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Inventering')]",7000);
        WebElement stockCountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[3]",7000);
        return stockCountElement;
    }
    private WebElement myAccount() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[4]",7000);
        return mycAccountElement;
    }

    /*(public void clickQuickOrder() throws InterruptedException {
        quickOrder().click();
    }*/
    public void clickStockCount() throws InterruptedException {
        stockCount().click();
    }
    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }
}
