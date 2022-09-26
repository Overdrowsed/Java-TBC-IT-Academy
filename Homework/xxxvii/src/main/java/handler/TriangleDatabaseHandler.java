package handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleDatabaseHandler {
    private static Logger logger = LogManager.getLogger();

    private static final String TRIANGLE_DATABASE_FILE = "triangles.xml";

    private volatile static TriangleDatabaseHandler singleton = null;

    protected long lastModified;

    private static URL url = null;

    private InputStream triangleDatabase;

    private TriangleDatabaseHandler(URLConnection connection) throws IOException {
        this.lastModified = connection.getLastModified();

        triangleDatabase = connection.getInputStream();
    }

    private static TriangleDatabaseHandler refreshIfUpdated() throws IOException {
        if (url == null) {
            url = TriangleDatabaseHandler.class.getClassLoader().getResource(TRIANGLE_DATABASE_FILE);
        }
        if (url == null) {
            throw new IOException("Triangle database not found");
        }
        
        URLConnection connection = url.openConnection();
        
        long lastModified = connection.getLastModified();

        if (singleton == null || lastModified > singleton.lastModified) {
            synchronized (TRIANGLE_DATABASE_FILE) {
                if (singleton == null || lastModified > singleton.lastModified) {
                    logger.info("Reloading triangle database");
                    singleton = new TriangleDatabaseHandler(connection);
                }
            }
        }
        
        return singleton;
    }

    public static InputStream getTriangleDatabase() throws IOException {
        return refreshIfUpdated().triangleDatabase;
    }
}
