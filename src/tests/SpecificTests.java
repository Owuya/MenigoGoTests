import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.Calendar;

public class SpecificTests extends Appium {
    private static final LoginPage loginPage = new LoginPage();
    private static final HomePage homePage = new HomePage();
    private static final FavouriteListPage favourtiteListPage = new FavouriteListPage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    //private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();
    //private static final DeliveriesPage deliveriesPage = new DeliveriesPage();
    //private static final QuickOrderPage quickOrderPage = new QuickOrderPage();
    //private static final StockCountPage stockCountPage = new StockCountPage();
    //private static final AddCustomerPage addCustomerPage = new AddCustomerPage();
    //private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();
    //private static final CustomerPage customerPage = new CustomerPage();

    @BeforeSuite
    public void start() {
        System.out.println("Time started: " + Calendar.getInstance().getTime());
        Appium.setAppPackage("com.menigo.menigogobeta");
    }

    @Test(description = "Loggar in med en kund och klickar förbi onboarding", priority = 1)
    public void LoginAndOnboarding() throws InterruptedException {
        loginPage.Login("552800", "AMM800");
        WaitForContent(7000);
        //loginPage.Onboarding();
    }

    @Test(description = "Laddar favoritlistor och lägger till en produkt i listan App Regression", priority = 2)
    public void AddToFavoriteList() throws InterruptedException {
        WaitForContent(7000);
        favourtiteListPage.enterPage();
        WaitForContent(3000);
        favourtiteListPage.enterListPage();

        favourtiteListPage.addProduct();
        favourtiteListPage.checkAdded();
    }


   /* @Test(description = "Logout customer 444867 from customer page", priority = 10)
    public void LogoutACustomerFromCustomerPage() throws InterruptedException {

        stockCountPage.clickMyAccount();
        myAccountPage.clickOnCustomer();
        customerPage.clickLogout();
        customerPage.clickLogoutButton();
    }

    @Test(description = "Logout customer 570431 from the list on My account page", priority = 11)
    public void LogoutACustomerFromMyAccountPage() throws InterruptedException {
        myAccountPage.logoutSpecificCustomer("570431");
    }*/

    @Test(description = "Logout all customers", priority = 12)
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
