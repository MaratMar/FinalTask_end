package ru.ibs;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.ibs.framework.enums.DriverEnums;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.pages.BasePage;


public class BaseTest extends BasePage {
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(DriverEnums.BASE_URL.getValue());
    }

    @AfterClass
    public static void afterAll() {
            InitManager.quitFramework();
    }

}
