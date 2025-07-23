package Utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public final class ConfigReaderWriter {
    private static final Properties properties = new Properties();
    private static final ReentrantLock lock = new ReentrantLock();

    static {
        loadProperties();
    }

    private ConfigReaderWriter() {}

    private static void loadProperties() {
        lock.lock();
        try (InputStream input = ConfigReaderWriter.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new ConfigurationException("config.properties not found in classpath", null);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new ConfigurationException("Failed to load config.properties", e);
        } finally {
            lock.unlock();
        }
    }


    public static String getPropKey(String key) {
        lock.lock();
        try {
            return properties.getProperty(key);
        } finally {
            lock.unlock();
        }
    }

    public static void setPropKey(String key, String value) {
        lock.lock();
        try (OutputStream output = new FileOutputStream("src/test/resources/config.properties")) {
            properties.setProperty(key, value);
            properties.store(output, "Updated configuration");
        } catch (IOException e) {
            throw new ConfigurationException("Failed to update config.properties", e);
        } finally {
            lock.unlock();
        }
    }

    private static class ConfigurationException extends RuntimeException {
        public ConfigurationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
