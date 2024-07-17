package com.example.application;

import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.testbench.unit.UIUnitTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitionsUiUnitTests extends UIUnitTest {

    private HelloWorldView view;

    @Given("On the HelloWorldView enter the name John it into the text field")
    public void I_have_a_name(){
        initVaadinEnvironment();
        this.view = navigate(HelloWorldView.class);
        //TODO don't use public fields for field access.. just a test.. of a test..
        test(view.name).setValue("John");
    }

    @When("I press the button")
    public void i_press_the_button() {
        test(view.sayHello).click();
    }

    @Then("a Notification is shown")
    public void a_notification_is_shown() {
        // Notification isn't referenced in the view so we need to use the component
        // query API to find the notification that opened
        Notification notification = $(Notification.class).first();
        Assertions.assertEquals("Hello John", test(notification).getText());

        //TODO is this enough cleanup?  initVaadinEnvironment(); is a @BeforeEach.. this is the @AfterEach...
        cleanVaadinEnvironment();
    }

}
