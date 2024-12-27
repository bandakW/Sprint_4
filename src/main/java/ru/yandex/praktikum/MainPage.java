package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(3);
    //Кнопка "Заказать" верхняя
    private final By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" нижняя
    private final By middleOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By acceptCoockieButton = By.xpath(".//button[text()='да все привыкли']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    public void clickAcceptCookieButton() {
        driver.findElement(acceptCoockieButton).click();
    }

    public void clickQuest (String request, String responce) {
        driver.findElement(By.xpath(".//div[text()='" + request + "']")).click();
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(".//p[text()='" + responce + "']")));
    }
}