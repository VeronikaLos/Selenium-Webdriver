package pages;

import org.openqa.selenium.WebDriver;

public class PastebinSite {
    WebDriver webDriver;

    public PastebinSite(WebDriver driver) {
        webDriver=driver;
    }

    public MainPage mainPage() { return new MainPage(webDriver);}
}
