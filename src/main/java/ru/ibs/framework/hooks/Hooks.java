package ru.ibs.framework.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;

import java.util.UUID;

public class Hooks {
    final static DriverManager driverManager = DriverManager.getDriverManager();

    @Before
    public void before() {
        InitManager.initFramework();
        driverManager
                .getDriver()
                .get(DriverEnums.BASE_URL.getValue());
    }
    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png", "Screenshot" + UUID.randomUUID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InitManager.quitFramework();
    }
}
