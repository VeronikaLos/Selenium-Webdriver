package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudSavePage {

    WebDriver webDriver;
    WebDriverWait wait;

    public CloudSavePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForCalculate() {
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("container")));
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultBlock")));
        //(By.id<locator>));
    }
}