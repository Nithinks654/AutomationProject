package org.nithin.testing.stepdefinition.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.nithin.testing.DriverManager;
import org.openqa.selenium.WebDriver;

public class HookStefDef {
    public class HookStepDef {
        private WebDriver driver;

//    @Before(order = 1)
//    public void beforeScenario(Scenario scenario) {
//        System.out.println("Before Scenario: " + scenario.getName());
////        driver = DriverManager.getDriver(); // Initialize driver before each scenario
//    }

//        @Before(order = 0)
//    @BeforeAll
        public void beforeScenarios(Scenario scenario) {
            System.out.println("Before Scenario: " + scenario.getName());
        driver = DriverManager.getDriver(); // Initialize driver before each scenario
        }

        //    @AfterAll
        @After
        public void afterScenario(Scenario scenario) {
            System.out.println("After Scenario: " + scenario.getName());
            DriverManager.quitDriver(); // Quit driver after each scenario
        }
    }
}
