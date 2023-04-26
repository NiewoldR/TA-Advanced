package com.qacart.todo.testcases;
import com.github.javafaker.Faker;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.SignupPage;
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
        String toDo = "Learn Selenium";
        Assert.assertEquals(
                new SignupPage(driver)
                    .load()
                    .signup(firstName,lastName,password,email)
                    .addNewToDo()
                    .makeNewTask(toDo)
                    .getToDoText(),"Learn Selenium");
    }

    @Test
    public void shouldBeAbleToDeleteATodo() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = "iLikeTesting";
        String toDo = "Learn Selenium";
        Assert.assertTrue(
                new SignupPage(driver)
                        .load()
                        .signup(firstName,lastName,password,email)
                        .addNewToDo()
                        .makeNewTask(toDo)
                        .delToDo()
                        .isNoTodosDisplayed());
    }
}
