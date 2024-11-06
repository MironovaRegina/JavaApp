
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import lib.CoreTestCase;

public class FirstTest extends CoreTestCase {

    @Test
    public void testFindWord(){
        onboardingPageObject.skipOnboarding();
        String word = "Java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(word);

        Assertions.assertTrue(driver.findElements(By.xpath("//*[contains(@text, '"+word+"')]")).size()>3);
        searchPageObject.clearButtonClick();
        Assertions.assertTrue(searchPageObject.waitForCancelButtonToDisappear());
    }


    @Test
    public void testSwipeOnbording(){
        onboardingPageObject.loadOnboarding();
        Assertions.assertEquals(onboardingPageObject.swipeOnboardng(),"New ways to explore");
        Assertions.assertEquals(onboardingPageObject.swipeOnboardng(),"Reading lists with sync");
        Assertions.assertEquals(onboardingPageObject.swipeOnboardng(),"Send anonymous data");
        onboardingPageObject.getStartedOnboarding();
        searchPageObject.initSearchInput();
   }

    @Test
    public void testTitleIsPresentTest(){
        onboardingPageObject.skipOnboarding();
        String word = "Java";
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(word);
        Assertions.assertTrue(searchPageObject.isTitleofArticle());
    }

    @Test
    @DisplayName("Первый тест")
    public void TestMWDeletePage() {
        mwSearchPageObject.openWikiWebPageForMobileWeb();
        mwSearchPageObject.findArticle("Java");
        authPageObject.clickAuthButton();
        authPageObject.enterLoginData("Test20241106","12345TEST");
        mwSearchPageObject.addToWatch();
        mwSearchPageObject.findinArticle("C++");
        mwSearchPageObject.addToWatch();
        mwSearchPageObject.deleteFirstArticle();
        System.out.println("количество"+mwSearchPageObject.countList());
        Assertions.assertTrue(mwSearchPageObject.countList() ==1);
    }


}
