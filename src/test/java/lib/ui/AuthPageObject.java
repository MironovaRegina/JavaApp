package lib.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class AuthPageObject extends MainPageObject{
    private static final String


    LOGIN_BUTTON = "//*[@id=\"mw-mf-main-menu-button\"]/span[1]",
    LOGIN_INPUT = "//*[@id=\"wpName1\"]",
    PASSWORD_INPUT ="//*[@id=\"wpPassword1\"]",
    SUBMIT_BUTTON="//*[@id=\"wpLoginAttempt\"]";

    public AuthPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    public  void clickAuthButton()
    {
        this.waitForElementPresent(By.xpath(LOGIN_BUTTON),"элемент не найден",Duration.ofSeconds(5)).click();
        this.waitForElementPresent(By.xpath("//*[@id='p-personal']/li/a"),"элемент не найден",Duration.ofSeconds(5)).click();
    }
    public  void enterLoginData(String login,String password)
    {
        this.waitForElementPresent(By.xpath(LOGIN_INPUT),"элемент не найден",Duration.ofSeconds(5)).sendKeys(login);
        this.waitForElementPresent(By.xpath(PASSWORD_INPUT),"элемент не найден",Duration.ofSeconds(5)).sendKeys(password);
        this.waitForElementPresent(By.xpath(SUBMIT_BUTTON),"элемент не найден",Duration.ofSeconds(5)).click();

    }
}
