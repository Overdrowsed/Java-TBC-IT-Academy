package analyzer;

import java.util.ArrayList;
import java.util.Collections;

import utilities.Triple;

public class StringAnalyzer {
    public static Triple<Integer, Integer, Double> minMaxAverage(ArrayList<String> strings){
        Collections.sort(strings);

        double sum = 0;

        for(var string : strings)
            sum += string.length();

        double average = sum / strings.size();
        
        return new Triple<Integer,Integer,Double>(strings.get(0).length(), strings.get(strings.size() - 1).length(), Double.valueOf(average));
    }
}
