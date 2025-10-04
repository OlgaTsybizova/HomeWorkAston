package lesson10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentModalWindow {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'pay-description__text']/span")
    WebElement infoTypePayAndPhoneField;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__cost')]/span")
    WebElement infoSumField;

    @FindBy(xpath = "//label[contains(text(),'Номер карты')]")
    WebElement cardNumberField;

    @FindBy(xpath = "//label[contains(text(),'Срок действия')]")
    WebElement cardExp;

    @FindBy(xpath = "//label[contains(text(),'CVC')]")
    WebElement cardCVC;

    @FindBy(xpath = "//label[contains(text(),'Имя')]")
    WebElement cardName;

    @FindBy(xpath = "//button/span[contains(text(), 'Оплатить')]")
    WebElement buttonSubmitPay;

    //Навания платежных систем
    @FindBys({
            @FindBy(how = How.XPATH, using = "//div[contains(@class, 'cards-brands')]/descendant::img")
    })
    private List<WebElement> paySystemLogoModal;

    public PaymentModalWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getPaySystemLogoModal() {
        return paySystemLogoModal;
    }

    public WebElement getInfoTypePayAndPhoneField() {
        return infoTypePayAndPhoneField;
    }

    public WebElement getInfoSumField() {
        return infoSumField;
    }

    public WebElement getCardNumberField() {
        return cardNumberField;
    }

    public WebElement getCardExp() {
        return cardExp;
    }

    public WebElement getCardCVC() {
        return cardCVC;
    }

    public WebElement getCardName() {
        return cardName;
    }

    public WebElement getButtonSubmitPay() {
        return buttonSubmitPay;
    }

}
