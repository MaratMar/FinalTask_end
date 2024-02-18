package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OptionsPage extends BasePage {


    @FindBy(xpath = "//p[contains(@class, 'CardCategory_category')]//ancestor::a//p[contains(@class, 'CardCategory_title')]")
    private List<WebElement> optionsList;


    public List<WebElement> getOptionsList() {
        return optionsList;
    }

}