import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;

public class ShelfLabelPage {
    private Appium appium = new Appium();
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RESET = "\u001B[0m";
    public ShelfLabelPage() {

    }
    private WebElement searchFieldElement() throws InterruptedException {
        WebElement searchField = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@text,'Namn eller artikelnummer')]",6000);
        return searchField;
    }
    private WebElement scanButton() throws InterruptedException {
        //WebElement searchField = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@text,'Sök')]",6000);
        WebElement scanButton = appium.GetElementByXpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]",6000);
        return scanButton;
    }
    private WebElement searchResultElement() throws InterruptedException {
        WebElement searchResult = appium.GetElementByXpath("(//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'TouchableOpacitySearchResultItem')])[1]",6000);
        return searchResult;
    }
    private WebElement secondSearchResultElement() throws InterruptedException {
        WebElement searchResult = appium.GetElementByXpath("(//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'TouchableOpacitySearchResultItem')])[2]",6000);
        return searchResult;
    }
    private WebElement addButtonElement() throws InterruptedException {
        WebElement addButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LÄGG TILL')]",6000);
        return addButton;
    }
    private WebElement orderButtonElement() throws InterruptedException {
        //WebElement orderButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'BESTÄLL')]",8000);
        WebElement orderButton =  appium.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"BESTÄLL\"))"));

        return orderButton;
    }
    private WebElement emailFieldElement() throws InterruptedException {
        WebElement emailField = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')]",6000);
        return emailField;
    }
    private WebElement sendButtonElement() throws InterruptedException {
        WebElement sendButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'SKICKA BESTÄLLNING')]",6000);
        return sendButton;
    }

    private WebElement success() throws InterruptedException {
        WebElement successMessage = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Din order är skapad')]", 7000);
        return successMessage;
    }
    private WebElement makeNewOrderButtonElement() throws InterruptedException {
        WebElement makeNewOrderButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'SKAPA NY ORDER')]",6000);
        //WebElement makeNewOrderButton = appium.GetElementByXpath("//android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]",6000);
        return makeNewOrderButton;
    }
    private WebElement clearSearchButtonElement() throws InterruptedException {
        WebElement clearSearchButton = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'searchInputEmptySearch')]",6000);
        return clearSearchButton;
    }
    private WebElement myAccount() throws InterruptedException {
        //WebElement mycAccountElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Mitt konto')]",7000);
        WebElement mycAccountElement = appium.GetElementByXpath("(//android.view.View[@focusable='true'])[4]",7000);
        return mycAccountElement;
    }



    public void Search(String criteria) throws InterruptedException {
        searchFieldElement().sendKeys(criteria);
        System.out.println("Search criteria entered: " + criteria);
    }

    public void Scan() throws InterruptedException {
        scanButton().click();
        //System.out.println("Scanned code: " + searchFieldElement().getText());
    }
    public void SearchResultClick() throws InterruptedException {
        searchResultElement().click();
    }
    public void ClearSearchResult() throws InterruptedException {
        clearSearchButtonElement().click();
    }
    public void SecondSearchResultClick() throws InterruptedException {
        secondSearchResultElement().click();
    }
    public void AddButtonClick() throws InterruptedException {
        addButtonElement().click();
    }
    public void OrderButtonClick() throws InterruptedException {
        appium.WaitForContent(7000);
        orderButtonElement().click();
    }
    public void Email(String email) throws InterruptedException {
        emailFieldElement().click();
        emailFieldElement().clear();
        emailFieldElement().sendKeys(email);
    }
    public void SendOrderClick() throws InterruptedException {
        sendButtonElement().click();
    }
    public void CheckSuccess() throws InterruptedException {
        if (success().isDisplayed()) {
            System.out.println(ANSI_GREEN + "Hyllkant success! :)"+ ANSI_RESET);
        }
        else {
            System.out.println("Hyllkant not success, Check error message :(");
        }
    }
    public void MakeNewOrderButtonClick() throws InterruptedException {
        makeNewOrderButtonElement().click();
    }
    public void clickMyAccount() throws InterruptedException {
        myAccount().click();
    }
}
