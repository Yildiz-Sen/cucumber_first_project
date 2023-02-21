package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalPagination {

    public TechGlobalPagination() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(id = "main_heading")
    public WebElement paginationLogo;

    @FindBy(id = "sub_heading")
    public WebElement paginationSubheading;

    @FindBy(css = "p[id='content']")
    public WebElement paginationParagraph;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(css = "div[class*='pagBodyData']>p")
    public List<WebElement> cityInformationList;

    @FindBy(css = "img[class*='city']")
    public  WebElement cityImage;




}
