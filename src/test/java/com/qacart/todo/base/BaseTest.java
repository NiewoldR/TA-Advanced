package com.qacart.todo.base;
import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        this.driver.set(DriverFactory.initDriver());

    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}
