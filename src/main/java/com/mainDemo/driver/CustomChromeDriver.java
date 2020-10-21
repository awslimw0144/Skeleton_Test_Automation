//package com.mainDemo.driver;
//
//import net.thucydides.core.webdriver.DriverSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.util.HashMap;
//
//public class CustomChromeDriver implements DriverSource {
//
//    @Override
//    public WebDriver newDriver() {
//        try{
//            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//            chromePrefs.put("plugins.always_open_pdf_externally", true);
//            chromePrefs.put("profile.default_content_settings.popups", 0);
//            ChromeOptions options = new ChromeOptions();
//            options.setExperimentalOption("prefs", chromePrefs);
//            options.addArguments("start-maximized");
//            options.addArguments("disable-infobars");
//            DesiredCapabilities cap = DesiredCapabilities.chrome();
//            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            cap.setCapability(ChromeOptions.CAPABILITY, options);
//            return new ChromeDriver(cap);
//        } catch (Exception e){
//            throw new Error(e);
//        }
//    }
//
//    @Override
//    public boolean takesScreenshots() {
//        return false;
//    }
//}
