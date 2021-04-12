package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CloudeSite;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HurtMePlenty_3 {
    WebDriver webDriver;
    CloudeSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
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
    }

    @Test
    public void testVmClassName() {
        WebElement vmClassName = webDriver.findElement(By.cssSelector(".ng-scope>.md-list-item-text"));
        System.out.println("Verify Vm Class Name");
        Assert.assertEquals(vmClassName.getText(), "VM class: regular");
    }

    @Test
    public void Instancetype() {
        WebElement vmClassName = webDriver.findElement(By.cssSelector(".md-1-line:nth-child(6) > .md-list-item-text"));
        System.out.println("Verify Vm Class Name");
        Assert.assertEquals(vmClassName.getText(), "Instance type: n1-standard-4");
    }

    @Test
    public void Region() {
        WebElement vmClassName = webDriver.findElement(By.cssSelector(".md-1-line:nth-child(8) > .md-list-item-text"));
        System.out.println("Verify Region");
       // Assert.assertEquals(vmClassName.getText(), "Region: Iowa");
        Assert.assertTrue("Incorrect Region", vmClassName.getText().contains("Region: Iowa"));
    }

    @Test
    public void CheckCost() {
        System.out.println("Verify Cost");
        WebElement checkTotalCost = webDriver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b"));
        Assert.assertEquals(checkTotalCost.getText(), "Total Estimated Cost: USD 388.36 per 1 month");

        //WebElement checkTotalCost = webDriver.findElement(By.cssSelector(".md-list-item-text > .ng-binding"));
        //String checkTotalCost = webDriver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(14)>div")).getText();
        //String premiumInCalculator = checkTotalCost.replaceAll("Estimated Component Cost: ","").replaceAll(" per 1 month","");
        //WebElement vmClassName = webDriver.findElement(By.cssSelector(".md-title > .ng-binding"));
        //Assert.assertTrue("Not 388.36", checkTotalCost.getText().contains("388.36"));
        //Assert.assertTrue("Estimated Component Cost", vmClassName.getText().contains("Estimated Component Cost"));
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit(); }
}
