import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;

public class StockCountTests extends Appium {

    private static final LoginPage loginPage = new LoginPage();
    //private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    private static final StockCountPage stockCountPage = new StockCountPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();
    private static final CustomerPage customerPage = new CustomerPage();

    @BeforeTest
    public void Start(){
        System.out.println("Time started: " + Calendar.getInstance().getTime());
    }

   /*,@Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        WaitForContent(7000);
        //loginPage.Onboarding();
    }


    @Test(description = "Loggar in med en masterkund", priority = 2)
    public void LoginWithMasterCustomer() throws InterruptedException {
        WaitForContent(3000);
        homePage.clickMyAccount2();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("444867", "444867");
        System.out.println("Logged in with 444867");
    }*/

   @Test(description = "Navigerar till Inventering och tar bort en produkt", priority = 3)
    public void NavigateToInventoryAndRemoveAndAddProduct() throws InterruptedException {
       myAccountPage.clickStockCountPage();
       stockCountPage.clickOnCustomer();
       stockCountPage.clickOnPantry();
       WaitForContent(3000);
       stockCountPage.openProductModal();
       stockCountPage.removeProduct();
       //WaitForContent(1000);
       //stockCountPage.checkRemovedStatus();
       WaitForContent(4000);
       //stockCountPage.checkRemovedStatus();
    }

    @Test(description = "Lägger till en produkt", priority = 4)
    public void AddProductToPantry() throws InterruptedException {

       stockCountPage.searchCriteria("111910");
       stockCountPage.openProductModal();
       stockCountPage.clickAddProduct();
       //stockCountPage.checkAddedStatus();
       WaitForContent(4000);
       stockCountPage.checkAddedStatus();

    }


    //----------------------------  Logout test case  -------------------------------//

    /*@Test(description = "Logout all customers", priority = 9)
    public void LogoutAllCustomers() throws InterruptedException {
        homePage.clickMyAccount2();
        myAccountPage.logout();
    }*/

    @AfterTest
    public void Done() {
        System.out.println("Time Done:    " + Calendar.getInstance().getTime());
    }
}
