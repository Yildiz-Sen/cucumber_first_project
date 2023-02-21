package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPagination;
import utils.Driver;

public class TechGlobalPaginationSteps {

    WebDriver driver;
    TechGlobalPagination techGlobalPagination;

    TechGlobalBasePage techGlobalBasePage;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalPagination = new TechGlobalPagination();
        techGlobalBasePage = new TechGlobalBasePage();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();

    }

    @Given("user is on {string}")
    public void user_should_see_in_the_url(String key) {
        for(String word : key.split(" ")){
            Assert.assertTrue(driver.getCurrentUrl().contains(word));
        }
    }

    @When("user moves to {string} header dropdown")
    public void userClicksOnPracticesDropdownInTheHeader(String string){
        if (string.equals("Practices"))
            techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user clicks on {string} header dropdown option")
    public void userSelectsTheOption(String string) {
        if (string.equals("Frontend Testing"))
            techGlobalFrontendTestingHomePage.getFrontendTestingPage();}

    @Then("user should be navigated to {string}")
    public void userGetsNavigatedToFrontendURL(String URL){
        switch (URL) {
            case "https://techglobal-training.netlify.app/frontend":
            case "https://techglobal-training.netlify.app/frontend/pagination":
                Assert.assertEquals(URL, driver.getCurrentUrl());
                break;
            default:
                throw new NotFoundException("The heading text is not defined!");
        }}

    @And("user clicks on {string} card")
    public void userClicksOnPaginationCard(String string){
        if (string.equals("Pagination"))
            techGlobalFrontendTestingHomePage.clickOnCard(string);
    }

    @And("user should see {string} heading")
    public void user_should_see_heading(String heading) {
        switch (heading) {
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPagination.paginationLogo.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPagination.paginationSubheading.getText());
                break;
            default:
                throw new NotFoundException("The heading text is not defined!");
        }}

    @And("user should see {string} paragraph")
    public void user_should_see_paragraph(String paragraph) {
        paragraph = "What are the most populated cities in the world? Here is a list of the top five most populated cities in the world:";
        Assert.assertEquals(paragraph, techGlobalPagination.paginationParagraph.getText());
    }

    @Then("user should see {string} button is disabled")
    public void user_should_see_button_is_disabled(String buttons) {
        switch (buttons) {
            case "Previous":
                Assert.assertFalse(techGlobalPagination.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalPagination.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException("The button is not defined!");
        }}



    @Then("user should see {string} button is enabled")
    public void user_should_see_button_is_enabled(String buttons) {
        switch (buttons) {
            case "Previous":
                Assert.assertTrue(techGlobalPagination.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPagination.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException("The button is not defined!");
        }}


    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttons) {
        switch (buttons) {
            case "Previous":
                techGlobalPagination.previousButton.click();
                break;
            case "Next":
                techGlobalPagination.nextButton.click();
                break;
            default:
                throw new NotFoundException("The button is not defined!");
        }}


    @When("user clicks on {string} button till it becomes disabled")
    public void user_clicks_on_button_till_it_becomes_disabled(String string) {
        do techGlobalPagination.nextButton.click();
        while(techGlobalPagination.nextButton.isEnabled());
    }

    @Then("user should see {string} city with info below and an image")
    public void user_should_see_city_with_info_below_and_an_image(String city, DataTable citiesInfo) {
        for (int i = 0; i < citiesInfo.asList().size(); i++) {
            Assert.assertEquals(citiesInfo.asList().get(i), techGlobalPagination.cityInformationList.get(i).getText());
        }Assert.assertTrue(techGlobalPagination.cityImage.isDisplayed());
        techGlobalPagination.nextButton.click();}

    public static void main(String[] args) {
        TechGlobalPagination techGlobalPaginationPage1 = new TechGlobalPagination();
        for (int i = 0; i < techGlobalPaginationPage1.cityInformationList.size(); i++) {
            System.out.println(techGlobalPaginationPage1.cityInformationList.get(i).getText());
        }
    }




}
