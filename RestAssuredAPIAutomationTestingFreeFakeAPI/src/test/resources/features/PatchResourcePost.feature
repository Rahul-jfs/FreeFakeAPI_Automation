Feature: Patch post functionality
  
  Scenario: verify the resource is patched
    Given user wants to call "/api/posts/2" end point
    And set "Content-Type" to "application/json"
    And send updated body from file "/patchResource.json"
    When user perform patch call
    Then verify status code is 200