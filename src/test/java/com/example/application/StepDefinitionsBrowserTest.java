package com.example.application;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.notification.testbench.NotificationElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.BrowserTestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitionsBrowserTest extends BrowserTestBase {

    @Given("In a browser on the HelloWorldView enter the name John it into the text field")
    public void in_a_browser_on_the_hello_world_view_enter_the_name_john_it_into_the_text_field() {
        setDriver(new ChromeDriver());
        getDriver().get("http://localhost:8080/");

        $(TextFieldElement.class).first().setValue("Foo");




    }
    @When("In a browser I press the button")
    public void in_a_browser_i_press_the_button() {
        $(ButtonElement.class).first().click();
    }

    @Then("In a browser a Notification is shown")
    public void in_a_browser_a_notification_is_shown() {
        //TODO wait for notification and check content..

        String notification = $(NotificationElement.class).first().getText();
        Assertions.assertEquals("Hello Foo", notification);

        //Teardown..
        getDriver().quit();
    }

}
