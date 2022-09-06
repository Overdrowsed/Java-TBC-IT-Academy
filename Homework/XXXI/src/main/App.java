package main;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import figure.Triangle;
import figure.util.TriangleUtil;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args){
        try{
            var triangles = TriangleUtil.readTriangles("in/triangles_in.dat");
    
            var nonRightTriangles = TriangleUtil.filterNonRightTriangles(triangles);
            
            System.out.println(TriangleUtil.findFirstRightTriangle(triangles));
    
            Triangle[] nonRightTrianglesArray = List.copyOf(nonRightTriangles).toArray(Triangle[]::new);
    
            Files.writeString(
                Files.createFile(Path.of("out/triangles_out.dat")),
                Arrays.toString(nonRightTrianglesArray),
                StandardCharsets.UTF_8
            );
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}
