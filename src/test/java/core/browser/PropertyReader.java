package core.browser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
public class PropertyReader {

        private static final Properties defaultProps = new Properties();

        static {
            try {
                Path path = Paths.get("src/test/resources/config.properties");
                Files.newBufferedReader(path);
                defaultProps.load(Files.newBufferedReader(path));
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        public static String get(String key){

            return (String)defaultProps.get(key);
        }





}

