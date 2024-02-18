package ru.ibs.framework.steps;

import io.cucumber.java.en.Given;
import ru.ibs.framework.pages.BasePage;
import ru.ibs.framework.pages.OptionsPage;
import ru.ibs.framework.pages.SearchPage;

public class SearchPageSteps extends BasePage {

    private final OptionsPage optionsPage = new OptionsPage();
    private final SearchPage searchPage = new SearchPage();



    @Given("Клик на каталог")
    public void клик_на_каталог() {
        catalogueButton.click();
    }


    @Given("^Выбор \"([^\"]*)\"$")
    public void выбор(String string) {
        clickWebElementFromList(menuOptionsList, string);
        waitPageTitle(string);
    }

    @Given("^Выбор \"([^\"]*)\" в гриде$")
    public void выбор_в_гриде(String string) {
        clickWebElementFromList(optionsPage.getOptionsList(), string);
        waitPageTitle(string);
    }


    @Given("^Установка минималки (\\d+)$")
    public void установка_минималки(Integer int1) {
        searchPage.setMinPrice(int1);
        searchPage.waitUntilSearchDone();
    }

    @Given("^Выбираем вендора \"([^\"]*)\"$")
    public void выбираем_вендора(String string) {
        clickWebElementFromList(searchPage.getManufacturerList(), string);
        searchPage.waitUntilSearchDone();
    }

    @Given("^Убеждаемся что количество результатов поиска меньше или равно (\\d+)$")
    public void убеждаемся_что_количество_результатов_поиска_меньше_или_равно(Integer int1) {
        searchPage.checkResultsCount(searchPage.getResultsList(), int1);
    }

    @Given("^Сохраняем наименование результата номер (\\d+) из списка, вводим в серч бар сверху его значение$")
    public void сохраняем_наименование_результата_номер_из_списка_вводим_в_серч_бар_сверху_его_значение(Integer int1) {
        String s = searchPage.getTitleFromResultsList(int1);
        setFieldAndSubmit(searchBar, s);
        searchPage.waitUntilSearchDone();
    }

    @Given("^Получаем наименование (\\d+) результата из списка и сравниваем его с введенным значением в серч баре$")
    public void получаем_наименование_результата_из_списка_и_сравниваем_его_с_введенным_значением_в_серч_баре(Integer int1) {
        searchPage.getTitleFromResultsList(int1);
        searchPage.compareSearchResults(int1);
    }

}
