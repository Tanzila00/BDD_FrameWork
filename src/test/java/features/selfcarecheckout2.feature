Feature: Validating SelfCareCheckOut2

  Background: 
    * print <msg>
      | 'Self CheckOut Test' |
      | 'Hello Costco'  |


@regression
Scenario: self check out2
Given the costco titlePage'Welcome to Costco Wholesale'
When user scroll down the page
Then verify costco footerMessage '© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.'
When user scrolls Up the homepage 
And user input in searchField 'face cream'
And user click searchField button

@smoke
Scenario Outline: self check out2
Given the costco titlePage'Welcome to Costco Wholesale'
When user scroll down the page
Then verify costco footerMessage '© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.'
When user scrolls Up the homepage 
And user input in searchField <searchField>
And user click searchField button

Examples:
|searchField|
|'face cream'|
|'shampoo'|
|'charger'|

@inline-table
Scenario: self check out3
Given the costco titlePage'Welcome to Costco Wholesale'
When user scroll down the page
Then verify costco footerMessage '© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.'
When user scrolls Up the homepage 
And user input in searchField <searchField>
|'face cream'|
|'shampoo'|
And user click searchField button