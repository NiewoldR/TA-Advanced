package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=new-todo]")
    private WebElement toDoText;

    @FindBy(css = "[data-testid=submit-newTask]")
    private WebElement newTaskButton;

    public TodosPage makeNewTask(String toDo){
        toDoText.sendKeys(toDo);
        newTaskButton.click();
        return new TodosPage(driver);
    }
}
