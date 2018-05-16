package com.softserve.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    private WebDriver driver;

    public void enterLoginName(String name) {
        $(By.name("title")).clear();
        $(By.name("title")).sendKeys(name);
    }

    public void enterEmail(String email) {
        $(By.name("login")).clear();
        $(By.name("login")).sendKeys(email);
    }

    public void enterPassword(String password) {
        $(By.name("password")).clear();
        $(By.name("password")).sendKeys(password);
    }

    public void register() {
        $x("(//button[@type='submit'])[2]").click();
    }
}
