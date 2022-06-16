package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;
import io.opentelemetry.sdk.logs.data.LogDataBuilder;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;


public class TestBase {
    @BeforeAll
    public static void setup() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;

    }





      /**  SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
       String selenoidLogin = config.selenoidLogin();
       String selenoidPassword = config.selenoidPassword();
       String selenoidServer = System.getProperty("selenoid_server", "selenoid.autotests.cloud/wd/hub");
              Configuration.baseUrl = "https://hh.ru";
              Configuration.browserSize = "1920x1080";
     Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPassword + "@" +
                selenoidServer;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }**/

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.video(sessionId);
        step("Close driver", Selenide::closeWebDriver);

        Attach.video(sessionId);
        //     Attach.browserConsoleLogs();
        //      Attach.addVideo();
      //  closeWebDriver();
    }

}





