package lesson11;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lesson10.PaymentModalWindow;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tests {
    WebDriver driver;
    PayFormPage payFormPage;

    @BeforeAll
    public static void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }
   /* public static void setupFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
    }*/

    @BeforeEach
    public void createObjectChromeDriver(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        payFormPage = new PayFormPage(driver);
        payFormPage.clickCookieButton();
    }
    @AfterEach
    void quitSession(){
        driver.quit();
    }


    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка названия блока")
    @Description ("Тест проверяет соответсвует ли название блока указанному в спецификации")
    void testCheckBlockName(){
        payFormPage.mouseMoveToElement(payFormPage.getPayFormName());
        String actual = payFormPage.getPayFormName().getText();
        System.out.println(actual);
        String expected = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(actual, expected);
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка логотипов платежных систем")
    @Description("Тест проверяет наличие лошотипов платежных систем, указанных в спецификации")

    void testCheckLogoElements(){
        //Set<WebElement> listLogoPaySystem = payFormPage.getPaySystemLogo();
        List<String> actualListPaySystem = new ArrayList<String>();
        List<String> expectedListPaySystem = new ArrayList<>(Arrays.asList("Visa", "Verified By Visa","MasterCard","MasterCard Secure Code", "Белкарт"));
        for(WebElement l: payFormPage.getPaySystemLogo()){
            //System.out.println(l.getAttribute("alt"));
            payFormPage.mouseMoveToElement(l);
            actualListPaySystem.add(l.getAttribute( "alt"));
            Assert.assertTrue(l.isDisplayed());
        }
        Assert.assertEquals(actualListPaySystem, expectedListPaySystem);
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка работы ссылки 'Подробнее о сервисе'")
    @Description("Тест проверяет кликабельность ссылки и открытие окна с информацией после нажатия")
    void testCheckLinkAboutService() {
        String hrefValue = payFormPage.getLinkAboutServise().getAttribute("href");
        if (hrefValue != null && !hrefValue.isEmpty()) {
            (payFormPage.waitElementClickable(payFormPage.getLinkAboutServise())).click();
            String actualTitle = driver.getTitle();
            String expectedTitle = "Порядок оплаты и безопасность интернет платежей";
            Assert.assertEquals(actualTitle, expectedTitle);
        }
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка наличия плейсхолдеров в полях для типа платежа 'Услуги связи'")
    @Description("Тест проверяет наличие и содержание плейсхолдеров в каждом поле")
    void testCheckPlaceHoldersForDifType1(){
        WebElement value = driver.findElement(By.xpath("//p[contains(text(),'Услуги связи')]"));
        List<String> expectedPlaceholders =  List.of("Номер телефона","Сумма","E-mail для отправки чека");
        List<String> actualPlaceholders = payFormPage.getPlaceHoldersForTypePay(value);
        Assert.assertEquals(actualPlaceholders, expectedPlaceholders);
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка наличия плейсхолдеров в полях для типа платежа 'Домашний интернет'")
    @Description("Тест проверяет наличие и содержание плейсхолдеров в каждом поле")
    void testCheckPlaceHoldersForType2(){
        WebElement value = driver.findElement(By.xpath("//p[contains(text(),'Домашний интернет')]"));
        List<String> expectedPlaceholders =  List.of("Номер абонента","Сумма","E-mail для отправки чека");
        List<String> actualPlaceholders = payFormPage.getPlaceHoldersForTypePay(value);
        Assert.assertEquals(actualPlaceholders, expectedPlaceholders);
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка наличия плейсхолдеров в полях для типа платежа 'Рассрочка'")
    @Description("Тест проверяет наличие и содержание плейсхолдеров в каждом поле")
    void testCheckPlaceHoldersForType3(){
        WebElement value = driver.findElement(By.xpath("//p[contains(text(),'Рассрочка')]"));
        List<String> expectedPlaceholders =  List.of("Номер счета на 44","Сумма","E-mail для отправки чека");
        List<String> actualPlaceholders = payFormPage.getPlaceHoldersForTypePay(value);
        Assert.assertEquals(actualPlaceholders,expectedPlaceholders);
    }
    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка наличия плейсхолдеров в полях для типа платежа 'Задолженность'")
    @Description("Тест проверяет наличие и содержание плейсхолдеров в каждом поле")
    void testCheckPlaceHoldersForType4(){
        WebElement value = driver.findElement(By.xpath("//p[contains(text(),'Задолженность')]"));
        List<String> expectedPlaceholders = List.of("Номер счета на 2073","Сумма","E-mail для отправки чека");
        List<String> actualPlaceholders = payFormPage.getPlaceHoldersForTypePay(value);
        Assert.assertEquals(actualPlaceholders, expectedPlaceholders);
    }

    @Test
    @Story("Проверка блока 'Онлайн пополнение без комиссии'")
    @DisplayName ("Проверка возможности введения данных для 'Услуги связи'")
    @Description("Тест проверяет введение данных в поля блока, открытие окна оплаты после нажатия кнопки, " +
            "наличие плейсхолдеров в нем и корректность ранее введенных данных (сумма и номер телефона)")
    void testCheckPaymentForTypePay1(){
        String expVisaURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg";
        String expMastercardURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg";
        String expBelcardURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg";
        String expMirURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg";
        String expMaestroURL = "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg";
        List<String> expectedLogoPaySystem = new ArrayList<>();
        expectedLogoPaySystem.add(expVisaURL);
        expectedLogoPaySystem.add(expMastercardURL);
        expectedLogoPaySystem.add(expBelcardURL);
        expectedLogoPaySystem.add(expMirURL);
        expectedLogoPaySystem.add(expMaestroURL);


        String phoneNumber = "297777777";
        String [] code = (payFormPage.getInfoPhoneCode().getText()).split("\\+");
        String expectedPhoneNumber = code[1]+phoneNumber;
        String expectedSum = "100.00";
        String expectedMail = "mail@gmail.com";
        payFormPage.enterPhoneNumber(phoneNumber);
        payFormPage.enterSumPay(expectedSum);
        payFormPage.enterEmail(expectedMail);
        PaymentModalWindow paymentPage = payFormPage.clickButtonPayForm();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        //переход на новое окно (не получилось в этом случае)
        /*String mainWindowHandle = driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandle = driver.getWindowHandles();
        System.out.println(allWindowHandle);
        String newWindowHandle = null;
        for(String handle: allWindowHandle){
            if(!handle.equals(mainWindowHandle)){
                newWindowHandle = handle;
                driver.switchTo().window(newWindowHandle);
                break;
            }
        }*/

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait1.until(ExpectedConditions.visibilityOf(paymentPage.getInfoSumField()));

        String text = paymentPage.getInfoSumField().getText();
        String [] items = text.split(" ");

        String actualSum = items[0];
        System.out.println(actualSum);
        Assert.assertEquals(actualSum, expectedSum);

        text = paymentPage.getInfoTypePayAndPhoneField().getText();
        items = text.split(":");
        String actualPhoneNumber = items[2];
        System.out.println(actualPhoneNumber);
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);

        List<String> actualLogoPaySystem = new ArrayList<>();
        for (WebElement element: paymentPage.getPaySystemLogoModal()){
            actualLogoPaySystem.add(element.getAttribute("src"));
            //System.out.println(element.getAttribute("src"));
        }
        Collections.sort(actualLogoPaySystem);
        Collections.sort(expectedLogoPaySystem);
        Assert.assertEquals(actualLogoPaySystem, expectedLogoPaySystem);

        String actualPlaceholderCardNum = paymentPage.getCardNumberField().getText();
        System.out.println(actualPlaceholderCardNum);
        Assert.assertEquals(actualPlaceholderCardNum, "Номер карты");

        String actualPlaceholderCardExp = paymentPage.getCardExp().getText();
        System.out.println(actualPlaceholderCardExp);
        Assert.assertEquals(actualPlaceholderCardExp, "Срок действия");

        String actualPlaceholderCardCVC = paymentPage.getCardCVC().getText();
        System.out.println(actualPlaceholderCardCVC);
        Assert.assertEquals(actualPlaceholderCardCVC, "CVC");

        String actualPlaceholderCardName = paymentPage.getCardName().getText();
        System.out.println(actualPlaceholderCardName);
        Assert.assertEquals(actualPlaceholderCardName, "Имя и фамилия на карте");

        text = paymentPage.getButtonSubmitPay().getText();
        items = text.split(" ");
        String actualSumOnButton = items[1];
        System.out.println(actualSumOnButton);
        Assert.assertEquals(actualSumOnButton, expectedSum);
    }
}
