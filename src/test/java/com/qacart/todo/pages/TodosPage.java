package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodosPage extends BasePage {
    public TodosPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=welcome]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=add]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=todo-item]")
    private WebElement getToDoText;

    @FindBy(css = "[data-testid=delete]")
    private WebElement delButton;

    @FindBy(css = "[data-testid=no-todos]")
    private WebElement noTodosMessage;

    public boolean isWelcomeDisplayed(){
        return welcomeMessage.isDisplayed();
    }

    public String getToDoText(){return getToDoText.getText();}
    public NewTodoPage addNewToDo(){
        addButton.click();
        return new NewTodoPage(driver);
    }

    public TodosPage delToDo(){
        delButton.click();
        return new TodosPage(driver);
    }



    public boolean isNoTodosDisplayed() {return  noTodosMessage.isDisplayed();  }
}
