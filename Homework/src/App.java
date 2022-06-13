import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class App {
    public static void main(String[] args) throws Exception {
        Rectangle[] rectangles = {
            new Rectangle(4, 3),
            new Rectangle(16, 9),
            new Rectangle(5, 4),
            new Rectangle(10, 5),
            new Rectangle(6, 4),
            new Rectangle(4, 3)
        };

        print(rectangles);
        
        
        System.out.println();
      
        //#region sort
        Arrays.sort(rectangles);
        
        print(rectangles);
        //#endregion
        
        System.out.println();
        
        //#region search for area 20
        int index = findArea(rectangles, 20);

        System.out.println("Rectangle with " + rectangles[index] + " has area 20");
        //#endregion

        System.out.println();

        //#region sort by RectangleCompArea
        Arrays.sort(rectangles, new RectangleCompArea());

        print(rectangles);
        //#endregion

        System.out.println();


        ArrayList rectangleArrList = new ArrayList();
        Collections.addAll(rectangleArrList, rectangles);

        //#region sort by descending perimeter
        rectangleArrList.sort(new RectangleCompPerimeterDesc());

        System.out.println(rectangleArrList);
        //#endregion

        System.out.println();

        //#region find perimeter 15 and sides 4, 3
        Rectangle rectangle = findPerimeter(rectangleArrList, 15);

        System.out.println("Rectangle with " + rectangle + " has perimeter 15");


        Rectangle rectangle2 = findWidthHeight(rectangleArrList, 4, 3);

        System.out.println("Rectangle with " + rectangle2 + " has width 4 and height 3");
        //#endregion

        System.out.println();

        //#region set with ascending natural ordering
        TreeSet rectangleSet = new TreeSet(rectangleArrList);

        System.out.println(rectangleSet);
        //#endregion

        System.out.println();

        //#region set with descending perimeter ordering
        TreeSet rectangleSet2 = new TreeSet(new RectangleCompPerimeterDesc());
        rectangleSet2.addAll(rectangleArrList);

        System.out.println(rectangleSet2);
        //#endregion

        System.out.println();

        //#region rectangle hashset
        HashSet rectangleHashSet = new HashSet(rectangleArrList);
        System.out.println(rectangleHashSet);
        //#endregion

        System.out.println();

        //#region map
        Map rectangleMap = new TreeMap();

        rectangleMap.put(new Rectangle(4, 3), "1");
        rectangleMap.put(new Rectangle(6, 5), "2");
        rectangleMap.put(new Rectangle(25, 24), "3");
        rectangleMap.put(new Rectangle(16, 9), "4");

        Rectangle key = new Rectangle(4, 3);
        String value = (String)rectangleMap.get(key);
        
        rectangleMap.put(key, "5");
        
        String value2 = (String)rectangleMap.get(key);
        rectangleMap.remove(key);
        
        System.out.println(value + " " + value2);

        System.out.println(rectangleMap);
        //#endregion
        
        System.out.println();
    
        //#region map2
        Map rectangleMap2 = new HashMap();

        rectangleMap2.put(new Rectangle(7, 4), 1);
        rectangleMap2.put(new Rectangle(4, 3), 2);
        rectangleMap2.put(new Rectangle(5, 4), 3);
        rectangleMap2.put(new Rectangle(16, 9), 4);

        System.out.println(rectangleMap2.keySet());

        System.out.println(rectangleMap2.values());

        Iterator mapIter = rectangleMap2.entrySet().iterator();
        
        System.out.println();

        while(mapIter.hasNext()){
            System.out.println(mapIter.next());
        }

        System.out.println();

        for(Object entry : rectangleMap2.entrySet()){
            Map.Entry element = (Map.Entry)entry;

            System.out.println(element);
        }
        //#endregion
    }

    //#region print function
    static void print(Rectangle[] array){
        for(var element : array){
            System.out.println(element);
        }
    }
    //#endregion

    //#region finder functions
    static int findArea(Rectangle[] rectangles, int area){
        Rectangle rectWithDesiredArea = new Rectangle(area, 1);
        RectangleCompArea areaComparator = new RectangleCompArea();
        
        for(int i = 0; i < rectangles.length; i++){
            if(areaComparator.compare(rectangles[i], rectWithDesiredArea) == 0){
                return i;
            }
        }

        return -1;
    }

    static Rectangle findPerimeter(ArrayList rectangles, int perimeter){
        Iterator iter = rectangles.iterator();
        RectangleCompPerimeterDesc perimeterComparator = new RectangleCompPerimeterDesc();
        Rectangle rectangleWithDesiredPerimeter = new Rectangle(perimeter - 1, 1);

        while(iter.hasNext()){
            Rectangle nextElement = (Rectangle)iter.next();

            if(perimeterComparator.compare(nextElement, rectangleWithDesiredPerimeter) == 0){
                return nextElement;
            }
        }

        return new Rectangle(-1, -1);
    }

    static Rectangle findWidthHeight(ArrayList rectangles, int width, int height){
        Rectangle desiredRectangle = new Rectangle(width, height);
        
        for(var entry : rectangles){
            if(entry.equals(desiredRectangle)){
                return (Rectangle)entry;
            }
        }

        return new Rectangle(-1, -1);
    }
    //#endregion
}
