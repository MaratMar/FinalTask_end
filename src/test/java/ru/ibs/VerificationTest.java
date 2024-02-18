package ru.ibs;

import org.junit.Test;
import ru.ibs.framework.pages.OptionsPage;
import ru.ibs.framework.pages.SearchPage;

public class VerificationTest extends BaseTest {

    SearchPage searchPage = new SearchPage();
    OptionsPage optionsPage = new OptionsPage();

    @Test
    public void test_video_card() {
        catalogueButton.click();
        clickWebElementFromList(menuOptionsList, "Комплектующие для ПК");
        waitPageTitle("Комплектующие для ПК");
        clickWebElementFromList(optionsPage.getOptionsList(), "Видеокарты");
        waitPageTitle("Видеокарты");
        searchPage.setMinPrice(2000);
        searchPage.waitUntilSearchDone();
        clickWebElementFromList(searchPage.getManufacturerList(), "Gigabyte");
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 24);
        String s = searchPage.getTitleFromResultsList(1);
        setFieldAndSubmit(searchBar, s);
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 1);
        searchPage.getTitleFromResultsList(1);
        searchPage.compareSearchResults(1);
    }

    @Test
    public void test_keyboard() {
        catalogueButton.click();
        clickWebElementFromList(menuOptionsList, "Периферия");
        waitPageTitle("Периферия");
        clickWebElementFromList(optionsPage.getOptionsList(), "Клавиатуры");
        waitPageTitle("Клавиатуры");
        searchPage.setMinPrice(2000);
        searchPage.waitUntilSearchDone();
        clickWebElementFromList(searchPage.getManufacturerList(), "A4Tech");
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 24);
        String s = searchPage.getTitleFromResultsList(1);
        setFieldAndSubmit(searchBar, s);
        searchPage.waitUntilSearchDone();
        searchPage.checkResultsCount(searchPage.getResultsList(), 1);
        searchPage.getTitleFromResultsList(1);
        searchPage.compareSearchResults(1);
    }
}

