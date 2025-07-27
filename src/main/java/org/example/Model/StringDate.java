package org.example.Model;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class StringDate {
    private static List<String> strings = new ArrayList<>();
    private static Integer counter_strings = 0;
    private BufferedWriter writer_string;

    public List<String> getStrings() {
        return strings;
    }

    public Integer getCounter_strings() {
        return counter_strings;
    }

    public BufferedWriter getWriter_string() {
        return writer_string;
    }

    public void setWriter_string(BufferedWriter writer_string) {
        this.writer_string = writer_string;
    }

    public void setStrings(String s) {
        strings.add(s);
    }

    public void setCounter_strings(Integer counter_strings) {
        StringDate.counter_strings = counter_strings;
    }


}
