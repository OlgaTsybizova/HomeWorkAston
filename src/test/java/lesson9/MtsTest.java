package lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MtsTest {
    WebDriver driver;

    @BeforeAll
    static void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void createObjectChromeDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
    }
    void clickCookieButton(){
        WebElement cookieWindow = driver.findElement(By.xpath("//div[contains(@class, 'cookie__wrapper')]"));
        WebElement cookieButton = driver.findElement(By.xpath("//div[@class='cookie__buttons']/button[contains(text(),'Отклонить')]"));
        if(cookieWindow.isDisplayed()){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieButtonReject = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieButtonReject.click();
        }
    }
    @AfterEach
    void quitSession(){
        driver.quit();
    }

    //Проверка названия блока
   @Test
    void testCheckBlockName(){
        WebElement blockNameElement = driver.findElement(By.xpath("//h2[contains(normalize-space(text()),'Онлайн пополнение')]"));
        String actual = blockNameElement.getText();
        //System.out.println(actual);
        String expected = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(actual, expected);
    }
    @Test
    void testLogoElements(){
        List<WebElement> listPaySystem = driver.findElements(By.xpath("//div[contains(@class,'pay__partners')]/descendant::img"));
        List<String> actualListPaySystem = new ArrayList<>();
        List<String> expectedListPaySystem = new ArrayList<>(Arrays.asList("Visa", "Verified By Visa","MasterCard","MasterCard Secure Code", "Белкарт"));
        for(WebElement l: listPaySystem){
            //System.out.println(l.getAttribute("alt"));
            actualListPaySystem.add(l.getAttribute("alt"));
            Assert.assertTrue(l.isDisplayed());
        }
        Assert.assertEquals(actualListPaySystem, expectedListPaySystem);
    }
    @Test
    void testLinkAboutService() {
        WebElement blockElement = driver.findElement(By.xpath("//a[contains(normalize-space(text()),'Подробнее о сервисе')]"));
        String hrefValue = blockElement.getAttribute("href");
        if (hrefValue != null && !hrefValue.isEmpty()) {
           //System.out.println("Ссылка найдена: " + hrefValue);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(text()),'Подробнее о сервисе')]")));
            element.click();
            String actualTitle = driver.getTitle();
            String expectedTitle = "Порядок оплаты и безопасность интернет платежей";
            Assert.assertEquals(actualTitle, expectedTitle);
        }
    }

    @Test
    void testButton(){
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='pay']"));
        WebElement phoneNumberInputField = driver.findElement(By.xpath("//input[contains(@id,'connection-phone')]"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[contains(@id,'connection-sum')]"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='connection-email']"));
        WebElement buttonRun = driver.findElement(By.xpath("//form[contains(@class, 'pay-form opened')]/child::button[contains(text(),'Продолжить')]"));
        Select dropdown = new Select(dropDownElement);

        dropdown.selectByVisibleText("Услуги связи");
        phoneNumberInputField.click();
        phoneNumberInputField.sendKeys("297777777");
        sumInputField.click();
        sumInputField.sendKeys("10");
        emailInputField.click();
        emailInputField.sendKeys("qqq@gmail.com");
        buttonRun.click();
        Assert.assertTrue(buttonRun.isEnabled());

    }
}

