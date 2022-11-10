package util;

import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultUtil {
    private static final Logger logger = LogManager.getLogger("service_B");

    public static <T extends Exception> Integer toHttpCode(T fault){
        try{
            String exceptionName = fault.getClass().getSimpleName();
            
            int endIndex = exceptionName.indexOf("_");

            //If -1 it's WebServiceException
            String mapperName = 
            endIndex == -1 ? "mapper." + exceptionName + "Mapper" : "mapper." + exceptionName.substring(0, endIndex) + "Mapper";

            var mapperClass = Class.forName(mapperName);

            Response toResponse = (Response) mapperClass.getMethod("toResponse", fault.getClass()).invoke(mapperClass.getDeclaredConstructor().newInstance(), fault);

            return toResponse.getStatus();
        }
        catch(Exception exception){
            logger.fatal(exception.getMessage(), exception);

            return null;
        }
    }
}
