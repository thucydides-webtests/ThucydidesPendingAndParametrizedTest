package com.yandex.mainpage.steps;

import com.yandex.mainpage.pages.MainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps {
    public UserSteps(Pages pages) {
        super(pages);
    }

    private MainPage onMainPage() {
        return getPages().currentPageAt(MainPage.class);
    }

    @Step
    public void opensPage(String url) {
        getDriver().get(url);
    }

    @Step
    public void entersRequest(String keyword) {
        onMainPage().enterRequest(keyword);
    }

    @Step
    public void startsSearch() {
        onMainPage().lookup();
    }
}
