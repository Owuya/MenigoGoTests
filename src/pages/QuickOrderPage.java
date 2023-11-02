import org.openqa.selenium.WebElement;

public class QuickOrderPage {

    private Appium appium = new Appium();

    public QuickOrderPage() {    }

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
    private WebElement activateSearchField() throws InterruptedException {
        WebElement activateSearchElement = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'QuickOrderSearchNavigator')]",7000);
        return activateSearchElement;
    }
    private WebElement enterSearchCriteria() throws InterruptedException {
        WebElement enterSearchCriteriaElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@resource-id,'quickorderSearchInput')]",7000);
        return enterSearchCriteriaElement;
    }
    private WebElement closeKeyboard() throws InterruptedException {
        //WebElement closeKeyboardElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'0')]",7000);
        //WebElement closeKeyboardElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'ART.NR 207322')]",7000);
        WebElement closeKeyboardElement = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'quickOrderSearchContainer')]",7000);
        return closeKeyboardElement;
    }
    private WebElement openProductModal() throws InterruptedException {
        WebElement enterProductModalElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Nocco Päron BRK')]",7000);
        return enterProductModalElement;
    }


    private WebElement addButton() throws InterruptedException {
        //WebElement addButtonElement = appium.GetElementByXpath("//android.view.ViewGroup[4]/android.view.ViewGroup[2]",7000);
        //WebElement addButtonElement = appium.GetElementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup",7000);
        //WebElement addButtonElement = appium.GetElementByXpath("//android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup",7000);
        WebElement addButtonElement = appium.GetElementByXpath("//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]",7000);
        return addButtonElement;
    }
    private WebElement closeProductModal() throws InterruptedException {
        WebElement enterProductModalElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.Button')][contains(@content-desc,'Stäng, back')]",7000);
        return enterProductModalElement;
    }


    public void clickOpenProductModal() throws InterruptedException {
        openProductModal().click();
    }

    public void closeOpenProductModal() throws InterruptedException {
        closeProductModal().click();
    }
    public void clickStockCount() throws InterruptedException {
        stockCount().click();
    }
    public void closeKeyboardToContinue() throws InterruptedException { //, AWTException {
        closeKeyboard().click();
    }
    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }

    public void clickAddButton() throws InterruptedException {
        addButton().click();
    }

    public void Search(String criteria) throws InterruptedException {
        activateSearchField().click();
        enterSearchCriteria().sendKeys(criteria);
    }

    private WebElement goBackToHome() throws InterruptedException {
        WebElement goBackToHomeElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.Button')][contains(@content-desc,'Go back')]",7000);
        return goBackToHomeElement;
    }
    private WebElement scanProductCode() throws InterruptedException {
        WebElement scanProductCodeElement = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'TestSwitchUserButton')]",7000);
        return scanProductCodeElement;
    }
    private WebElement searchResult() throws InterruptedException {
        WebElement searchResultElement = appium.GetElementByXpath("//*[contains(@resource-id,'quickOrderTestResult0')]",7000);
        return searchResultElement;
    }
    private WebElement frameElement() throws InterruptedException {
        WebElement element = appium.GetElementByXpath("//hierarchy/android.widget.FrameLayout",7000);
        return element;
    }

    private WebElement editText() throws InterruptedException {
        WebElement element = appium.GetElementByXpath("(//android.widget.EditText[@focusable='true'])[1]",7000);
        return element;
    }

    private WebElement closeAddKeyboard() throws InterruptedException {
        //WebElement element = appium.GetElementByXpath("//android.view.ViewGroup[2]/android.view.ViewGroup[6]",7000);
        WebElement element = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Stäng')])[2]",7000);
        return element;
    }

    public void ClickBackToHome() throws InterruptedException {
        goBackToHome().click();
    }

    public void ScanProduct() throws InterruptedException {
        scanProductCode().click();
    }

    public void ClickSearchResult() throws InterruptedException {
        searchResult().click();
    }
    public void clickActivateTextField(int amount) throws InterruptedException {
        //appium.driver.getScreenshotAs(OutputType.FILE);
        //appium.pressByCoordinates(538, 1769, 3000);
        //appium.pressByCoordinates(408, 1690, 3000);

        //Actions actions = new Actions(appium.driver);
        //actions.moveToElement(frameElement(), 538, 1769).click().build().perform();
        //WebElement element = driver.findElement();
        //actions.moveByOffset(x, y).click();
        //actions.perform();
        //driver.execute().
        String val = editText().getAttribute("text");
        System.out.println("Value in text field: " + val);
        int valInt = Integer.parseInt(val);

        int total = valInt + amount;
        System.out.println("New value: " + total);
        //editText().clear();
        editText().click();
        editText().clear();
        editText().sendKeys(Integer.toString(total));

        closeAddKeyboard().click();
    }
}