Feature: Validating SelfCareCheckOut

@regression @smoke
Scenario: self check out
Given the costco titlePage'Welcome to Costco Wholesale'
When user scroll down the page
Then verify costco footerMessage '© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.'
When user scrolls Up the homepage 
And user input in searchField 'face cream'
And user click searchField button
And user dropdown the sortBy button
And user select the option "Newest"
And user click the creamSerum link
And user click the add to cart  button
And user select the cart button

@smoke
Scenario: self check out2
Given the costco titlePage'Welcome to Costco Wholesale'
When user scroll down the page
Then verify costco footerMessage '© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.'
When user scrolls Up the homepage 
And user input in searchField 'face cream'
And user click searchField button