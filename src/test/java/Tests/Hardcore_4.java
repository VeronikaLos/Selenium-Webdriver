package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CloudeSite;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hardcore_4 {
    WebDriver webDriver;
    CloudeSite website;
    WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 30, 500);

        website = new CloudeSite(webDriver);
        // открыть https://cloud.google.com/
        webDriver.get("https://cloud.google.com/");

        System.out.println("Step 2: Click Search Button");
        website.cloudMainPage().clickSearchButton("Google Cloud Platform Pricing Calculator");

        System.out.println("Step 3: Find and Click Link");
        website.cloudMainPage().findAndClikFirstLink();

        System.out.println("Step 4: Chose COMPUTE ENGINE");
        website.cloudMainPage().choseSection();

        System.out.println("Step 5: Input Nubmer of Instances");
        website.cloudMainPage().inputNumberOfInstances("4");

        System.out.println("Step 6: Choose Operating System");
        website.cloudMainPage().chooseOpSystem();

        System.out.println("Step 7: Find VM Class");
        website.cloudMainPage().findVMClassfield();

        System.out.println("Step 8: Find Series Field");
        website.cloudMainPage().findFieldSeries();

        System.out.println("Step 9: Choose Series");
        website.cloudMainPage().chooseSeries();

        System.out.println("Step 10: Machine Type Field");
        website.cloudMainPage().findMachineTypeField();

        System.out.println("Step 11: Choose Machine Type");
        website.cloudMainPage().chooseMachineType();

        System.out.println("Step 12: Add GPU");
        website.cloudMainPage().clickAddGPU();

        System.out.println("Step 13: Choose GPU check-box");
        website.cloudMainPage().findAndChooseGPUs();

        System.out.println("Step 14: Click Add to Estimate");
        website.cloudMainPage().clickaddtoEstimate();

        System.out.println("Step 15: Wait For Calculate");
        website.saveResultPage().waitForCalculate();

       //System.out.println("Step 16: Click Email Estimate");
        //website.cloudMainPage().clickEmailEstimate();

        Thread.sleep(2000);

        String checkTotalCost = webDriver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(14)>div")).getText();
        String premiumInCalculator = checkTotalCost.replaceAll("Estimated Component Cost: ","").replaceAll(" per 1 month","");

        ((JavascriptExecutor)webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));

        webDriver.get("https://10minutemail.net/?lang=ru");

        String CopyEmail = webDriver.findElement(By.xpath("//*[@id='fe_text']")).getAttribute("value");

        webDriver.switchTo().window(tabs.get(0));


        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));

        webDriver.switchTo().frame(0);

        Thread.sleep(2000);

        WebElement EmailEstimateButton = webDriver.findElement(By.xpath("//*[@id='email_quote']"));
        EmailEstimateButton.click();

        Thread.sleep(2000);

        new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath("//*[@class='md-dialog-container ng-scope']")));

        Thread.sleep(2000);

        System.out.println( "Copy Email");
        WebElement EmailField = webDriver.findElement(By.cssSelector("div:nth-child(3)>md-input-container>input"));
        EmailField.click();
        EmailField.sendKeys(CopyEmail);

        Thread.sleep(2000);

        System.out.println( "Send Email");
        WebElement SendEmailButton = webDriver.findElement(By.cssSelector("md-dialog-actions>button.md-raised.md-primary.cpc-button.md-button.md-ink-ripple"));
        SendEmailButton.click();

        Thread.sleep(2000);

        webDriver.switchTo().window(tabs.get(1));

        System.out.println( "Wait Email");
        new WebDriverWait(webDriver,180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Google Cloud Platform Price Estimate']")));

        Thread.sleep(4000);

        WebElement OpenEmail = webDriver.findElement(By.xpath("//a[text()='Google Cloud Platform Price Estimate']"));
        OpenEmail.click();

        System.out.println( "Open Email");
        Thread.sleep(2000);

        System.out.println("Wait Frame");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("ins>ins>ins>iframe#aswift_4")));

       System.out.println("Step Close Pop-up");
       webDriver.switchTo().frame("ad_iframe");
       //WebElement ClosePopUp = webDriver.findElement(By.cssSelector("#dismiss-button>div>svg>path:nth-child(1)"));
       WebElement ClosePopUp = webDriver.findElement(By.xpath("//div[@id='dismiss-button']"));
       ClosePopUp.click();

        webDriver.switchTo().defaultContent();

        System.out.println("Step Check Email");
        String PremiumInEmail = webDriver.findElement(By.cssSelector("td:nth-child(2)>h3")).getText();

        System.out.println(CopyEmail);
        System.out.println(PremiumInEmail);
        System.out.println(premiumInCalculator);
    }


    @Test
    public void chieckTotalinEmail() {
        // Как сделать проверку значений из 2-ух табок?
        System.out.println("Step Check Email");
        //WebElement checkTotalCost = webDriver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b"));
        String PremiumInEmail = webDriver.findElement(By.cssSelector("td:nth-child(2)>h3")).getText();

        Assert.assertEquals(premiumInCalculator,PremiumInEmail);

        //((JavascriptExecutor)webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(0));

        webDriver.switchTo().frame("myFrame");
        String checkTotalCost = webDriver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")).getText();
        String premiumInCalculator = checkTotalCost.replaceAll("Estimated Component Cost: ","").replaceAll(" per 1 month","");


        //WebElement PremiumInEmail
       // String checkTotalCost = webDriver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")).getText();
        //String checkTotalCost = webDriver.findElement(By.xpath("//*[@id='tab1']/div/div/table/tbody/tr[2]/td/table/tbody/tr[1]/td[4]")).getText();
        //String premiumInCalculator = checkTotalCost.replaceAll("Estimated Component Cost: ","").replaceAll(" per 1 month","");
        //String PremiumInEmail = webDriver.findElement(By.cssSelector("td:nth-child(2)>h3")).getText();
        Assert.assertEquals(PremiumInEmail,premiumInCalculator);
    }


    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); }
}
