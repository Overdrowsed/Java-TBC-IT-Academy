package analyzer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberAnalyzer {
    public static List<Integer> printPrimes(int from, int to){
        return Stream.iterate(from, i -> i <= to, i -> i+1).filter(NumberAnalyzer::isPrime).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    private static boolean isPrime(int n){
        return Stream.iterate(2, i -> i*i <= n, i -> i+1).filter(i -> n%i == 0).count() == 0 ? true : false;
    }
}
