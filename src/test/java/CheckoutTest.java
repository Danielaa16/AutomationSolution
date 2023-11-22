// Generated by Selenium IDE

import org.junit.Test;
import org.junit.Before;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;
    private long millis;


    @Before
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void checkout(long expected) throws InterruptedException {
        checkoutPage.addItemToCart();
        checkoutPage.cartInfo();
        checkoutPage.clickGuest();
        checkoutPage.checkoutMandatoryFields();
        checkoutPage.checkoutContinueButton();
        checkoutPage.assertTextWhenReady(checkoutPage.subTitleElement, "THANK YOU FOR YOUR PURCHASE!");


    }

//        driver.findElement(By.cssSelector("#billing-buttons-container span > span")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.ShippingButton));
//        checkoutPage.clickShippingButton();
//        driver.findElement(By.cssSelector("#shipping-method-buttons-container span > span")).click();
//        sleep(3000);
//        driver.findElement(By.cssSelector("#payment-buttons-container span > span")).click();
//        sleep(3000);
//        driver.findElement(By.cssSelector(".btn-checkout")).click();

    {
        WebElement element = driver.findElement(By.cssSelector(".sub-title"));
    }


    @Test
    public void checkAsALoggedInUserTest() {


    }

    @Test
    public void checkoutWithUpdateQuantityTest() {

//        qty- scriu
//        update- dau click
//         2 locatori noi
//        update qty
    }

    @Test
    public void checkoutAsAGuestTest() {

        checkoutPage.addItemToCart();
        checkoutPage.cartInfo();
        checkoutPage.clickGuest();
        checkoutPage.addItemToCart();
        checkoutPage.checkoutMandatoryFields();
        checkoutPage.checkoutContinueButton();
        checkoutPage.assertTextWhenReady(checkoutPage.subTitleElement, "CHECKOUT AS A GUST OR REGISTER");
    }

    @Test
    public void checkoutWithUpdatedQuantityTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.firstname);
    }

    @Test
    public void checkLastNameMandatoryFieldTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.lastname);
        checkoutPage.assertTextWhenReady(checkoutPage.requiredLastName, "This is a required field.");
    }

    @Test
    public void checkFirstNameMandatoryFieldTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.firstname);
        checkoutPage.assertTextWhenReady(checkoutPage.requiredFirstName, "This is a required field.");
    }

    @Test
    public void checkoutAddressMandatoryFieldTest() {
        checkoutPage.fillMandatoryFieldsExcept(checkoutPage.billingAddress);
    }

}

