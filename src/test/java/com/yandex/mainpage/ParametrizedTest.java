package com.yandex.mainpage;

import com.yandex.mainpage.requirements.Application;
import com.yandex.mainpage.steps.UserSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@Story(Application.Search.SearchForRequest.class)
@RunWith(ThucydidesParameterizedRunner.class)
public class ParametrizedTest {
    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.yandex.com")
    public Pages pages;

    @Steps
    public UserSteps user;

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"euro"},
                {"olympic"}
        });
    }

    private String request;

    public ParametrizedTest(String request) {
        this.request = request;
    }

    @Test
    public void commonTestMethod() {
        user.entersRequest(request);
        user.startsSearch();
    }

    @Test
    public void emptyTestMethod() {
    }

    @Pending
    @Test
    public void pendingTestMethod() {
        user.opensPage("http://www.yandex.com");
        user.entersRequest("pending " + request);
        user.startsSearch();
    }
}
