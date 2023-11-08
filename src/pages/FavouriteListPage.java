import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FavouriteListPage {
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RESET = "\u001B[0m";

    private Appium appium = new Appium();

    public FavouriteListPage() {
        PageFactory.initElements(new AppiumFieldDecorator(appium.driver),this);
    }

    private WebElement enterPageElement() throws InterruptedException {
        WebElement heartIcon = appium.GetElementByXpath("(//android.view.ViewGroup[@focusable='true'])[1]",7000);
        return heartIcon;
    }

    private WebElement enterListElement() throws InterruptedException {
        WebElement listElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'App Regression')]",7000);
        return listElement;
    }

    private WebElement addProductElement() throws InterruptedException {
        WebElement addProductElement = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till')])[1]",7000);
        return addProductElement;
    }

    private WebElement openProductModalElement() throws InterruptedException {
        WebElement productModal = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till')])[1]",7000);
        return productModal;
    }

    private WebElement addButtonElement() throws InterruptedException {
        WebElement addButtonElement = appium.GetElementByXpath("(//*[contains(@class,'android.widget.TextView')][contains(@text,'Lägg till')])[1]",7000);
        return addButtonElement;
    }

    private WebElement checkContentLoaded() throws InterruptedException {
        WebElement checkContentElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'Banan EKO')]", 7000);
        return checkContentElement;
    }

    private WebElement checkAddedElement() throws InterruptedException {
        WebElement checkAddedElement = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'iKaffe 3%')]",7000);
        return checkAddedElement;
    }

    public void enterPage() throws InterruptedException {
        enterPageElement().click();
    }

    public void enterListPage() throws InterruptedException {
        enterListElement().click();
    }

    public void addProduct() throws InterruptedException {
        addProductElement().click();
        openProductModalElement().click();
        addButtonElement().click();
        checkAddedElement().click();
    }

    public void checkAdded() {

    }

    public void checkLoadSuccess() throws InterruptedException {
        if (checkContentLoaded().isDisplayed()) {
            System.out.println(ANSI_GREEN + "Favorite list items is loaded! :)"+ ANSI_RESET);
        }
        else {
            System.out.println("Favorite list items not loaded, Check if error message :(");
        }
    }
}
