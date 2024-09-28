Feature: Single post access functionality

  Scenario: verify single post is accessed
    Given user wants to call "/api/posts/2" end point
    When user perform get call
    Then verify status code is 200