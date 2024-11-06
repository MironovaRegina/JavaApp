package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_ANDROID = "Android";
    private static final String PLATFORM_MW = "MW";
    private static String APPIUM_URL = "http://127.0.0.1:4723";

    private static Platform instance;

    private Platform(){}
    public static  Platform getInstance()
    {
        if (instance == null){
            instance = new Platform();
        }
        return  instance;
    }
    public RemoteWebDriver getDriver() throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()){
        return new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL(APPIUM_URL), this.getAndroidCapabilities());
        }else return new ChromeDriver(this.getMWChromeOptions());
    }
    public boolean isAndroid(){return isPlatform(PLATFORM_ANDROID);}
    public boolean isMW(){return isPlatform(PLATFORM_MW);}
    public boolean isPlatform(String Platform)
    {
        String myPlatform = "MW";//this.getPlatformVar();
        return myPlatform.equals(Platform);
    }
    private String getPlatformVar(){return System.getenv("PLATFORM");}

    private UiAutomator2Options getAndroidCapabilities()
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName","Android");
        options.setCapability("deviceName","Pixel8");
        options.setCapability("platformVersion","10.0");
        options.setCapability("automationName","UiAutomator2");
        options.setCapability("appPackage","org.wikipedia");
        options.setCapability("appActivity",".main.MainActivity");
        options.setApp(System.getProperty("user.dir") + "/apks/org.wikipedia_1.apk");
        return options;
    }
    private ChromeOptions getMWChromeOptions() {
        // Настройка параметров устройства для мобильной эмуляции
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0 Mobile/15E148 Safari/604.1");

        // Настройка ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("window-size=360,640");

        return chromeOptions;
    }
}
