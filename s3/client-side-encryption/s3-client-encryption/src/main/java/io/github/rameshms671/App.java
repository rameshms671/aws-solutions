package io.github.rameshms671;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {
        try {
            logger.info("Application starts");

            Handler handler = new Handler();
            handler.sendRequest();

            logger.info("Application ends");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
