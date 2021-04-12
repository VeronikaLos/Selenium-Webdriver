package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_3 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {driver = new ChromeDriver();
        driver.get("https://paste.ee/");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }


    @Test
    public void Paste1() throws InterruptedException {

        driver.findElement(By.xpath("//label[text() = 'Expiration']/following::*[@role='combobox'][1]"))
                .click();

        driver.findElement(By.xpath("//li[text()='1 hour']"))
                .click();

        driver.findElement(By.xpath("//label[text() = 'Paste']/following::*[@role='combobox']"))
                .click();

        driver.findElement(By.xpath("//li[text() = 'Bash']"))
                .click();

        WebElement text = driver.findElement(By.xpath("//*[@name = 'paste[section1][contents]']"));
        text.sendKeys("git config --global user.name \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        driver.findElement(By.id("paste[section1][name]"))
                .sendKeys("how to gain dominance among developers");

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@class = 'btn btn-primary mousetrap']"));
        buttonSubmit.click();

        new WebDriverWait(driver,10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@class = 'section-title']")));


        WebElement titleCheck = driver.findElement(By.xpath("//*[@class = 'section-title']"));
        System.out.println("Verify that title coincides with entered by user");
        Assert.assertEquals(titleCheck.getText(), "how to gain dominance among developers");




        WebElement syntaxCheck = driver.findElement(By.xpath("//div[@class = 'col-sm-12 section-container']"));

        System.out.println("Verify that syntax coincides with selected by user");
        Assert.assertEquals(syntaxCheck.getAttribute("data-syntax"), "bash");


        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


        WebElement codeCheck = driver.findElement(By.xpath("//*[contains(text(), 'New Sheriff in Town')]"));
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        System.out.println("Verify that text coincides with entered one");
        Assert.assertTrue(codeCheck.isDisplayed(), "text value is absent");

        Thread.sleep(10000);


    }
    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {

        driver.quit();
        driver = null;
    }
}