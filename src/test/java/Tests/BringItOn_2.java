package Tests;

import Waits.CustomConditions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PastebinSite;

import java.util.List;

public class BringItOn_2 {
    WebDriver webDriver;
    PastebinSite website;
    WebDriverWait wait;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30, 500);

        website = new PastebinSite(webDriver);
        // открыть pastebin.com
        webDriver.get("https://pastebin.com/");

        System.out.println("Step 1: Enter Code");
        website.mainPage().enterCode
                ("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force");

        System.out.println("Step 2: Open Syntax values");
        website.mainPage().openSyntax();

        System.out.println("Step 3: Chose Syntax value");
        website.mainPage().ChoseSyntaxValue();

        System.out.println("Step 4: Open Expiration values");
        website.mainPage().openExpiration();

        System.out.println("Step 5: Chose Expiration value");
        website.mainPage().ChoseExpirationValue();

        System.out.println("Step 4: Enter name");
        website.mainPage().InputTitle("how to gain dominance among developer");

        System.out.println("Step 5: Save new paste");
        website.mainPage().saveNewPaste();

        System.out.println("Step 6: Wait For search Results");
        website.searchResultPage().waitForSaveInput();
    }

    @Test
    public void testTitle() {
        WebElement titleCheck = webDriver.findElement(By.xpath("//h1[text()='how to gain dominance among developer']"));
        System.out.println("Verify that title coincides with entered by user");
        Assert.assertEquals(titleCheck.getText(), "how to gain dominance among developer");
    }

    @Test
    public void testSyntax() {
        String Actualtext = webDriver.findElement(By.xpath("//a[text()='Bash']")).getText();
        Assert.assertEquals(Actualtext, "Bash");
        System.out.println("Syntax is matching");
    }

    @Test
    public void searchCode() {
        List<WebElement> searchResults = webDriver.findElements(By.className("'source' and contains (.,'git config ') and contains (.,'name')]"));
        System.out.println("Search code ");
    }


    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}