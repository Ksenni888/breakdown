package org.example.Viewer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Statistics {

    public void fullStatistics(List<Integer> integers, int counter_integers, List<Double> doubles, int counter_doubles, List<String> strings, int counter_strings){
        System.out.println();
        System.out.println("Full statistic: ");
        if (!integers.isEmpty()) {
            int sum = integers.stream().mapToInt(i -> i).sum();
            System.out.println();
            System.out.println("Statistic by integers: ");
            System.out.println("Total number of numbers: " + counter_integers);
            System.out.println("Maximum number: " + Collections.max(integers));
            System.out.println("Minimum number: " + Collections.min(integers));
            System.out.println("Summ of Integers: " + sum);
            System.out.println("Arithmetic mean: " + sum / counter_integers);
        }
        if (!doubles.isEmpty()) {
            double sum = doubles.stream().mapToDouble(x -> Double.parseDouble(x.toString())).sum();
            System.out.println();
            System.out.println("Statistic by floats:");
            System.out.println("Total number of floats: " + counter_doubles);
            System.out.println("Maximum number: " + Collections.max(doubles));
            System.out.println("Minimum number: " + Collections.min(doubles));
            System.out.println("Summ of floats: " + sum);
            System.out.println("Arithmetic mean: " + sum / counter_doubles);
        }
        if (!strings.isEmpty()) {
            Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));
            Optional<String> shortestString = strings.stream().min(Comparator.comparingInt(String::length));
            System.out.println();
            System.out.println("Statistic by strings: ");
            System.out.println("Total number of strings: " + counter_strings);
            System.out.println("Maximum length of string: " + (longestString.toString().length() - 10));
            System.out.println("Minimum length of string: " + (shortestString.toString().length() - 10));
        }
    }

    public void shortStatistics(int counter_integer, int counter_doubles, int counter_strings){
        System.out.println();
        System.out.println("Short statistic: ");
        System.out.println();
        System.out.println("Number of recorded elements: " + (counter_integer + counter_doubles + counter_strings));
        System.out.println("Integers: " + counter_integer);
        System.out.println("Floats: " + counter_doubles);
        System.out.println("Strings:" + counter_strings);
    }
}
