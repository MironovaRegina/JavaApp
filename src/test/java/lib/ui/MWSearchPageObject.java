package lib.ui;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class MWSearchPageObject extends MainPageObject{
    private static final String

    SKIP_BUTTON = "//*[contains(@text, 'SKIP')]",
    GET_STARTED = "//*[contains(@text, 'GET STARTED')]",
    TEXT_VIEW = "org.wikipedia:id/primaryTextView";
    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openWikiWebPageForMobileWeb()
    {
        if(Platform.getInstance().isMW())
            driver.get("http://wikipedia.org");
        else {System.out.println("Не применим для платформы");

        }
    }
    public  void findArticle(String word)
    {
        this.driver.findElement(By.id("searchInput")).sendKeys(word);
        this.driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();
    }

    public  void addToWatch()
    {
        waitForElementPresent(By.xpath("//*[@id=\"ca-watch\"]/span[1]"),"элемент не найден",Duration.ofSeconds(5)).click();
    }
    public  void findinArticle(String word)
    {
        waitForElementPresent(By.xpath("//*[@id=\"searchIcon\"]/span[1]"),"элемент не найден",Duration.ofSeconds(5)).click();
        waitForElementPresent(By.xpath("//input[@class='search mf-icon-search']"),"элемент не найден",Duration.ofSeconds(5)).sendKeys(word);
        waitForElementPresent(By.xpath("//li[1]//div"),"элемент не найден",Duration.ofSeconds(5)).click();
    }
    public  void deleteFirstArticle()
    {
        this.waitForElementPresent(By.xpath("//*[@id=\"mw-mf-main-menu-button\"]/span[1]"),"элемент не найден",Duration.ofSeconds(5)).click();
        this.waitForElementPresent(By.xpath("//*[@id=\"p-personal\"]/li[3]/a"),"элемент не найден",Duration.ofSeconds(5)).click();
        this.waitForElementPresent(By.xpath("//*[@id=\"mw-content-text\"]/ul/li[1]/a[2]"),"элемент не найден",Duration.ofSeconds(5)).click();
    }
    public int countList()
    {
        this.waitForElementPresent(By.xpath("//*[@id=\"mw-mf-main-menu-button\"]/span[1]"),"элемент не найден",Duration.ofSeconds(5)).click();
        this.waitForElementPresent(By.xpath("//*[@id=\"p-personal\"]/li[3]/a"),"элемент не найден",Duration.ofSeconds(5)).click();
        return this.driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/ul/li[@class='page-summary with-watchstar']")).size();
    }

}
