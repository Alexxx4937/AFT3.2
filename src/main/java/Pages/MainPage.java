package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {


    @FindBy(xpath = "//input[@class='ui-input-search__input main-search-form__input ui-autocomplete-input']")
    WebElement searchProduct;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text){

        searchProduct.clear();
        searchProduct.sendKeys(text+"\n");
    }
}
