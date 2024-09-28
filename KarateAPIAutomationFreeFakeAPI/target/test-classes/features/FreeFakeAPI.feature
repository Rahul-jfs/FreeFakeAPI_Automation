Feature: FreefakeAPI functionality

  Background:
    * def postBody = read("classpath://json//createResource.json")
    * def updateBody =  read("classpath://json//updateResource.json")
    * def patchBody =  read("classpath://json//patchResource.json")

  Scenario: verify collection of posts are generated
    Given url host
    And path "/api/posts"
    When method get
    Then status 200
    And print response

  Scenario: verify single post is accessed
    Given url host
    And path "/api/posts/3"
    When method get
    Then status 200

  Scenario: verify the resource is posted
    Given url host
    And path "/api/posts"
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request postBody
    When method post
    Then status 201
    And print response

  Scenario: Verify the resource is updated
    Given url host
    And path "/api/posts/10"
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request updateBody
    When method post
    Then status 201
    And print response

  Scenario: verify the resource is patched
    Given url host
    And path "/api/posts/16"
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request patchBody
    When method patch
    Then status 200
    And print response

  Scenario: verify the post is deleted
    Given url host
    And path "/api/posts/16"
    When method delete
    Then status 204

