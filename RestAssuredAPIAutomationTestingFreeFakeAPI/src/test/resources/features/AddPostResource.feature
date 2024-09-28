Feature: Add resource using post functionality

  Scenario: verify the resource is posted
    Given user wants to call "/api/posts" end point
    And set "Content-Type" to "application/json"
    And send body from file "/createResource.json"
    When user perform post call
    Then verify status code is 201
