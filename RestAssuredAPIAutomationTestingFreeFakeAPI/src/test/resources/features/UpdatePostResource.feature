Feature: Update resource functionality
  
  Scenario: Verify the resource is updated
    
    Given user wants to call "/api/posts/2" end point
    And set "Content-Type" to "application/json"
    And send updated body from file "/updateResource.json"
    When user perform put call
    Then verify status code is 200

