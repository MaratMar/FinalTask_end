package ru.ibs.framework.managers;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.ibs.framework.enums.DriverEnums;


public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        if (OS.isFamilyWindows()) {
            initDriverWindowsOsFamily();
        } else if (OS.isFamilyMac()) {
            initDriverMacOsFamily();
        } else if (OS.isFamilyUnix()) {
            initDriverUnixOsFamily();
        }
    }

    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily(DriverEnums.PATH_GECKO_DRIVER_WINDOWS.getValue()
                , DriverEnums.PATH_CHROME_DRIVER_WINDOWS.getValue());
    }

    private void initDriverMacOsFamily() {
        initDriverAnyOsFamily(DriverEnums.PATH_GECKO_DRIVER_MAC.getValue()
                , DriverEnums.PATH_CHROME_DRIVER_MAC.getValue());
    }

    private void initDriverUnixOsFamily() {
        initDriverAnyOsFamily(DriverEnums.PATH_GECKO_DRIVER_UNIX.getValue()
                , DriverEnums.PATH_CHROME_DRIVER_UNIX.getValue());
    }

    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (DriverEnums.BROWSER.getValue()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", DriverEnums.GECKO.getValue());
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", DriverEnums.CHROME.getValue());
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Хз че за браузер "
                        + DriverEnums.BROWSER.getValue() + ", братишка");
                break;
        }
    }
}
