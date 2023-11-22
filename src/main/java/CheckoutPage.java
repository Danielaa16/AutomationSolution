import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {

    public WebElement shippingButton;
    public WebElement checkoutButton;
    public WebElement paymentButton;
    public WebElement btnCheckout;
    public WebDriverWait wait;
    public WebElement GuestText;
    public WebElement requiredLastName;
    public WebElement requiredFirstName;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);

    }


    @FindBy(xpath = "//a[text()='Food']")
    public WebElement foodMenu;

    @FindBy(css = " .product-info button")
    public WebElement addToCart;

    @FindBy(id = "city")
    public WebElement cityCart;

    @FindBy(id = "postcode")
    public WebElement postCode;

    @FindBy(id = "region_id")
    public WebElement cartRegion;

    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom button")
    public WebElement proceedToCheckout;

    @FindBy(id = "onepage-guest-register-button")
    public WebElement selectGuest;

    @FindBy(id = "billing:firstname")
    public WebElement firstname;

    @FindBy(id = "billing:lastname")
    public WebElement lastname;
    @FindBy(id = "billing:email")
    public WebElement billingEmail;

    @FindBy(id = "billing:street1")
    public WebElement billingAddress;
    @FindBy(id = "billing:city")
    public WebElement billingCity;

    @FindBy(id = "billing:region_id")
    public WebElement billingRegion;
    @FindBy(id = "billing:company")
    public WebElement billingCompany;

    @FindBy(id = "billing:postcode")
    public WebElement billingPostcode;

    @FindBy(id = "billing:telephone")
    public WebElement billingTelephone;

    @FindBy(css = ".sub-title")
    public WebElement subTitleElement;
    @FindBy(css = "#shipping-method-buttons-container span > span")
    public WebElement ShippingButton;

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }


    public void getFoodMenu() {
        foodMenu.click();

    }

    WebElement billingButton;


    public void clickAddtoCart() {
        foodMenu.click();
    }

    public void setCityCart() {
        cityCart.sendKeys("Alabama");
    }

    public void setPostCode() {
        postCode.sendKeys("12345");
    }

    public void setCartRegion() {
        cartRegion.sendKeys("Alabama");
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    public void clickGuest() {
        selectGuest.click();
    }

    public void setFirstname() {
        firstname.sendKeys("Test");
    }

    public void setLastname() {
        lastname.sendKeys("User");
    }


    public void setBillingCompany() {
    }

    public void setBillingEmail() {
        billingEmail.sendKeys("a@a.com");
    }

    public void setBillingAddress() {
        billingAddress.sendKeys("adresa de test");
    }

    public void setBillingCity() {
        billingCity.sendKeys("alabama test");
    }

    public void setBillingPostCode() {
        billingPostcode.sendKeys("12345");
    }

    public void setBillingTelephone() {
        billingTelephone.sendKeys("0123456789");
    }


    public void addItemToCart() {
        getFoodMenu();
        clickAddtoCart();
    }

    public void btnCheckout() {
        CheckoutPage click;
        click = null;
        click.btnCheckout();
    }

    public void cartInfo() {
        setCityCart();
        setPostCode();
        selectOption(cartRegion, "Alabama");
        clickProceedToCheckout();

    }

    public void checkoutMandatoryFields() {
        clickGuest();
        setFirstname();
        setLastname();
        setBillingCompany();
        setBillingEmail();
        setBillingAddress();
        setBillingCity();
        setCityCart();
        setPostCode();
        selectOption(cartRegion, "Alabama");
        clickProceedToCheckout();
        setBillingPostCode();
        setBillingTelephone();
    }

    public void checkoutContinueButton() {
        clickWhenReady(shippingButton);
        clickWhenReady(paymentButton);
        clickWhenReady(checkoutButton);

    }


    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        } catch (Exception e) {
            System.out.println("Element or text not visible or incorrect");
        }
        assertEquals(expectedText, locator.getText());
    }


    @FindBy(css = " x ")
    public WebElement getCartRegion;

    @FindBy(css = " y ")
    public WebElement UpdateQty;

    public void setAddToCart() {
        addToCart.click();
    }

    public void selectQtyBox() {
        cartRegion.clear();
        cartRegion.sendKeys("2");
    }


    public void updateQuantity() {
        UpdateQty.click();
    }

    public void setUpdateQty() {
        UpdateQty.click();
    }

    public void fillMandatoryFieldsExcept(WebElement fieldToSkip) {
        addItemToCart();
        cartInfo();
        clickGuest();
        checkoutMandatoryFields();
        fieldToSkip.clear();

        billingButton.click();

    }


}
