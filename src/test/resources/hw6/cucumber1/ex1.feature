Feature: Different Elements Page

  Scenario: Home Page Title Assertion
    Given I open JDI Site
    Then page title is 'Home Page'

    When I login as user 'epam' with password '1234' on the Home Page
    Then username should be 'PITER CHAILOVSKII' on the Home page
    Then Home Page should contain all elements

    When I click on 'Service' button in the 'Header' Menu
    Then service drop down menu in 'Header' menu should contain all elements

    When I click on 'Service' button in the 'Left side' Menu
    Then service drop down menu in 'Left side' menu should contain all elements

    When I click on 'Service' button in the 'Header' Menu
    And I click on 'Different elements' button in Service dropdown
    Then 'Different elements' page is opened
    And Different elements page should contain all elements
    And Different elements page should contain Right Section
    And Different elements page should contain Left Section

    When I click on 'Water, Wind' checkboxes on the Different Elements page
    Then checkboxes 'Water, Wind' should be selected on the Different Elements page
    And logrow should have 'Water, true' on the Different Elements page
    And logrow should have 'Wind, true' on the Different Elements page

    When I click on 'Selen' radio button on the Different Elements page
    Then radio 'Selen' should be selected on the Different Elements page
    And logrow should have 'Selen, metal' on the Different Elements page

    When I select 'Yellow' element in the drop down menu on the Different Elements page
    Then element 'Yellow' in the drop down menu should be selected on the Different Elements page
    And logrow should have 'Yellow, Colors' on the Different Elements page

    When I click on 'Water, Wind' checkboxes on the Different Elements page
    Then checkboxes 'Water, Wind' should be unselected on the Different Elements page
    And logrow should have 'Water, false' on the Different Elements page
    And logrow should have 'Wind, false' on the Different Elements page