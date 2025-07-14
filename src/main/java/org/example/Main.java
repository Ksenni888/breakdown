package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    private final static String path = "C:/some/path/";
    private List<String> filesNames = new ArrayList<>();
    private List<String> indexInform = new ArrayList<>();
    private String newFile_path = "C:/some/path/";
    private String prefix = "";
    private boolean shortStatistic = false;
    private boolean longStatistic = false;
    private boolean addTofile = false;
    private BufferedWriter writer;
    private BufferedWriter writer1;
    private BufferedWriter writer2;
    private int a_int = 0;
    private int b_float = 0;
    private int c_string = 0;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public boolean check_integer(String st) {
        try {
            Integer.parseInt(st);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean check_float(String st) {
        try {
            Float.parseFloat(st);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void breakdown(List<String>filesNames, boolean addTofile) {
        log.info("Breakdown");
        int counter_integers = 0;
        int counter_floats = 0;
        int counter_strings = 0;
        List<Integer> integers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        if (!filesNames.isEmpty()) {
            for(String name: filesNames) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path + name), StandardCharsets.UTF_8))) {
                    String st = reader.readLine();
                    while (st != null) {
                        if (check_integer(st)) {
                            try {
                                if (a_int == 0 && addTofile) {
                                    a_int = 1;
                                    writer = new BufferedWriter(new FileWriter(newFile_path + prefix + "integer.txt", true));
                                }
                                if (a_int == 0) {
                                    a_int = 1;
                                    writer = new BufferedWriter(new FileWriter(newFile_path + prefix + "integer.txt"));
                                }
                                writer.append(st);
                                integers.add(Integer.parseInt(st));
                                writer.newLine();
                                counter_integers += 1;
                                if (!indexInform.contains("a_int")) {
                                    indexInform.add("a_int");
                                }
                            } catch (IOException create_integer_file) {
                                log.error("Failed to create integer.txt file.", create_integer_file);
                            }
                        } else if (st.contains(".") || check_float(st)) {
                            try {
                                if (b_float == 0 && addTofile) {
                                    b_float = 1;
                                    writer1 = new BufferedWriter(new FileWriter(newFile_path + prefix + "float.txt", true));
                                }
                                if (b_float == 0) {
                                    b_float = 1;
                                    writer1 = new BufferedWriter(new FileWriter(newFile_path + prefix + "float.txt"));
                                }
                                writer1.append(st);
                                floats.add(Float.parseFloat(st));
                                writer1.newLine();
                                counter_floats += 1;
                                if (!indexInform.contains("b_float")) {
                                    indexInform.add("b_float");
                                }
                            } catch (IOException create_float_file) {
                                log.error("Failed to create float.txt file.", create_float_file);
                            }
                        } else {
                            try {
                                if (c_string == 0 && addTofile) {
                                    c_string = 1;
                                    writer2 = new BufferedWriter(new FileWriter(newFile_path + prefix + "string.txt", true));
                                }
                                if (c_string == 0) {
                                    c_string = 1;
                                    writer2 = new BufferedWriter(new FileWriter(newFile_path + prefix + "string.txt"));
                                }
                                writer2.append(st);
                                strings.add(st);
                                writer2.newLine();
                                counter_strings += 1;
                                if (!indexInform.contains("c_string")) {
                                    indexInform.add("c_string");
                                }
                            } catch (IOException create_string_file) {
                                log.error("Failed to create string.txt file.", create_string_file);
                            }
                        }
                        st = reader.readLine();
                    }
                } catch (IOException reader_file) {
                    log.error("Failed to read file.",reader_file);
                }
            }
            if (a_int == 1) {
                try {
                    writer.close();} catch (IOException fail_close_integer_file) {
                    log.error("Failed to close integer.txt file.", fail_close_integer_file);
                }
            }
            if (b_float == 1) { try {
                writer1.close();
            } catch (IOException fail_close_float_file) {
                log.error("Failed to close float.txt file.", fail_close_float_file);
            }
            }
            if (c_string == 1) {
                try{
                    writer2.close();
                } catch (IOException fail_close_string_file) {
                    log.error("Failed to close string.txt file.", fail_close_string_file);
                }
            }
            System.out.println("Данные успешно записаны");
            System.out.println();
            if (shortStatistic) {
                System.out.println("Краткая статистика: ");
                System.out.println();
                System.out.println("Число записанных элементов: " + (counter_integers + counter_floats + counter_strings));
                System.out.println("Целые числа: " + counter_integers);
                System.out.println("Вещественные числа: " + counter_floats);
                System.out.println("Строки:" + counter_strings);
            }
            if (longStatistic) {
                System.out.println("Полная статистика: ");
                if (!integers.isEmpty()) {
                    int sum = integers.stream().mapToInt(i -> i).sum();
                    System.out.println();
                    System.out.println("Статистика по integers: ");
                    System.out.println("Общее количество чисел: " + counter_integers);
                    System.out.println("Максимальное число: " + Collections.max(integers));
                    System.out.println("Минимальное число: " + Collections.min(integers));
                    System.out.println("Сумма целых чисел: " + sum);
                    System.out.println("Среднее арифметическое: " + sum / counter_integers);
                }
                if (!floats.isEmpty()) {
                    double sum = floats.stream().mapToDouble(x -> Double.parseDouble(x.toString())).sum();
                    System.out.println();
                    System.out.println("Статистика по floats:");
                    System.out.println("Общее количество чисел: " + counter_floats);
                    System.out.println("Максимальное число: " + Collections.max(floats));
                    System.out.println("Минимальное числое: " + Collections.min(floats));
                    System.out.println("Сумма чисел: " + sum);
                    System.out.println("Среднее арифметическое: " + sum / counter_floats);
                }
                if (!strings.isEmpty()) {
                    Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));
                    Optional<String> shortestString = strings.stream().min(Comparator.comparingInt(String::length));
                    System.out.println();
                    System.out.println("Статистика по strings: ");
                    System.out.println("Общее количество строк: " + counter_strings);
                    System.out.println("Максимальная длина строки: " + (longestString.toString().length() - 10));
                    System.out.println("Минимальная длина строки: " + (shortestString.toString().length() - 10));
                }
            }
            filesNames.clear();
        }

        else {System.out.println("Файлов для чтения не задано");}
    }

    public static void main(String[] args) {
        Main m = new Main();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o": m.newFile_path = args[i+1]; break;
                case "-p": m.prefix = args[i+1]; break;
                case "-a": m.addTofile = true; break;
                case "-s": m.shortStatistic = true; break;
                case "-f": m.longStatistic = true; break;
                default: if (args[i].contains(".txt")) {m.filesNames.add(args[i]);}
            }
        }
        m.breakdown(m.filesNames, m.addTofile);
    }
}