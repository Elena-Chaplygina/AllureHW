package edu.qaguru;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class TestBase {
    public static void selenideLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }
}
