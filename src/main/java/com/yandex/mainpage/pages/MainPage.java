package com.yandex.mainpage.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://www.yandex.com")
public class MainPage extends PageObject {
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@role='button']")
    private WebElement lookupButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterRequest(String request) {
        element(searchInput).type(request);
    }

    public void lookup() {
        element(lookupButton).click();
    }
}
