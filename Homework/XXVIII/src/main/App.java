package main;

import figure.generator.FigureGenerator;
import util.JdomUtil;
import util.StaxUtil;
import util.XpathUtil;

public class App {
    public static void main(String[] args){
        try {
            StaxUtil.serializeTrianglesStax(FigureGenerator.generateTriangles(), "data/");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JdomUtil.deserializeTrianglesJdom("data/Triangles.xml").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();


        try {
            JdomUtil.serializeRectanglesJdom(FigureGenerator.generateRectangles(), "data/Rectangles.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            StaxUtil.deserializeRectanglesStax("data/Rectangles.xml").forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();


        try {
            StaxUtil.serializeCirclesStax(FigureGenerator.generateCircles(), "data/");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            XpathUtil.filterCirclesAttribute("data/Circles_Stax.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        System.out.println();


        try {
            JdomUtil.serializeCirclesJdom(FigureGenerator.generateCircles(), "data/");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            XpathUtil.filterCirclesElement("data/Circles_Jdom.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
