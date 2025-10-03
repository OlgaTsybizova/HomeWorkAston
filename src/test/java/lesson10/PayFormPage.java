package lesson10;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PayFormPage {
    private WebDriver driver;
    //Окно cookie
    @FindBy(xpath = "//div[contains(@class, 'cookie__wrapper')]")
    private WebElement cookieWindow;

    //Кнопка "Отклонить" для Cookie
    @FindBy(xpath = "//div[@class='cookie__buttons']/button[contains(text(),'Отклонить')]")
    private WebElement cookieButton;

    //Форма
    @FindBy(xpath = "//div[@class = 'pay__wrapper']")
    private WebElement form;

    //Название формы
    @FindBy(xpath = "//h2[contains(normalize-space(text()),'Онлайн пополнение')]")
    private WebElement payFormName;

    //Навания платежных систем
    @FindBys({
            @FindBy(how = How.XPATH, using = "//div[contains(@class,'pay__partners')]/descendant::img")
    })
    private List<WebElement> paySystemLogo;

    //Ссылка "Подробнее о сервисе"
    @FindBy(xpath = "//a[contains(normalize-space(text()),'Подробнее о сервисе')]")
    private WebElement linkAboutServise;

    //Поле выбора варианта оплаты услуг
    @FindBy(xpath = "//select[@id='pay']")
    private WebElement dropDownSelectField;

    //Список вариантов оплаты услуг
    @FindBys({
            @FindBy(how = How.XPATH, using = "//select/option")
    })
    private List<WebElement> listTypePay;

    //Кнопка выбора варианта оплаты услуг
    @FindBy(xpath = "//button[@class = 'select__header']")
    private WebElement buttonSelect;

    //Поле для ввода №1
    @FindBy(xpath = "//form[@class = 'pay-form opened']/div[1]/input")
    private WebElement inputField1;

    //Поле для ввода №2
    @FindBy(xpath = "//form[@class = 'pay-form opened']/div[2]/input")
    private WebElement inputField2;

    //Поле для ввода №3
    @FindBy(xpath = "//form[@class = 'pay-form opened']/div[3]/input")
    private WebElement inputField3;

    //Код телефона
    @FindBy(xpath = "//label[@for='connection-phone']")
    WebElement infoPhoneCode;

    //Кнопка "Продолжить"
    @FindBy(xpath = "//form[contains(@class, 'pay-form opened')]/child::button[contains(text(),'Продолжить')]")
    private WebElement buttonPayForm;

    public PayFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickCookieButton(){
        if(cookieWindow.isDisplayed()){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieButtonReject = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieButtonReject.click();
        }
    }
    public void mouseMoveToElement(WebElement element){
        Actions mouse = new Actions(driver);
        mouse.moveToElement(element).click().perform();
    }
    public List<String> getPlaceHoldersForTypePay(WebElement typePay) {
        Actions mouse = new Actions(driver);
        mouse.moveToElement(form).click().perform();
        buttonSelect.click();
        mouse.moveToElement(typePay).click().perform();

        List<String> listPlaceholder = new ArrayList<>();
        listPlaceholder.add(inputField1.getAttribute("placeholder"));
        listPlaceholder.add(inputField2.getAttribute("placeholder"));
        listPlaceholder.add(inputField3.getAttribute("placeholder"));
        return listPlaceholder;
    }

    public void enterPhoneNumber(String phoneNumber) {
        inputField1.click();
        inputField1.sendKeys(phoneNumber);
    }

    public void enterSumPay(String sum) {
        inputField2.click();
        inputField2.sendKeys(sum);
    }

    public void enterEmail(String email) {
        inputField3.click();
        inputField3.sendKeys(email);
    }
    /*public int getCountWindow(){
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = 0;
        for(String handle: allWindowHandles){
           count++;
        }
        return count;
    }
    public void waitElementVisibility (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }*/

    public WebElement waitElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(element));
        return elementClick;
    }
    public PaymentModalWindow clickButtonPayForm(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement newElement = wait.until(ExpectedConditions.elementToBeClickable(buttonPayForm));
        newElement.click();
        return new PaymentModalWindow(driver);
    }

    public WebElement getPayFormName() {
        return payFormName;
    }

    public List<WebElement> getPaySystemLogo() {
        return paySystemLogo;
    }

    public WebElement getDropDownSelectField() {
        return dropDownSelectField;
    }

    /*public List<WebElement> getListTypePay() {
        return listTypePay;
    }*/

    public WebElement getLinkAboutServise() {
        return linkAboutServise;
    }

    public WebElement getInputField1(){
        return inputField1;
    }

    public WebElement getInputField2() {
        return inputField2;
    }

    public WebElement getInputField3() {
        return inputField3;
    }

    public WebElement getInfoPhoneCode() {
        return infoPhoneCode;
    }

    public WebElement getButtonPayForm() {
        return buttonPayForm;
    }
}

