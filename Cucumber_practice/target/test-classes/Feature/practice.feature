
@practice1
Feature: Login
	@test1
  Scenario: 
    Given user launches chrome browser
    And opens URL "http://automationpractice.com/index.php"
    When user click on sign in button
    Then user is redirected to sign in page
    Given enters email id to create account "test_aftab7@gmail.com" and clicks on create and account
    When user is redirected to account creation
    And user selects Mr as Title
    And enters first name as "Akshay" and last name as "Patil"
    And password as "abc123"
    And date of birth as "12""06""1992"
    And enters address with "Akshay" and "Patil"
    And company name "Inzy"
    And address as "2nd street"
    And City as "Chicago"
    And selects state as "Michigan" with zipcode 11234
    And adding mobile number as 123456678 with alias address as "Malibu"
    And clicks on Register
    Then it should get user to landing page and verifies username
    And clicks on sign out
    And close the browser
   
 	@test2 
  Scenario: 
  	Given user launches chrome browser
    And opens URL "http://automationpractice.com/index.php"
    When user click on sign in button
    And redirected to sign in page, enters "test_aftab7@gmail.com" and "abc123" and signs in
    And on user home page, user selects T-shirts to buy and clicks on it
    Then user is redirected to tshirts page
    When user clicks on first products add to cart button
    And goes to cart and proceeds to checkout
    Then item will be shown with the same details in the cart
  	
