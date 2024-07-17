Feature: HelloWorldView
   Scenario: Enter name show notification
      Given On the HelloWorldView enter the name John it into the text field
      When I press the button
      Then a Notification is shown