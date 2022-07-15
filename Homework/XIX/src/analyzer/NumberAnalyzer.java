package analyzer;

import java.util.ArrayList;
import java.util.Collections;

import utilities.Triple;

public class NumberAnalyzer {
    public static <T extends Number & Comparable<T>> Triple<T, T, Double> minMaxAverage(ArrayList<T> numbers){
        Collections.sort(numbers);

        double sum = 0;
        
        for(var number : numbers)
            sum += number.doubleValue();

        double average = sum / numbers.size();
        
        return new Triple<T,T,Double>(numbers.get(0), numbers.get(numbers.size() - 1), Double.valueOf(average));
    }
}
