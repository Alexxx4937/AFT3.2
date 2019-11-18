package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[@class='current-price-value']")
    public WebElement priceProduct;
    @FindBy(xpath ="//select[@class='form-control select']" )
    WebElement additionalGuarantee;
    @FindBy(xpath = "//button[@class='btn btn-cart btn-lg']")
     WebElement buyProduct;
    @FindBy(xpath = "//div[@class='buttons']//span[@data-of='totalPrice']")
   public WebElement priceCart;
    @FindBy(xpath = "//div[@class='buttons']/a[@class='btn-cart-link']")
   WebElement goToCartButton;

    public double getPrice(WebElement price) {
        return parsePrice(price);
    }

    public void setSelectGuarantee(int i) throws InterruptedException {
        additionalGuarantee.click();
        Select select=new Select(additionalGuarantee);
        select.selectByValue(String.valueOf(i));
        Thread.sleep(1000);


    }


    public void buy() throws InterruptedException {
buyProduct.click();
        Thread.sleep(1000);
    }
    public  void goToCart(){
        goToCartButton.click();
    }

}
