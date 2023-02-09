package edu.qaguru;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void searchIssue(){

        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com/");
        $("[name=q]").click();
        $("[name=q]").sendKeys("acheong08/ChatGPT");
        $("[name=q]").submit();

        $(linkText("acheong08/ChatGPT")).click();
        $("#issues-tab").click();
        $(withText("#618")).should(exist);



    }
}
