package com.softserve.training.selenium.pages;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public void process() {
        $x("//button[text()='Оформить заказ']").shouldBe(enabled);
    }

    public String getProductName() {
        return $(".cart-i-title-link").text();
    }
}
