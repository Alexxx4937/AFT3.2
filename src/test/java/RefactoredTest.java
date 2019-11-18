
import Pages.CartPage;
import Pages.MainPage;
import Pages.ProductPage;
import Pages.ResultPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RefactoredTest extends BaseTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"playstation", "PlayStation 4 Slim Black 1 TB", "Detroit"},
        });
    }

    @Parameterized.Parameter
    public String consoleName;

    @Parameterized.Parameter(1)
    public String consoleFullName;

    @Parameterized.Parameter(2)
    public String game;






    @Test

    public  void testDns() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        ResultPage resultPage=new ResultPage(driver);
        ProductPage productPage=new ProductPage(driver);
        CartPage cartPage=new CartPage(driver);

        mainPage.search(consoleName);
        resultPage.choiseProdukt(consoleFullName);
        double priceConsole=productPage.getPrice(productPage.priceProduct);


        productPage.setSelectGuarantee(2);
        double priceAddGuarantee=productPage.getPrice(productPage.priceProduct);

        productPage.buy();
        mainPage.search(game);
        double priceGame=productPage.getPrice(productPage.priceProduct);

        productPage.buy();
        double priceSummCart=productPage.getPrice(productPage.priceCart);

        assertThat(priceGame+priceAddGuarantee,equalTo(priceSummCart));
        productPage.goToCart();
        cartPage.checkWarranty();
        cartPage.checkPrice(1,priceConsole);
        cartPage.checkPrice(2,priceGame);
        cartPage.checkTotalPrice(cartPage.summPrice,priceSummCart);
        cartPage.remove(2);
        /*cartPage.checkRemove(2);*/
        cartPage.setAddProduct(cartPage.addProduct);
        cartPage.setAddProduct(cartPage.addProduct);
        cartPage.setAddProduct(cartPage.returnItem);









   }
}
