package fr.eni.classeni.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
  private static Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(Settings.class.getResourceAsStream("settings.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperties(String key) {
    return properties.getProperty(key);
  }
}
