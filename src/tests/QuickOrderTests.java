import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.Calendar;

public class QuickOrderTests extends Appium {

    private static final LoginPage loginPage = new LoginPage();
    //private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    private static final HomePage homePage = new HomePage();
    //private static final DeliveriesPage deliveriesPage = new DeliveriesPage();
    private static final QuickOrderPage quickOrderPage = new QuickOrderPage();
    private static final StockCountPage stockCountPage = new StockCountPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    //private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    //private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();
    private static final CustomerPage customerPage = new CustomerPage();
    private static final FavouriteListPage favourtiteListPage = new FavouriteListPage();

    @BeforeSuite
    public void Start() {
        System.out.println("Time started: " + Calendar.getInstance().getTime());
        Appium.setAppPackage("com.menigo.menigogobeta");
    }

    /*@Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        WaitForContent(3000);
        loginPage.Login("552800", "AMM800");
        WaitForContent(7000);
    }*/

    @Test(description = "Snabborder - Söker på Nocco och Lägger till en i varukorgen", priority = 9)
    public void QuickorderAddProductToCart() throws InterruptedException, AWTException {

        stockCountPage.clickQuickOrder();
        WaitForContent(5000);

        quickOrderPage.Search("Nocco");
        WaitForContent(4000);
        quickOrderPage.clickOpenProductModal();
        WaitForContent(2000);
        quickOrderPage.clickAddButton();
        quickOrderPage.closeOpenProductModal();
        WaitForContent(5000);
    }

    @Test(description = "Snabborder - Scannar barcode och Lägger till en i varukorgen", priority = 10)
    public void QuickorderScanAndAddProductToCart() throws InterruptedException {

        quickOrderPage.ClickBackToHome();
        WaitForContent(1000);
        quickOrderPage.ScanProduct();
        WaitForContent(4000);
        quickOrderPage.ClickSearchResult();
        quickOrderPage.ClickSearchResult();
        WaitForContent(2000);
        quickOrderPage.clickActivateTextField(1);
        WaitForContent(3000);
        quickOrderPage.closeOpenProductModal();
    }

    @Test(description = "Laddar favoritlistor och lägger till en produkt i listan App Regression", priority = 11)
    public void AddToFavoriteList() throws InterruptedException {
        quickOrderPage.ClickBackToHome();
        /*favourtiteListPage.enterPage();
        WaitForContent(3000);
        favourtiteListPage.enterListPage();

        favourtiteListPage.addProduct();
        favourtiteListPage.checkAdded();*/
    }
    

    //----------------------------  Logout test cases  -------------------------------//
    @Test(description = "Logout customer 444867 from customer page", priority = 12)
    public void LogoutACustomerFromCustomerPage() throws InterruptedException {

        stockCountPage.clickMyAccount();
        myAccountPage.clickOnCustomer();
        customerPage.clickLogout();
        customerPage.clickLogoutButton();
    }

    @Test(description = "Logout customer 570431 from the list on My account page", priority = 13)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {
        myAccountPage.logoutSpecificCustomer("404320");
    }

    @Test(description = "Logout all customers", priority = 14)
    public void LogoutAllCustomers() throws InterruptedException {
        //homePage.clickMyAccount();
        WaitForContent(9000);
        myAccountPage.logout();
        WaitForContent(5000);
    }

    @AfterTest
    public void Done() {
        System.out.println("Time Done: " + Calendar.getInstance().getTime());
    }
}
