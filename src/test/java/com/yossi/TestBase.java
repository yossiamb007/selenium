package com.yossi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.yossi.ui.common.WebAction;

public class TestBase {
    WebAction webAction;
    @BeforeSuite
    @Parameters({"browserType", "headless"})
    public void setUp(@Optional("chrome") String browserType, @Optional("false") boolean headless) {
        initBrowser(browserType, headless);
    }

    private void initBrowser(String browserType, boolean headless) {
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                if (headless) {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    driver = new FirefoxDriver(options);
                }else {
                    driver = new FirefoxDriver();
                }
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                if (headless) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
                    driver = new ChromeDriver(chromeOptions);
                }else {
                    driver = new ChromeDriver();
                }
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) edgeOptions.addArguments("--headless=new");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                System.out.println("your browser type: " + browserType + " is not valid");
        }
        webAction = new WebAction(driver);
    }
}
