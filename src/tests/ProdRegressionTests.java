import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Calendar;

public class ProdRegressionTests extends Appium {

    private static final LoginPage loginPage = new LoginPage();
    //private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    private static final DeliveriesPage deliveriesPage = new DeliveriesPage();
    private static final QuickOrderPage quickOrderPage = new QuickOrderPage();
    private static final StockCountPage stockCountPage = new StockCountPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();
    private static final CustomerPage customerPage = new CustomerPage();

    @BeforeSuite
    public void Start(){
        System.out.println("Time started: " + Calendar.getInstance().getTime());
        Appium.setAppPackage("com.menigo.menigogo");
    }

    @Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("664901", "664901");
        WaitForContent(7000);
        //loginPage.Onboarding();
    }
    @Test(description = "Navigera till alla sidor", priority = 2)
    public void NavigateBottomNavThroughPages() throws InterruptedException {
        //Thread.sleep(3000);
        //homePage.clickDeliveries();
        //WaitForContent(7000);
        //deliveriesPage.clickQuickOrder();
        //WaitForContent(7000);
        ////quickOrderPage.clickStockCount();
        ////WaitForContent(7000);
        //stockCountPage.clickMyAccount();
        //WaitForContent(4000);

        homePage.clickDeliveries();
        WaitForContent(7000);
        //deliveriesPage.clickQuickOrder();
        //WaitForContent(3000);
        //quickOrderPage.closeKeyboardToContinue();
        //WaitForContent(7000);
        deliveriesPage.clickStockCount();
        WaitForContent(7000);
        stockCountPage.clickMyAccount();
        WaitForContent(4000);
    }

    @Test(description = "Loggar in med en masterkund och loggar sedan in med alla Subkunder", priority = 3)
    public void LoginWithMasterAndSubCustomers() throws InterruptedException {

        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("609988", "Niklas1");
        System.out.println("Logged in with 609988");
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("609977", "Niklas1");
        System.out.println("Logged in with 609977");
        WaitForContent(7000);
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("552800", "AMM800");
        System.out.println("Logged in with 552800");
        WaitForContent(3000);
    }

    @Test(description = "Som en SVH kund 570431, beställer shelflabel", priority = 4)
    public void OrderOneShelflable() throws InterruptedException {

        myAccountPage.ClickShelflableMenu();
        shelflablePage.Search("Läkerol");
        //shelflablePage.Scan();
        //Thread.sleep(10000);
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        WaitForContent(3000);
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Beställ en Hyllkantsetikett med olika sätt: Barcode, Helt namn, etc - 570431", priority = 5)
    public void OrderMoreShelflables() throws InterruptedException {

        shelflablePage.MakeNewOrderButtonClick();
        //shelflablePage.ClearSearchResult();

        shelflablePage.Search("Standardmjölk");
        shelflablePage.SecondSearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("123456");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Nocco BCAA+ Äpple BRK");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Standardmjölk");
        shelflablePage.SecondSearchResultClick();

        //shelflablePage.Search("Ahlgrens bilar");
        //shelflablePage.SearchResultClick();
        //shelflablePage.AddButtonClick();

        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    /*@Test(description = "Login with another SVH customer and select account to order Shelflabel with", priority = 6)
    public void LoginAndOrderShelflabel() throws InterruptedException {
        WaitForContent(3000);
        shelflablePage.clickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("570592", "570592");
        System.out.println("Waiting for login action: 7000 milliseconds");
        WaitForContent(7000);
        System.out.println("Logged in with 570592");
        myAccountPage.ClickShelflableMenuAfterLogin();
        myAccountPage.ClickSelectCustomer();
        shelflablePage.Search("Risgröt");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }*/

    //----------------------------  Inventory test cases  -------------------------------//

    /*@Test(description = "Navigerar till Inventering och tar bort en produkt", priority = 7)
    public void NavigateToInventoryAndRemoveProduct() throws InterruptedException {

        shelflablePage.clickMyAccount();
        myAccountPage.clickStockCountPage();
        stockCountPage.clickOnCustomer();
        stockCountPage.clickOnPantry();
        WaitForContent(3000);
        stockCountPage.openProductModal();
        stockCountPage.removeProduct();
        WaitForContent(4000);
        //stockCountPage.checkRemovedStatus();
    }
    @Test(description = "Lägger till en produkt", priority = 8)
    public void AddProductToPantry() throws InterruptedException {

        stockCountPage.search("111910");
        stockCountPage.openProductModal();
        stockCountPage.clickAddProduct();
        WaitForContent(4000);
        stockCountPage.checkAddedStatus();
    }*/

    //----------------------------  Logout test cases  -------------------------------//
    /*@Test(description = "Logout customer 444867 from customer page", priority = 9)
    public void LogoutACustomerFromCustomerPage() throws InterruptedException {

        stockCountPage.clickMyAccount();
        myAccountPage.clickOnCustomer();
        customerPage.clickLogout();
        customerPage.clickLogoutButton();
    }*/

    @Test(description = "Logout customer 570431 from the list on My account page", priority = 10)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {
        shelflablePage.clickMyAccount();
        myAccountPage.logoutSpecificCustomer("609988");
    }

    @Test(description = "Logout all customers", priority = 11)
    public void LogoutAllCustomers() throws InterruptedException {
        shelflablePage.clickMyAccount();
        myAccountPage.logout();
    }

    @AfterTest
    public void Done() {
        System.out.println("Time Done: " + Calendar.getInstance().getTime());
    }
}
