package ru.ibs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
        features = "src/test/features",
        glue = {"ru.ibs.framework.steps", "ru.ibs.framework.hooks"},
        tags = "@all"
)


public class CucumberRunner {
}
