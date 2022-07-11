package figure.analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import figure.Figure;
import utilities.Pair;

public class FigureAnalyzer {
    public static <T extends Figure> Pair<T, T> arrayListGetMinMax(ArrayList<T> figures){
        Collections.sort(figures);

        return new Pair<>(figures.get(0), figures.get(figures.size() - 1));
    }

    public static <T extends Figure> Pair<T, T> treeSetGetMinMax(TreeSet<T> figures){

        return new Pair<>(figures.first(), figures.last());
    }

    public static <T extends Figure> Pair<Map.Entry<T, Integer>, Map.Entry<T, Integer>> treeMapGetMinMax(TreeMap<T, Integer> figures){
        return new Pair<>(figures.firstEntry(), figures.lastEntry());
    }
}
