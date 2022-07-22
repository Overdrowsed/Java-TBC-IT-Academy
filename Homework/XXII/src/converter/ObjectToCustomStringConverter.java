package converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;

import converter.annotation.CustomStringSerializable;
import converter.annotation.SkipSerialization;
import converter.annotation.Validator;

public class ObjectToCustomStringConverter {

    public static String convert(Object input){
        TreeMap<String, String> customStringMap = getFieldMap(input);

        StringBuilder customStringBuilder = new StringBuilder();

        customStringBuilder.append("[");

        customStringMap.forEach(
            (field, fieldValue) -> customStringBuilder.append(field + "=" + fieldValue + ";")
        );

        customStringBuilder.append("]");

        return customStringBuilder.toString();
    }

    private static TreeMap<String, String> getFieldMap(Object input){
        verifySerializable(input);

        TreeMap<String, String> serializationMap = new TreeMap<>();

        try{
            for(var field : input.getClass().getDeclaredFields()){
                field.setAccessible(true);

                if(!isSerializableField(input, field))
                    continue;

    
                serializationMap.put(field.getName(), field.get(input).toString());
            }
        }
        catch(Exception exception){
            System.out.println(exception);
        }

        validateObject(input);

        return serializationMap;
    }

    private static void verifySerializable(Object input){
        if(!input.getClass().isAnnotationPresent(CustomStringSerializable.class))
        throw new CustomStringSerializationException("Arguement needs to have CustomStringSerializable annotation to be converted");
    }

    private static boolean isSerializableField(Object object, Field objectField){
        if(objectField.isAnnotationPresent(SkipSerialization.class))
            return false;
        
        if(objectField.isAnnotationPresent(Validator.class)){
            Validator validator = objectField.getDeclaredAnnotation(Validator.class);
            Double fieldValue = null;

            try{
                fieldValue = (double)objectField.get(object);
            }
            catch (Exception exception){
                System.out.println(exception);
            }
            
            if(!(fieldValue >= validator.min() && fieldValue <= validator.max()))
                return false;
        }
        
        return true;
    }

    private static void validateObject(Object object){
        for(var method : object.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(Validator.class)){
                try{
                    if((boolean)method.invoke(object) == false)
                        throw new CustomStringSerializationException("Arguement is invalid and cannot be serialized to custom string");
                }
                catch(IllegalAccessException | InvocationTargetException exception){
                    System.out.println(exception);
                }
            }
        }
    }
}

class CustomStringSerializationException extends RuntimeException{
    CustomStringSerializationException(String message){
        super(message);
    }
}