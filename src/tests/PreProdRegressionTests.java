import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.Calendar;

public class PreProdRegressionTests extends Appium {

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
    private static final FavouriteListPage favourtiteListPage = new FavouriteListPage();

    @BeforeSuite
    public void Start() {
        System.out.println("Time started: " + Calendar.getInstance().getTime());
        Appium.setAppPackage("com.menigo.menigogobeta");
    }

    @Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("325942", "Menigo123");
        WaitForContent(7000);
        //loginPage.Onboarding();
    }
    @Test(description = "Navigera till alla sidor", priority = 2)
    public void NavigateBottomNavThroughPages() throws InterruptedException {
        homePage.clickDeliveries();
        WaitForContent(7000);
        deliveriesPage.clickStockCount();
        WaitForContent(7000);
        stockCountPage.clickMyAccount();
        WaitForContent(4000);
    }

    @Test(description = "Som en SVH kund 570431, beställer shelflabel", priority = 3)
    public void OrderOneShelflable() throws InterruptedException {

        myAccountPage.ClickShelflableMenu();
        shelflablePage.Search("Läkerol");
        //shelflablePage.Scan();
        //WaitForContent(10000);
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        WaitForContent(3000);
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Beställ en Hyllkantsetikett med olika sätt: Barcode, Helt namn, etc - 570431", priority = 4)
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

        shelflablePage.Search("Ahlgrens bilar");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    @Test(description = "Loggar in med en masterkund och loggar sedan in med alla Subkunder", priority = 5)
    public void LoginWithMasterAndSubCustomers() throws InterruptedException {

        shelflablePage.clickMyAccount();
        myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("444867", "444867");
        System.out.println("Logged in with 444867");
        /*myAccountPage.ClickAddCustomerNumberMenu();
        addCustomerPage.Login("570431", "570431");
        System.out.println("Logged in with 570431");
        WaitForContent(7000);*/
        myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("404320", "404320");
        System.out.println("Logged in with 404320");
        WaitForContent(7000);
        /*myAccountPage.ClickAddCustomerNumberMenu2();
        addCustomerPage.Login("434477", "434477");
        System.out.println("Logged in with 434477");
        WaitForContent(3000);*/
    }

    @Test(description = "Login with another SVH customer and select account to order Shelflabel with", priority = 6)
    public void LoginAndOrderShelflabel() throws InterruptedException {
        WaitForContent(3000);
        //shelflablePage.clickMyAccount();
        //myAccountPage.ClickAddCustomerNumberMenu2();
        ///addCustomerPage.Login("570592", "570592");
        //System.out.println("Waiting for login action: 7000 milliseconds");
        //WaitForContent(7000);
        //System.out.println("Logged in with 570592");
        myAccountPage.ClickShelflableMenuAfterLogin();
        myAccountPage.ClickSelectCustomer();
        shelflablePage.Search("Risgröt");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("marcus.johansson@menigo.se");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }

    //----------------------------  Inventory test cases  -------------------------------//

    @Test(description = "Navigerar till Inventering och tar bort en produkt", priority = 7)
    public void NavigateToInventoryAndRemoveProduct() throws InterruptedException {

        shelflablePage.clickMyAccount();
        myAccountPage.clickStockCountPage();
        WaitForContent(4000);
        stockCountPage.clickOnCustomer();
        stockCountPage.clickOnPantry();
        WaitForContent(25000);
        stockCountPage.openProductModal();
        stockCountPage.removeProduct();
        WaitForContent(7000);
        //stockCountPage.checkRemovedStatus();
    }
    @Test(description = "Lägger till en produkt i ett skafferi", priority = 8)
    public void AddProductToPantry() throws InterruptedException {

        stockCountPage.clickAndenterArticleSearch();
        WaitForContent(2000);
        stockCountPage.searchCriteria("111910");
        stockCountPage.openProductModal();
        stockCountPage.clickAddProduct();
        WaitForContent(6000);
        //stockCountPage.checkAddedStatus();
    }

    @Test(description = "SNabborder - Lägger till en produkt i varukorgen", priority = 9)
    public void QuickorderAddProductToCart() throws InterruptedException, AWTException {

        stockCountPage.clickQuickOrder();
        WaitForContent(4000);
        quickOrderPage.closeKeyboardToContinue();
        //WaitForContent(4000);
        quickOrderPage.clickAddButton();
        WaitForContent(2000);
    }

    @Test(description = "Laddar favoritlistor och lägger till en produkt i listan App Regression", priority = 10)
    public void AddToFavoriteList() throws InterruptedException {
        quickOrderPage.ClickBackToHome();

        favourtiteListPage.enterPage();
        WaitForContent(3000);
        favourtiteListPage.enterListPage();

        favourtiteListPage.addProduct();
        favourtiteListPage.checkAdded();
    }
    

    //----------------------------  Logout test cases  -------------------------------//
    @Test(description = "Logout customer 444867 from customer page", priority = 11)
    public void LogoutACustomerFromCustomerPage() throws InterruptedException {

        stockCountPage.clickMyAccount();
        myAccountPage.clickOnCustomer();
        customerPage.clickLogout();
        customerPage.clickLogoutButton();
    }

    @Test(description = "Logout customer 570431 from the list on My account page", priority = 12)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {
        myAccountPage.logoutSpecificCustomer("404320");
    }

    @Test(description = "Logout all customers", priority = 13)
    public void LogoutAllCustomers() throws InterruptedException {
        //homePage.clickMyAccount();
        myAccountPage.logout();
    }

    @AfterTest
    public void Done() {
        System.out.println("Time Done: " + Calendar.getInstance().getTime());
    }
}
