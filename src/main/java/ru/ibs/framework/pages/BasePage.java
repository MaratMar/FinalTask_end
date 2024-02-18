package ru.ibs.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.PageFactory.initElements;
import static ru.ibs.framework.managers.DriverManager.getDriverManager;

public class BasePage {

    protected final DriverManager driverManager = getDriverManager();

    @FindBy(xpath = "//button[contains(@class, 'NavigationBar_burgerButton')]")
    protected WebElement catalogueButton;


    @FindBy(xpath = "//h1[contains(@class, 'PageTitle_title')]")
    protected WebElement pageTitle;


    @FindBy(xpath = "//ul[contains(@class, 'Catalog_mainList')]//a")
    protected List<WebElement> menuOptionsList;


    @FindBy(xpath = "//input[@aria-label='Поиск']")
    protected WebElement searchBar;

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(),
            parseInt((DriverEnums.DRIVER_WAIT_SECONDS.getValue())),
            parseInt((DriverEnums.DRIVER_SLEEP_MILLIS.getValue())));


    public BasePage() {
        initElements(driverManager.getDriver(), this);
    }


    protected WebElement waitClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void setField(WebElement e, int num) {
        e.click();
        e.sendKeys(String.valueOf(num));
    }

    protected void setFieldAndSubmit(WebElement e, String s) {
        e.click();
        e.sendKeys(s + Keys.ENTER);
    }

    protected void clickWebElementFromList(List<WebElement> list, String s) {
        for (WebElement element : list) {
            if (element.getText().contains(s)) {
                waitClickability(element).click();
                return;
            }
        }
        Assert.fail("Значение '" + s + "' не найдено");
    }

    protected void waitPageTitle(String s) {
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, s));
        Assert.assertEquals("Заголовок " + s + " не найден", s, pageTitle.getText());
    }
}