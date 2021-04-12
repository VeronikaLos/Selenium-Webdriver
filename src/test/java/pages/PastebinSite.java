package pages;

import org.openqa.selenium.WebDriver;

public class PastebinSite {
    WebDriver webDriver;

    public PastebinSite(WebDriver driver) {
        webDriver = driver;
    }

    public PasteBinMainPage mainPage() {
        return new PasteBinMainPage(webDriver);
    }

    public PastebinSavePage searchResultPage() {
        return new PastebinSavePage(webDriver);
    }
}

