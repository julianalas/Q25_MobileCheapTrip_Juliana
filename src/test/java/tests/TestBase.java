package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();//создаем объект

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "4709993a");//Сообщаем, какой будет использоваться эмулятор/нативный дивайс
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");//указываем версию Android
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); //для запуска браузера
        //capabilities.setCapability("chromedriverExecutable", "");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://test70.lowcoststrip.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){driver.quit();}

}
