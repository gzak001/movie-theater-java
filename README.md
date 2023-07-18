# Introduction

This is a poorly written application, and we're expecting the candidate to greatly improve this code base.

## Instructions
* **Consider this to be your project! Feel free to make any changes**
* There are several deliberate design, code quality and test issues in the current code, they should be identified and resolved
* Implement the "New Requirements" below
* Keep it mind that code quality is very important
* Focus on testing, and feel free to bring in any testing strategies/frameworks you'd like to implement
* You're welcome to spend as much time as you like, however, we're expecting that this should take no more than 2 hours

## `movie-theater`

### Current Features
* Customer can make a reservation for the movie
  * And, system can calculate the ticket fee for customer's reservation
* Theater have a following discount rules
  * 20% discount for the special movie
  * $3 discount for the movie showing 1st of the day
  * $2 discount for the movie showing 2nd of the day
* System can display movie schedule with simple text format

## New Requirements
* New discount rules; In addition to current rules
  * Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
  * Any movies showing on 7th, you'll get 1$ discount
  * The discount amount applied only one if met multiple rules; biggest amount one
* We want to print the movie schedule with simple text & json format

### Reafactoring of Project:

* I was able to refactor the project in the following ways:
  * Refactor the project into tiers/layers
  * create new folders domain, service, dao
  * this will allow for SOC-separeatiopns of concerns and DRY architecture
  * this follows the pattern of Clean architecture and can then be used as a stepping
    stone to be re-egineered using the SPringBoot framework
  * domain: contains Entity(data) objects that are used to hold data that will be used 
    for processing. 
  * service: this will contain the behavior and processing provided by the project.
    the service methods have been setup to be states so as to be re-usable by a static
    instance reference
  * dao: normally this would be used to connect to a datastore(db..). for this project, 
    the dao will only reference static test data
  * testing: setup and created testing for all service layer services. this test are mainly 
    first cut, and can be enhance with further revisioning

* Verified current requirements

* Verified new requirements
###  Observations:
  
* With more time, and better understanding, might need to change it up a bit to;domain, service
dao ... to be more flexible, adaptable to further enhancements and modifications
* With more time, add  more info to be used for debugging and testing
* the project is now aligned to be more easily re-engineered with a framework such a Springboot 
    