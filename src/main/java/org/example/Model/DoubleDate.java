package org.example.Model;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class DoubleDate {
    private List<Double> doubles = new ArrayList<>();
    private Integer counter_doubles = 0;
    private BufferedWriter writer_double;

    public List<Double> getDoubles() { return doubles; }

    public Integer getCounter_doubles() { return counter_doubles; }

    public BufferedWriter getWriter_double() { return writer_double; }

    public void setDoubles(double d) { doubles.add(d); }

    public void setCounter_doubles(Integer counter_doubles) { this.counter_doubles = counter_doubles; }

    public void setWriter_double(BufferedWriter writer_double) { this.writer_double = writer_double; }
}
