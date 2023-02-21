Feature: TechGlobal Training Functionalities

  Background:
    Given user navigates to "https://techglobal-training.netlify.app/"

    Scenario: Validate the main content of the Pagination Page
When user moves to “Practices” header dropdown
And user clicks on “Frontend Testing” header dropdown option
Then user should be navigated to “https://techglobal-training.netlify.app/frontend”
And user clicks on “Pagination” card
Then user should be navigated to“https://techglobal-training.netlify.app/frontend/pagination”
And user should see “Pagination” heading
And user should see “World City Populations 2022” heading
And user should see “What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:” paragraph