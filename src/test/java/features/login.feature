Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize browser with chrome
And Navigate to "https://courses.rahulshettyacademy.com/" site page
And Click on login link on home page to land on secure sign in page
When user enters <username> and <password> and logs in
And close browsers

Examples:
|username					|password	|
|test99@gmail.com	|123456		|
|kumarlokesh57@gmail.com|Samsung@135		|