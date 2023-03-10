package edu.qaguru;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void selenideLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
