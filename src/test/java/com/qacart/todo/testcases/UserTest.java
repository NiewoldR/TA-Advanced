package com.qacart.todo.testcases;

import com.github.javafaker.Faker;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.SignupPage;
import com.qacart.todo.pages.TodosPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test
    public void shouldBeAbleToSignup() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = "iLikeTesting";

        /*boolean isWelcomeDisplayed = new SignupPage(driver)
                .load()
                .signup(firstName,lastName,password,email)
                .isWelcomeDisplayed();
*/

        Assert.assertTrue(
                new SignupPage(driver.get())
                    .load()
                    .signup(firstName,lastName,password,email)
                    .isWelcomeDisplayed());
    }
}
