Search

Meta:
@search
@smoke

Narrative:
  In order to find anything
  As a regular authentificated user
  I want to be able to search

Lifecycle:
Before: I open Landing page
Scope:SCENARIO


Scenario: Search
Meta:
@search
Given I login with username altestqa@gmail.com and password Aqqq2222
When I search for $searchTerm
Then Then I should find relevant results

Examples:
|searchTerm |
|hr         |
