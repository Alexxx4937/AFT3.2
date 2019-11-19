package Pages;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='radio radio_checked']//label[@class='radio__label'][contains(text(), '2 года')]")
    WebElement checkBoxElement;
@FindBy(xpath = "//div[@data-cart-product-id='64f8e2b2-cc3b-47f9-99c3-bebf9a5b5e59']")
public WebElement priceConsoleAddGurantee;
@FindBy(xpath = "//div[@data-cart-product-id=dc6d3117-f786-4223-ad8d-f3fc6d07b963']")
public WebElement priceGame;
@FindBy(xpath = "//div[@class='total-amount__info-block']//div[@class='item-price']")
public WebElement summPrice;
@FindBy(xpath = "//i[@class='count-buttons__icon-plus']")
public  WebElement addProduct;

    @FindBy(xpath = "//span[@class='pseudo-link' and text()='Вернуть удалённый товар']")
   public WebElement returnItem;

    public void checkWarranty() {
        assertFalse("Гарантия 2 года отсутствует", checkBoxElement.isSelected());
    }

    public double getTotalPrice(WebElement price) {
        return parsePrice(price);
    }

    public double getPrice(int i) {

        return parsePrice(driver.findElement(By.xpath("//div[@class='cart-list__products']/div[" + i + "]//div[@class='item-price']/span")));
    }

    public void checkTotalPrice(WebElement element,double checkprice){
        assertThat(getTotalPrice(element),equalTo(checkprice));
    }
    public void checkPrice(int i,double checkprice){
        assertThat(getPrice(i),equalTo(checkprice));
    }

    public void remove(int i) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='cart-list__products']/div[" + i + "]//button[@class='remove-button']")).click();
        Thread.sleep(1000);
    }

    public void checkAssert(double a,double b){
        assertThat(a, equalTo(b));
    }



    public boolean checkDeleteItem(int i) {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='cart-list__product']/div"));
        return elements.size() >= i;
    }

    public  void setAddProduct(WebElement element) throws InterruptedException {
    element.click();
        Thread.sleep(3000);
    }
}

