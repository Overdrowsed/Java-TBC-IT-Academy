package handler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RectangleDatabaseHandler {
    private static Logger logger = LogManager.getLogger();

    private static final String RECTANGLE_DATABASE_FILE = "rectangles.json";

    private volatile static RectangleDatabaseHandler singleton = null;

    protected long lastModified;

    private static URL url = null;

    private String rectangleDatabase;

    private RectangleDatabaseHandler(URLConnection connection) throws IOException, URISyntaxException {
        this.lastModified = connection.getLastModified();

        rectangleDatabase = Files.readString(Path.of(url.toURI()));
    }

    private static RectangleDatabaseHandler refreshIfUpdated() throws IOException, URISyntaxException {
        if (url == null) {
            url = RectangleDatabaseHandler.class.getClassLoader().getResource(RECTANGLE_DATABASE_FILE);
        }
        if (url == null) {
            throw new IOException("Rectangle database not found");
        }
        
        URLConnection connection = url.openConnection();
        
        long lastModified = connection.getLastModified();

        if (singleton == null || lastModified > singleton.lastModified) {
            synchronized (RECTANGLE_DATABASE_FILE) {
                if (singleton == null || lastModified > singleton.lastModified) {
                    logger.info("Reloading rectangle database");
                    singleton = new RectangleDatabaseHandler(connection);
                }
            }
        }
        
        return singleton;
    }

    public static String getRectangleDatabase() throws IOException, URISyntaxException{
        return refreshIfUpdated().rectangleDatabase;
    }
}
