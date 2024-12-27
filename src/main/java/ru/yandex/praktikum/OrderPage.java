package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPage {
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(3);
    private final By firstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By secondName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneCustomer = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By ONWARDS_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By inputOrderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By RENTAL_PERIOD_BUTTON = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By YES_BUTTON = By.xpath(".//button[text()='Да']");
    private static final By ORDER_CREATE = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private final WebDriver driver;
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void setFirstName (String name) {
        driver.findElement(firstName).sendKeys(name);
    }
    public void setSecondName (String famile) {
        driver.findElement(secondName).sendKeys(famile);
    }

    public void setAddress (String adress1) {
        driver.findElement(address).sendKeys(adress1);
    }

    public void setMetroStation(By station) {
        driver.findElement(metroStation).click();
        driver.findElement(station).click();
    }
    public void setPhoneCustomer (String phone) {
        driver.findElement(phoneCustomer).sendKeys(phone);
    }
    public void clickOnwardsButton() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ONWARDS_BUTTON));
        element.click();
    }
    public void customerData(String firstName, String secondName, String address, By station, String phone) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        setMetroStation(station);
        setPhoneCustomer(phone);
        clickOnwardsButton();
    }

    public void clickOrderDate(By orderDate) {
        driver.findElement(inputOrderDate).isEnabled();
        driver.findElement(inputOrderDate).clear();
        driver.findElement(inputOrderDate).click();
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDate));
        element.click();
    }

    public void setRentalPeriod (By rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_BUTTON).isEnabled();
        driver.findElement(RENTAL_PERIOD_BUTTON).click();
        driver.findElement(rentalPeriod).click();
    }

    public void setScooterColor (By scooterColor) {
        driver.findElement(scooterColor).click();
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void forRentalData(By orderDate, By rentalPeriod,By scooterColor) {
        clickOrderDate(orderDate);
        setRentalPeriod(rentalPeriod);
        setScooterColor(scooterColor);
        clickOrderButton();
    }

    public void clickYesButton() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(YES_BUTTON));
        element.click();
    }

    public void checkOrderCreated (String text) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElementLocated(ORDER_CREATE, text));
    }
}