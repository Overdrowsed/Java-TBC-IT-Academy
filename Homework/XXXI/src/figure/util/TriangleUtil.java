package figure.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import figure.Triangle;

public class TriangleUtil {
    public static List<Triangle> readTriangles(String path) throws Exception{
        String fileContent = Files.readString(Path.of(path));

        var triangles = new ArrayList<Triangle>(){
            {
                fileContent.lines()
                .filter(Predicate.not(String::isBlank))
                .map(String::strip)
                .forEach(triangleSidesInput -> {
                    String[] sides = triangleSidesInput.split("-");
                    
                    add(
                        new Triangle(
                            Integer.valueOf(sides[0]).intValue(),
                            Integer.valueOf(sides[1]).intValue(),
                            Integer.valueOf(sides[2]).intValue()
                        )
                    );
                });
            }
        };

        return triangles;
    }

    public static List<Triangle> filterNonRightTriangles(List<Triangle> triangles) {
        return triangles.stream()
            .filter(Predicate.not(Triangle::isRightTriangle))
            .collect(Collectors.toList());
    }

    public static Triangle findFirstRightTriangle(List<Triangle> triangles){
        return triangles.stream()
            .filter(Triangle::isRightTriangle)
            .findFirst()
            .orElseThrow();
    }
}
