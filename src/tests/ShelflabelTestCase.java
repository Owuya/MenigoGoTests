import org.testng.annotations.Test;

public class ShelflabelTestCase extends Appium {
    private static final LoginPage loginPage = new LoginPage();
    private static final InventoryOnboardPage inventoryOnboardPage = new InventoryOnboardPage();

    private static final HomePage homePage = new HomePage();
    private static final MyAccountPage myAccountPage = new MyAccountPage();
    private static final ShelfLabelPage shelflablePage = new ShelfLabelPage();

    @Test(description = "Loggar in med en SVH kund och beställer shelflabel")
    public void LoginAndOrderOneShelfLabel() throws InterruptedException {
        //loginPage.Login("570431", "570431");
        //loginPage.Onboarding();
        //inventoryOnboardPage.CloseInventoryOnboarding();
        //homePage.ClickMyAccount();
        myAccountPage.ClickShelflableMenu();
        shelflablePage.Search("Läkerol");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        shelflablePage.OrderButtonClick();
        shelflablePage.Email("J10MarcusJ@gmail.com");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
        //OrderOneShelflable();
    }

    @Test(description = "Beställ en Hyllkantsetikett med eg.570431")
    public void OrderOneShelflable() throws InterruptedException {
        //myAccountPage.ClickShelflableMenu();
        shelflablePage.MakeNewOrderButtonClick();

        shelflablePage.Search("Mjölk");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        /*shelflablePage.Search("Mjölk");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();
        Thread.sleep(2000);*/
        shelflablePage.Search("123456");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Nocco BCAA+ Äpple BRK");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.Search("Ahlgrens bilar");
        shelflablePage.SearchResultClick();
        shelflablePage.AddButtonClick();

        shelflablePage.OrderButtonClick();
        shelflablePage.Email("J10MarcusJ@gmail.com");
        shelflablePage.SendOrderClick();
        shelflablePage.CheckSuccess();
    }
}
