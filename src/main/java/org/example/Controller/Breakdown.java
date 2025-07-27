package org.example.Controller;

import org.example.Model.DoubleDate;
import org.example.Model.IntegerDate;
import org.example.Model.StringDate;
import org.example.Viewer.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Breakdown {

    private IntegerDate integerDate = new IntegerDate();
    private StringDate stringDate = new StringDate();
    private DoubleDate doubleDate = new DoubleDate();
    private Statistics statistics = new Statistics();
    private static final Logger log = LoggerFactory.getLogger(Breakdown.class);


    public void breakdown(boolean addToFile, String addPath, String prefix, List<String>filesNames,
                          boolean shortStatistics, boolean fullStatistics)  {
        String path = System.getProperty("user.dir") + "/";
        if (!filesNames.isEmpty()) {
            for(String name: filesNames) {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path + name),
                            StandardCharsets.UTF_8));
                    String st = reader.readLine();

                    while (st != null) {
                        if (check_integer(st)) {fileWriteInteger(st, addToFile, path, prefix, addPath);}
                        if (check_double(st)) {writeFileDouble(st, addToFile, path, prefix, addPath); }
                        if (check_string(st)){writeFileString(st, addToFile, path, prefix, addPath);}
                        st = reader.readLine();
                    }

                } catch (IOException reader_file) {
                    log.error("Failed to read file.",reader_file);
                }
            }
            if (integerDate.getCounter_integers() != 0) {
                try {
                    integerDate.getWriter_integer().close();} catch (IOException fail_close_integer_file) {
                    log.error("Failed to close integer.txt file.", fail_close_integer_file);
                }
            }
            if (doubleDate.getCounter_doubles() != 0) { try {
                doubleDate.getWriter_double().close();
            } catch (IOException fail_close_double_file) {
                log.error("Failed to close float.txt file.", fail_close_double_file);
            }
            }
            if (stringDate.getCounter_strings() != 0) {
                try{
                    stringDate.getWriter_string().close();
                } catch (IOException fail_close_string_file) {
                    log.error("Failed to close string.txt file.", fail_close_string_file);
                }
            }

            if (shortStatistics) {
                statistics.shortStatistics(integerDate.getCounter_integers(), doubleDate.getCounter_doubles(),stringDate.getCounter_strings());
            }
            if (fullStatistics) {
                statistics.fullStatistics(integerDate.getIntegers(),integerDate.getCounter_integers(),
                        doubleDate.getDoubles(),doubleDate.getCounter_doubles(),stringDate.getStrings(),
                        stringDate.getCounter_strings());
            }
            filesNames.clear();
        }

        else {System.out.println("No files for reading"); log.error("No files for reading");}
    }

    public boolean check_integer(String st) {
        try {
            Integer.parseInt(st);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean check_double(String st) {
        try {
            if (check_integer(st)) {return false;}
            Double.parseDouble(st);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean check_string(String st) {
        if (check_integer(st)) {return false;}
        return !check_double(st);
    }
    public void fileWriteInteger(String st, boolean addToFile, String path, String prefix, String addPath) {
        integerDate.setCounter_integers(integerDate.getCounter_integers()+1);
        try{
            if (addToFile&&integerDate.getIntegers().isEmpty()) {
                integerDate.setWriter_integer(new BufferedWriter(new FileWriter(path + addPath + prefix + "integer.txt", true)));
            }

            if (integerDate.getIntegers().isEmpty()){
                integerDate.setWriter_integer(new BufferedWriter(new FileWriter(path + addPath + prefix + "integer.txt")));
            }

            integerDate.setWriter_integer(new BufferedWriter(integerDate.getWriter_integer().append(st)));
            integerDate.setIntegers(Integer.parseInt(st));
            integerDate.getWriter_integer().newLine();
        } catch (IOException create_integer_file) {
            log.error("Failed to create integer.txt file.", create_integer_file);
        }
    }

    public void writeFileDouble(String st, boolean addToFile, String path, String prefix, String addPath) {
        doubleDate.setCounter_doubles(doubleDate.getCounter_doubles()+1);
        try{
            if (addToFile&&doubleDate.getDoubles().isEmpty()) {
                doubleDate.setWriter_double(new BufferedWriter(new FileWriter(path + addPath+prefix + "float.txt", true)));
            }
            if (doubleDate.getDoubles().isEmpty()) {
                doubleDate.setWriter_double(new BufferedWriter(new FileWriter(path + addPath+prefix + "float.txt")));
            }
            doubleDate.setWriter_double(new BufferedWriter(doubleDate.getWriter_double().append(st)));
            doubleDate.setDoubles(Double.parseDouble(st));
            doubleDate.getWriter_double().newLine();
        } catch (IOException create_float_file) {
            log.error("Failed to create float.txt file.", create_float_file);
        }
    }

    public void writeFileString(String st, boolean addToFile, String path, String prefix, String addPath) {
        stringDate.setCounter_strings(stringDate.getCounter_strings()+1);
        try{
            if (addToFile&&stringDate.getStrings().isEmpty()){
                stringDate.setWriter_string(new BufferedWriter(new FileWriter(path + addPath+prefix + "string.txt", true)));
            }
            if (stringDate.getStrings().isEmpty()) {
                stringDate.setWriter_string(new BufferedWriter(new FileWriter(path + addPath+prefix + "string.txt")));
            }
            stringDate.setWriter_string(new BufferedWriter(stringDate.getWriter_string().append(st)));
            stringDate.setStrings(st);
            stringDate.getWriter_string().newLine();
        } catch (IOException create_string_file) {
            log.error("Failed to create string.txt file.", create_string_file);
        }
    }
}
