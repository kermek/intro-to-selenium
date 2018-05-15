package com.softserve.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Rozetka {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://rozetka.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testRozetka() {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("войдите в личный кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
        String userNameVar = "userName" + System.currentTimeMillis();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(userNameVar);
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(userNameVar + "@mail123.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Закрыть"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("profile_signout"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("войдите в личный кабинет"))).click();
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.name("auth_submit")).click();
        driver.findElement(By.name("text")).clear();
        driver.findElement(By.name("text")).sendKeys("apple iphone x 64 gb silver");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Закрыть"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("js-rz-search-button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#image_item36325432 > a.responsive-img.centering-child-img > img.rz-lazy-load"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("topurchases"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Оформить заказ']")));

        Assert.assertEquals(driver.findElement(By.className("cart-i-title-link")).getText(), "Apple iPhone X 64Gb Silver");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
