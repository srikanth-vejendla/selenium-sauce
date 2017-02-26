package com.piit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by srikanthvejendla on 2/26/17.
 */
public class SampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception{
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "macOS 10.12");
        caps.setCapability("version", "51.0");
//        System.setProperty("webdriver.gecko.driver","/Users/srikanthvejendla/Desktop/geckodriver");
       driver = new RemoteWebDriver(new URL("https://pntsauce:194d0d1d-2b85-4eda-8249-9bcb3eecb16b@ondemand.saucelabs.com:443/wd/hub"),caps);
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginPNT() throws Exception{
        driver.get("http://forum.piit.us/");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[1]/input")).sendKeys("testuser");
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/dl/dd[2]/input")).sendKeys("test123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div/div[3]/p/input")).click();
    }
}
