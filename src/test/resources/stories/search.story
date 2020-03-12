Search

Meta:
@search
@smoke

Narrative:
  In order to find anything
  As a regular authentificated user
  I want to be able to search

Lifecycle:
Before:
Scope:SCENARIO
Given I open Landing page
When I login with username altestqa@gmail.com and password Aqqq2222

Scenario: Search by search step
Meta:
@search
Given I should see Home page
When I search for $searchTerm
Then I should see $searchTerm in each search result

Examples:
|searchTerm |
|hr         |
|Human Resources|