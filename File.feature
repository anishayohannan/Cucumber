Feature: Application Submission.

Scenario: NewLead login
Given Initialize the browser with chrome
And Navigate to "http://test.dsaassist.com/login" site
And User enters the login Page
When User logins to the application with "anishamy10@gmail.com" and "Anaya#2019"
And Direct to new lead Page
Then Type all the informations
And Validate the entered datas
