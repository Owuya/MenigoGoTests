import org.openqa.selenium.WebElement;

public class AddCustomerPage {

    private Appium appium = new Appium();

    public AddCustomerPage() {

    }
    private WebElement addCustomerNumber() throws InterruptedException {
        //WebElement addCustomerNumber = appium.GetElementByXpath("(//*[contains(@class,'android.widget.EditText')])[1]",6000);
        WebElement addCustomerNumber = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@resource-id,'LoginFormUsernameInput')]",6000);
        return addCustomerNumber;
    }
    private WebElement addCustomerPassword() throws InterruptedException {
        //WebElement addCustomerPassword = appium.GetElementByXpath("(//*[contains(@class,'android.widget.EditText')])[2]",6000);
        WebElement addCustomerPassword = appium.GetElementByXpath("//*[contains(@class,'android.widget.EditText')][contains(@resource-id,'LoginFormPasswordInput')]",6000);
        return addCustomerPassword;
    }
    private void EnterUsername(String password) throws InterruptedException {
        addCustomerNumber().sendKeys(password);
    }
    private void EnterPassword(String password) throws InterruptedException {
        addCustomerPassword().sendKeys(password);
    }
    private WebElement addButton() throws InterruptedException {
        //WebElement addButton = appium.GetElementByXpath("//*[contains(@class,'android.widget.TextView')][contains(@text,'LÄGG TILL')]",5000);
        WebElement addButton = appium.GetElementByXpath("//*[contains(@class,'android.view.ViewGroup')][contains(@resource-id,'LoginFormSubmitButton')]", 5000);
        return addButton;
    }
    private void ClickAdd() throws InterruptedException {
        addButton().click();
    }

    public void Login(String username, String password) throws InterruptedException {
        EnterUsername(username);
        EnterPassword(password);
        ClickAdd();
    }






}
