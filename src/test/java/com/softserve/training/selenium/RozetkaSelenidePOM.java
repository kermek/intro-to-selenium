package com.softserve.training.selenium;

import com.softserve.training.selenium.pages.CartPage;
import com.softserve.training.selenium.pages.MainPage;
import com.softserve.training.selenium.pages.ProductPage;
import com.softserve.training.selenium.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaSelenidePOM {

    @Test
    public void testRozetka() {
        String userName = "userName" + System.currentTimeMillis();
        String userEmail = userName + "@mail123.com";
        String userPassword = "P@ssw0rd";
        String productName = "Apple iPhone X 64Gb Silver";
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.openRegistration();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterLoginName(userName);
        registrationPage.enterEmail(userEmail);
        registrationPage.enterPassword(userPassword);
        registrationPage.register();
        mainPage.logout();
        mainPage.openLoginForm();
        mainPage.enterLoginName(userEmail);
        mainPage.enterPassword(userPassword);
        mainPage.doLogin();
        mainPage.closePopUp();
        mainPage.search(productName);
        mainPage.choose(productName);
        ProductPage productPage = new ProductPage();
        productPage.buy();
        CartPage cartPage = new CartPage();
        cartPage.process();

        Assert.assertEquals(cartPage.getProductName(), productName);
    }
}
