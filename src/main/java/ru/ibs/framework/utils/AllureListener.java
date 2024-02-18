package ru.ibs.framework.utils;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.framework.managers.DriverManager;

import java.util.UUID;

    public class AllureListener extends AllureJunit4 {
        private DriverManager driverManager = DriverManager.getDriverManager();

        @Override
        public void testFailure(Failure failure) {
            byte[] byteImg = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            getLifecycle().addAttachment("Screenshot " + UUID.randomUUID().toString(), "image/png",
                    "png", byteImg);
            super.testFailure(failure);
        }
    }
