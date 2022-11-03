import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

    private static Map<String, String> configMap = new HashMap<>();

    public static void loadConfig() throws URISyntaxException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(Config.class.getResource("config.properties").toURI())));
        configMap = (Map<String, String>) properties.clone();
    }

    public static String getConfig(String key) {
        return configMap.get(key);
    }
}
