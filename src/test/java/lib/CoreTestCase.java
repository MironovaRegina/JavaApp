package lib;
import lib.ui.AuthPageObject;
import lib.ui.MWSearchPageObject;
import lib.ui.OnboardingPageObject;
import lib.ui.SearchPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Map;


public class CoreTestCase  {
    public RemoteWebDriver driver;
    public SearchPageObject searchPageObject;
    public OnboardingPageObject onboardingPageObject ;
    public MWSearchPageObject mwSearchPageObject;
    public AuthPageObject authPageObject;


    @BeforeEach
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        searchPageObject = new SearchPageObject(driver);
        onboardingPageObject =  new OnboardingPageObject(driver);
        mwSearchPageObject = new MWSearchPageObject(driver);
        authPageObject = new AuthPageObject(driver);
    }
    @AfterEach
    protected void tearDown() throws Exception {
     //  driver.quit();
    }
    // Метод для установки переменной окружения
}
