import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage {

    public WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);

    }

    @FindBy(xpath = "//a[text()='Food']")
    public WebElement foodMenu;


    @FindBy (linkText= "account")
    public WebElement account;

    public void getFoodMenu() {
        foodMenu.click();

    }

    // My account
    // Login
    // Email
    // Password
    // Send

    //link Text ="Login"



}
