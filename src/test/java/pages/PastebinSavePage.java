package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PastebinSavePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public PastebinSavePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForSaveInput() {
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("container")));
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='how to gain dominance among developer']")));
                //(By.id<locator>));
    }

    //public void openLinkFromSearch() {
        //webDriver.findElement(By.xpath("//*[@id='select_394']"));

        //public void openLinkFromSearch(String linkname) {
//    webDriver.findElement(By.linkText("linkname")).click();
        //     List<WebElement> links = webDriver.
        //           findElements(By.ByXPath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a[@target='_self']"));
        // for (WebElement link : links) {
        //  WebElement searchLink = link.findElement(By.ByXPath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a[@target='_self']"));
//          //  if (link.getText().contains(linkname))
        // if (searchLink.getText().contains(linkname))
        //     searchLink.click();
//}

    }