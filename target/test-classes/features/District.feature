Feature: 
This feature will test the end to end functionality of the District.in application

Scenario:
Booking of a movie ticket

Given I am on the District.in home page
When I click on the Search icon
And I click on the Movies link
And I enter "Dhurandhar" in the search box
Then I should see the search results for "Dhurandhar"
