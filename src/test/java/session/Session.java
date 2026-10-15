package session;

import device.FactoryDevice;
import io.appium.java_client.AppiumDriver;

public class Session {
    private static Session session = null;
    private final AppiumDriver device;

    private Session() {
        device = FactoryDevice.make("android").create();
    }

    public static Session getSession() {
        if(session == null) {
            session = new Session();
        }

        return session;
    }

    public AppiumDriver getDevice() {
        return device;
    }

    public void closeSession() {
        if (device != null) {
            device.quit();
            session = null;
        }
    }

}
