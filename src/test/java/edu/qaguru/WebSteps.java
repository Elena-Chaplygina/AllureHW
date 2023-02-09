package edu.qaguru;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");

    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[name=q]").click();
        $("[name=q]").sendKeys(repo);
        $("[name=q]").submit();

    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();

    }

    @Step("Открываем таб Issues")
    public void openIssueTab() {
        $("#issues-tab").click();

    }

    @Step("Проверяем наличие Issue с номером ")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(exist);

    }


}
