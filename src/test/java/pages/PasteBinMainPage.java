package pages;

import Waits.CustomConditions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PasteBinMainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "postform-text")
    WebElement searchInputField;

    @FindBy(id="select2-postform-format-container")
    WebElement SearchSyntaxHighighting;

    @FindBy(xpath = "//li[text()='Bash']")
    WebElement ChoseSyntaxValue;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement SearchExpirationField;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement ChoseExpirationValue;

    @FindBy(xpath = "//input[@id='postform-name']")
    WebElement searchInputNameField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement ClickButton;

    @FindBy(xpath ="//div[text()=' Your guest paste has been posted. If you ']")
    WebElement CheckResultSave;


    public PasteBinMainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }


    public void enterCode(String text) {
        searchInputField.click();
        searchInputField.sendKeys(text);
    }

    public void openSyntax() { SearchSyntaxHighighting.click();}

    public void ChoseSyntaxValue () {ChoseSyntaxValue.click();}

    public void openExpiration() {
        SearchExpirationField.click(); }

    public void ChoseExpirationValue() {
        ChoseExpirationValue.click();
    }

    public void InputTitle(String text) {
        searchInputNameField.click();
        searchInputNameField.clear();
        searchInputNameField.sendKeys(text);
    }

    public void saveNewPaste() {
        ClickButton.click();
        new WebDriverWait(webDriver, 10).until(CustomConditions.jQueryAJAXsCompleted());
    }

}
