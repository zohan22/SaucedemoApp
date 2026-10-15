package device;

import java.util.HashMap;
import java.util.Map;

public class FactoryDevice {
    public static IDevice make(String deviceType) {
        Map<String, IDevice> deviceMap = new HashMap<>();
        deviceMap.put("android", new Android());
        deviceMap.put("ios", new IOS());
        deviceMap.put("cloud", new Cloud());
        return deviceMap.containsKey(deviceType.toLowerCase()) ?
            deviceMap.get(deviceType.toLowerCase()) :
            new Android();
    }
}
