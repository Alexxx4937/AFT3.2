package Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

         WebDriver driver;


        BasePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }
    double parsePrice(WebElement price) {

            return Double.parseDouble(price.getText().replaceAll("\\D","").trim());
    }

}
