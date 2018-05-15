package com.softserve.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class RozetkaSelenide {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "https://rozetka.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRozetka() {
        String userNameVar = "userName" + System.currentTimeMillis();

        open(baseUrl);
        $(By.linkText("войдите в личный кабинет")).click();
        $(By.linkText("Зарегистрироваться")).click();
        $(By.name("title")).clear();
        $(By.name("title")).sendKeys(userNameVar);
        $(By.name("login")).clear();
        $(By.name("login")).sendKeys(userNameVar + "@mail123.com");
        $(By.name("password")).clear();
        $(By.name("password")).sendKeys("P@ssw0rd");
        $x("(//button[@type='submit'])[2]").click();
        $(By.linkText("Закрыть")).shouldBe(enabled).click();
        $("#profile_signout").shouldBe(enabled).click();
        $(By.linkText("войдите в личный кабинет")).shouldBe(enabled).click();
        $(By.name("login")).click();
        $(By.name("password")).click();
        $(By.name("password")).clear();
        $(By.name("password")).sendKeys("P@ssw0rd");
        $(By.name("auth_submit")).click();
        $(By.name("text")).clear();
        $(By.name("text")).sendKeys("apple iphone x 64 gb silver");
        $(By.linkText("Закрыть")).shouldBe(enabled).click();
        $(By.className("js-rz-search-button")).shouldBe(enabled).click();
        $("#image_item36325432").shouldBe(enabled).click();
        $(By.name("topurchases")).shouldBe(enabled).click();
        $x("//button[text()='Оформить заказ']").shouldBe(enabled);

        Assert.assertEquals($(".cart-i-title-link").text(), "Apple iPhone X 64Gb Silver");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
