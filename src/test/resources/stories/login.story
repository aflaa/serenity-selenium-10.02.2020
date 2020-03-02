Login

Meta:
@login
@smoke

Narrative:
  In order to access to application
  As a regular user
  I want to be able to login via email

Lifecycle:
Before:
Scope:SCENARIO
Given I open Landing page

Scenario: Successful login
Meta:
@login01

When I login with username userEmail and password userPassword
Then I should see Home page

Examples:

|userEmail                  |userPassword|
|altestqa@gmail.com         |Aqqq2222    |
|ALtestQA@gmail.com         |Aqqq2222    |