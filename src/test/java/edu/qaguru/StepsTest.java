package edu.qaguru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;



public class StepsTest {
    private static final String REPOSITORY="acheong08/ChatGPT";
    private static final int ISSUE=618;
    @Test
    public void searchIssueLambda(){

        SelenideLogger.addListener("allure",new AllureSelenide());
        step("Открываем главную страницу", ()->{
            open("https://github.com/");
        } );
        step("Ищем репозиторий  "+REPOSITORY, ()->{
            $("[name=q]").click();
            $("[name=q]").sendKeys("acheong08/ChatGPT");
            $("[name=q]").submit();
        } );

        step("Кликаем по ссылке репозитория  "+REPOSITORY, ()->{

            $(linkText("acheong08/ChatGPT")).click();
        });
        step("Открываем таб Issues", ()->{
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером "+ISSUE);
        $(withText("#"+ISSUE)).should(exist);



    }

    @Test
    public void testAnnotatedStep(){
        WebSteps steps=new WebSteps();
        SelenideLogger.addListener("allure",new AllureSelenide());
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }

}
