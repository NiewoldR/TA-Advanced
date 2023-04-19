package com.qacart.todo.testcases;
import com.github.javafaker.Faker;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddATodo() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = "iLikeTesting";
        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("[data-testid=first-name]")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[data-testid=last-name]")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-testid=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[data-testid=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid=confirm-password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid=submit]")).click();
        driver.findElement(By.cssSelector("[data-testid=add]")).click();
        driver.findElement(By.cssSelector("[data-testid=new-todo]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=submit-newTask]")).click();
        String text = driver.findElement(By.cssSelector("[data-testid=todo-item]")).getText();
        Assert.assertEquals(text, "Learn Selenium");
    }

    @Test
    public void shouldBeAbleToDeleteATodo() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = "iLikeTesting";
        driver.get("https://todo.qacart.com/signup");
        driver.findElement(By.cssSelector("[data-testid=first-name]")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[data-testid=last-name]")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[data-testid=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[data-testid=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid=confirm-password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[data-testid=submit]")).click();
        driver.findElement(By.cssSelector("[data-testid=add]")).click();
        driver.findElement(By.cssSelector("[data-testid=new-todo]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=submit-newTask]")).click();
        driver.findElement(By.cssSelector("[data-testid=delete]")).click();
        boolean isNoTodosDisplayed = driver.findElement(By.cssSelector("[data-testid=no-todos]")).isDisplayed();
        Assert.assertTrue(isNoTodosDisplayed);
    }
}
