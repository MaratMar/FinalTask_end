package ru.ibs.framework.managers;

import ru.ibs.framework.enums.DriverEnums;

import java.util.concurrent.TimeUnit;

import static ru.ibs.framework.managers.DriverManager.*;

public class InitManager {
    private static final DriverManager driverManager = getDriverManager();

    private InitManager(){
    }

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer
                .parseInt(DriverEnums.IMPLICITLY_WAIT.getValue()), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer
                .parseInt((DriverEnums.PAGE_LOAD_TIMEOUT.getValue())), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}