package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class NewPaste {
    WebDriver webDriver;
    PastebinSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);

        website = new PastebinSite (webDriver);
        // открыть pastebin.com
        webDriver.get("https://pastebin.com/");

        System.out.println("Step 1: Enter Code");
        website.mainPage().enterCode("Hello from WebDriver");

        System.out.println("Step 2: Open Expiration values");
        website.mainPage().openExpiration();

        System.out.println("Step 3: Chose Expiration values");
        website.mainPage().ChoseExpirationValue();

        System.out.println("Step 4: Enter name");
        website.mainPage().searchInputNameField("helloweb");

        System.out.println("Step 5: Save new paste");
        website.mainPage().saveNewPaste();
    }

    @Test
    public void textAboutAddIsPresent() throws InterruptedException {
        System.out.println("Check save result");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("https://pastebin.com/"));
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}