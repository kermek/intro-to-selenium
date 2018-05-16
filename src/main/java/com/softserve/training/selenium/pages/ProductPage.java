package com.softserve.training.selenium.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    public void buy() {
        $(By.name("topurchases")).shouldBe(enabled).click();
    }
}
