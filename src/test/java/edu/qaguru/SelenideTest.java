package edu.qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {
    @Test
    public void searchIssueTest() {
        open("https://github.com/");
        $("[name=q]").click();
        $("[name=q]").sendKeys("acheong08/ChatGPT");
        $("[name=q]").submit();
        $(linkText("acheong08/ChatGPT")).click();
        $("#issues-tab").click();
        $(withText("#618")).should(exist);
    }
}
