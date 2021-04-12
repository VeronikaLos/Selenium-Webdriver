package pages;

import org.openqa.selenium.WebDriver;

public class CloudeSite {
    WebDriver webDriver;

    public CloudeSite(WebDriver driver) {
        webDriver = driver;
    }

    public CloudMainPage cloudMainPage() {
        return new CloudMainPage(webDriver);
    }

    public CloudSavePage saveResultPage() {
        return new CloudSavePage(webDriver);
    }
}

