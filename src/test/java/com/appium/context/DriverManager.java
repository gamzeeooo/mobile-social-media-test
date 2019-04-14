package com.appium.context;

import com.appium.client.objects.DeviceCapabilities;
import com.appium.utils.Configuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public abstract class DriverManager extends Events
{
    protected static AppiumDriver driver;

    public static String mobileDeviceOneGeoLocation;
    public static String mobileDeviceSecondGeoLocation;

    public AppiumDriver createAndroidDriver(Configuration configuration, String deviceName) throws IOException
    {
        JSONCapability jsonCapability = new JSONCapability();

        DeviceCapabilities deviceCapabilities = jsonCapability.getDeviceCapability(configuration, deviceName);

        AppInfo appInfo = configuration.getAppInfo();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try
        {
            capabilities.setCapability("platformName", deviceCapabilities.getPlatformName());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceCapabilities.getPlatformVersion());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceCapabilities.getDeviceName());
            capabilities.setCapability("appPackage", appInfo.appPackage);
            capabilities.setCapability("appActivity", appInfo.appActivity);
            capabilities.setCapability("unicodeKeyboard", deviceCapabilities.getUnicodeKeyboard());
            capabilities.setCapability("autoGrantPermissions", deviceCapabilities.getAutoGrantPermissions());
            capabilities.setCapability("fastReset", deviceCapabilities.getFastReset());
            capabilities.setCapability("noSign", deviceCapabilities.getNoSign());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, deviceCapabilities.getNoReset());
            capabilities.setCapability("clearDeviceLogsOnStart", deviceCapabilities.getClearDeviceLogsOnStart());
            capabilities.setCapability("automationName", deviceCapabilities.getAutomationName());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        URL url;

        url = new URL("http://"
                .concat(deviceCapabilities.getDeviceServer())
                .concat(":")
                .concat(deviceCapabilities.getDevicePort())
                .concat("/wd/hub"));

        driver = new AndroidDriver(url, capabilities);

        return driver;
    }
}
