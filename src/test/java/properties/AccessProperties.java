package properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AccessProperties {

    public void readProperties() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/Config.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        System.out.println(properties.getProperty("browser"));
    }
}
