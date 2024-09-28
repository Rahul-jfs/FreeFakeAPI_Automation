Feature: Get collection of posts validation

  Scenario: verify collection of posts are generated
    
    Given user wants to call "/api/posts" end point
    When user perform get call
    Then verify status code is 200
    And verify collection of posts is generated