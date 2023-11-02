import org.openqa.selenium.WebElement;

public class StockCountPage {

    private Appium appium = new Appium();

    public StockCountPage() {    }

    private WebElement myAccount() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[4]",7000);
        return mycAccountElement;
    }
    private WebElement SelectCustomer() throws InterruptedException {
        WebElement selectCustomerElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'FALU LASARETT BUTIKEN')]",7000);
        return selectCustomerElement;
    }
    private WebElement SelectPantry() throws InterruptedException {
        WebElement selectPantryElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'App Regression')]",7000);
        return selectPantryElement;
    }
    private WebElement clickProductModal() throws InterruptedException {
        WebElement productElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Aladdin')]",7000);
        return productElement;
    }
    private WebElement taBortInProductModal() throws InterruptedException {
        WebElement taBortInProductModalElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Ta bort')]",7000);
        return taBortInProductModalElement;
    }
    private WebElement taBortButton() throws InterruptedException {
        WebElement taBortButtonElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'TA BORT')]",7000);
        return taBortButtonElement;
    }
    private WebElement enterArticleSearch() throws InterruptedException {
        WebElement articleSearchElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@text,'Namn eller artikelnr')]",7000);
        return articleSearchElement;
    }
    private WebElement addSearchCriteria() throws InterruptedException {
        WebElement articleSearchElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')]",7000);
        return articleSearchElement;
    }
    private WebElement addButton() throws InterruptedException {
        WebElement addButtonElement = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'SubmittingStockCountButton')]",7000);
        return addButtonElement;
    }
    private WebElement removedNotification() throws InterruptedException {
        WebElement removedNotificationElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'borttaget')]",1000);
        return removedNotificationElement;
    }
    private WebElement addedNotification() throws InterruptedException {
        WebElement addedNotificationElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'har lagts till i skafferiet')]",7000);
        return addedNotificationElement;
    }
    private WebElement quickOrder() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Hem')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[1]",7000);
        return mycAccountElement;
    }

    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }
    public void clickOnCustomer() throws InterruptedException {
        SelectCustomer().click();
    }
    public void clickOnPantry() throws InterruptedException {
        SelectPantry().click();
    }
    public void openProductModal() throws InterruptedException {
        clickProductModal().click();
    }
    public void removeProduct() throws InterruptedException {
        taBortInProductModal().click();
        taBortButton().click();
    }
    public void clickAndenterArticleSearch() throws InterruptedException {
        enterArticleSearch().click();
    }
    public void searchCriteria(String criteria) throws InterruptedException {
        addSearchCriteria().sendKeys(criteria);
    }
    public void clickAddProduct() throws InterruptedException {
        addButton().click();
    }
    public void checkRemovedStatus() throws InterruptedException {
        if(removedNotification().getText().contains("borttaget")) {
            System.out.println("Snackbar visas, Aladdin borttaget");
            System.out.println("Snackbar text: " + removedNotification().getText());
        }
        else {
            System.out.println("Snackbar visas inte, Aladdin är inte borttaget");
        }
    }
    public void checkAddedStatus() throws InterruptedException {
        if(addedNotification().getText().contains("har lagts till i skafferiet")) {
            System.out.println("Snackbar visas, Aladdin tillagt i skafferi");
            System.out.println("Snackbar text: " + addedNotification().getText());
        }
        else {
            System.out.println("Snackbar visas inte, Aladdin är inte tillagt i skafferi");
        }
    }
    public void clickQuickOrder() throws InterruptedException {
        quickOrder().click();
    }
}
