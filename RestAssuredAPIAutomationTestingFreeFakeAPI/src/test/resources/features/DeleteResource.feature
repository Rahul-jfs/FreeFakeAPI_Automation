Feature: Delete post resource functionality

  Scenario: verify the post is deleted
    Given user wants to call "/api/posts/2" end point
    When user perform delete call
    Then verify status code is 204