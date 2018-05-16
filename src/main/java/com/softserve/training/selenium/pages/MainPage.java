package com.softserve.training.selenium.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final String BASE_URL = "https://rozetka.com.ua/";

    public void open() {
        Selenide.open(BASE_URL);
    }

    public void openRegistration() {
        openLoginForm();
        $(By.linkText("Зарегистрироваться")).click();
    }

    public void openLoginForm() {
        $(By.linkText("войдите в личный кабинет")).shouldBe(enabled).click();
    }

    public void enterLoginName(String name) {
        $(By.name("login")).clear();
        $(By.name("login")).sendKeys(name);
    }

    public void enterPassword(String password) {
        $(By.name("password")).clear();
        $(By.name("password")).sendKeys(password);
    }

    public void doLogin() {
        $(By.name("auth_submit")).click();
    }

    public void logout() {
        $(By.name("profile")).shouldBe(enabled).click();
        $(By.linkText("Выход")).shouldBe(enabled).click();
    }

    public void closePopUp() {
        $$(By.linkText("Закрыть")).filterBy(enabled).forEach(SelenideElement::click);
    }

    public void search(String text) {
        $(By.name("text")).clear();
        $(By.name("text")).sendKeys(text);
        closePopUp();
        $(By.className("js-rz-search-button")).shouldBe(enabled).click();
    }

    public void choose(String text) {
        $(By.linkText(text)).shouldBe(enabled).click();
    }
}
