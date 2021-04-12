package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudMainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    WebElement SearchSearch;

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    WebElement FindAndClikLink;

    @FindBy(css = "md-pagination-wrapper > .md-tab:nth-child(1) .hexagon-in2")
    WebElement ChoseSection;

    @FindBy(id = "input_65")
    WebElement NumberField;

    @FindBy(css = "#select_value_label_58 .md-text")
    WebElement FindOsField;

    @FindBy(css = "#select_option_67 > .md-text")
    WebElement ChooseOsSystem;

    @FindBy(css = "#select_value_label_59 > span:nth-child(1)")
    WebElement FindVMClassField;

    @FindBy(css = "#select_option_80 > .md-text")
    WebElement ChooseVmClass;

//     @FindBy(css = "#select_value_label_62 > .md-select-icon")
//    WebElement FindMachinaTypeField;
//
//    @FindBy(css = "#select_option_239 > .md-text")
//    WebElement ChooseMachineType;

    //@FindBy(css = "#select_value_label_61 > .md-select-icon")
    @FindBy(css = "#select_value_label_61 > span:nth-child(1)")
    WebElement FindSeriesField;

    //@FindBy (css = "select_option_190 > .md-text")
    //@FindBy(css = "md-option[value = 'n1']")
    //@FindBy (id = "select_option_190")
    @FindBy(xpath = "//md-option[@value='n1']")
    WebElement ChoseSeries;

    @FindBy(css = "#select_value_label_62 > span:nth-child(1)")
    WebElement FindMachineTypeField;

    //@FindBy(id = "select_option_747")
    //@FindBy(css = "select_option_747 > .md-text")
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement ChooseMachineTypeField;

    @FindBy(css = "#select_value_label_63 .md-text")
    WebElement AddGPU;

    @FindBy(css = "#select_option_198 > .md-text")
    WebElement NumberOfGPU;

    @FindBy(css = ".layout-row:nth-child(6) .md-label")
    WebElement ChooseNumberOfGpu;

    //@FindBy(css = ".layout-align-end-start:nth-child(15) > .md-raised")
    @FindBy(css = "div:nth-child(1)>form>div.layout-align-end-start.layout-row>button")
    WebElement ButtonAddToEstimate;

    @FindBy(id = "email_quote")
    WebElement ButtonEmailEstimate;


    public CloudMainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearchButton(String text) {
        SearchSearch.click();
        SearchSearch.sendKeys(text);
        SearchSearch.sendKeys(Keys.RETURN);
    }

    public void findAndClikFirstLink() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='gs-webResult gs-result']")));
        FindAndClikLink.click();
    }

    public void choseSection() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));
        webDriver.switchTo().frame(0);
        ChoseSection.click();
    }

    public void inputNumberOfInstances(String text) {
        NumberField.click();
        NumberField.sendKeys(text);
    }

    public void chooseOpSystem() {
        FindOsField.click();
        ChooseOsSystem.click();
    }

    //FindAndClikLink.get(0).click(); }

    public void findVMClassfield() {
        FindVMClassField.click();
        ChooseVmClass.click();
    }

    public void findFieldSeries() {
        FindSeriesField.click();
    }

    public void chooseSeries() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@value='n1']")));
        ChoseSeries.click();
    }

    public void findMachineTypeField() {
        FindMachineTypeField.click();
    }


    public void chooseMachineType() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")));
        ChooseMachineTypeField.click();
    }

//    public void chooseMachineType() {
//    FindMachinaTypeField.click();
//    ChooseMachineType.click();}


    public void clickAddGPU() {
        AddGPU.click();
    }

    public void findAndChooseGPUs() {
        NumberOfGPU.click();
        ChooseNumberOfGpu.click();
    }

    public void clickaddtoEstimate() {
        ButtonAddToEstimate.click();
    }

    public void clickEmailEstimate() {
        ButtonEmailEstimate.click();
    }


}
