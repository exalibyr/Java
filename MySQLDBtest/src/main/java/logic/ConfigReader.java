package logic;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

    static Config getFromFile(){
        try (InputStream in = Files.newInputStream(Paths.get("config.properties"))){
            Properties properties = new Properties();
            properties.load(in);
            Config config = new Config(properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
            return config;
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }
}
