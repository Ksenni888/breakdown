package org.example.Model;


import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class IntegerDate {
    private List<Integer> integers = new ArrayList<>();
    private Integer counter_integers = 0;
    private BufferedWriter writer_integer;

    public List<Integer> getIntegers() {
        return integers;
    }

    public BufferedWriter getWriter_integer() { return writer_integer; }

    public Integer getCounter_integers() {
        return counter_integers;
    }

    public void setIntegers(Integer i) {
        integers.add(i);
    }

    public void setWriter_integer(BufferedWriter writer_integer) {
        this.writer_integer = writer_integer;
    }

    public void setCounter_integers(Integer counter_integers) {
        this.counter_integers = counter_integers;
    }


}
