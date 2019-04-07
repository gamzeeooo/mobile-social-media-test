package context;

import client.objects.DeviceCapabilities;
import org.json.JSONObject;
import utils.Configuration;
import utils.Read;

public class JSONCapability
{
    public DeviceCapabilities getDeviceCapability(Configuration configuration, String objectName)
    {
        String jsonPath = System.getProperty("user.dir").concat("/src/test/resources/%sTestDevices.json");

        String deviceCapability = Read.readFile(String.format(jsonPath, configuration.getOperator()));

        JSONObject obj = new JSONObject(deviceCapability);

        DeviceCapabilities capabilities = new DeviceCapabilities();

        String platformName = obj.getJSONObject(objectName).getString("platformName");
        String platformVersion = obj.getJSONObject(objectName).getString("platformVersion");
        String deviceName = obj.getJSONObject(objectName).getString("deviceName");
        String uid = obj.getJSONObject(objectName).getString("uid");
        String deviceServer = obj.getJSONObject(objectName).getString("deviceServer");
        String devicePort = obj.getJSONObject(objectName).getString("devicePort");
        Boolean noReset = obj.getJSONObject(objectName).getBoolean("noReset");
        Boolean unicodeKeyboard = obj.getJSONObject(objectName).getBoolean("unicodeKeyboard");
        Boolean autoGrantPermissions = obj.getJSONObject(objectName).getBoolean("autoGrantPermissions");
        Boolean fastReset = obj.getJSONObject(objectName).getBoolean("fastReset");
        Boolean noSign = obj.getJSONObject(objectName).getBoolean("noSign");
        Boolean clearDeviceLogsOnStart = obj.getJSONObject(objectName).getBoolean("clearDeviceLogsOnStart");
        String automationName = obj.getJSONObject(objectName).getString("automationName");

        capabilities.setPlatformName(platformName);
        capabilities.setPlatformVersion(platformVersion);
        capabilities.setDeviceName(deviceName);
        capabilities.setUid(uid);
        capabilities.setDeviceServer(deviceServer);
        capabilities.setDevicePort(devicePort);
        capabilities.setNoReset(noReset);
        capabilities.setUnicodeKeyboard(unicodeKeyboard);
        capabilities.setAutoGrantPermissions(autoGrantPermissions);
        capabilities.setFastReset(fastReset);
        capabilities.setNoSign(noSign);
        capabilities.setClearDeviceLogsOnStart(clearDeviceLogsOnStart);
        capabilities.setAutomationName(automationName);

        return capabilities;
    }
}