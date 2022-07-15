package figure.analyzer;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import figure.Figure;
import figure.Triangle;
import figure.method.FigureMethod;

public class FigureAnalyzer {
    public static Map<String, Integer> analyzeMethods(Figure figure){
        Method[] figureMethods = figure.getClass().getDeclaredMethods();

        Map<String, Integer> methodAnalysis = new TreeMap<>(); 

        for(var method : figureMethods){
            if(method.getName().startsWith("get") 
            && method.getReturnType() == int.class && method.getParameterCount() == 0){
                
                try{
                    methodAnalysis.put(method.getName(), (int)method.invoke(figure));
                }
                catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        }

        return methodAnalysis;
    }

    public static int invokeFigureMethod(Figure figure, FigureMethod method){
        try{
            return (int) (figure.getClass().getDeclaredMethod(method.methodName).invoke(figure));
        }
        //NoSuchMethodException | IllegalAccessException | InvocationTargetException
        catch(Exception exception){
            System.out.println(exception);
        }

        return -1;
    }

    public static int countTriangles (List<Figure> figures){
        int count = 0;

        for(var figure : figures){
            if(figure.getClass() == Triangle.class)
                count++;
        }

        return count;
    } 
}
