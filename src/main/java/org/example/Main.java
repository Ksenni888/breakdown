package org.example;

import org.example.Controller.Breakdown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<String> filesNames = new ArrayList<>();

    private String addPath = "";
    private String prefix = "";
    private boolean shortStatistics = false;
    private boolean fullStatistics = false;
    private boolean addToFile = false;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        Breakdown breakdown = new Breakdown();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    main.addPath = args[i + 1];
                    break;
                case "-p":
                    main.prefix = args[i + 1];
                    System.out.println(main.prefix);
                    break;
                case "-a":
                    main.addToFile = true;
                    break;
                case "-s":
                    main.shortStatistics = true;
                    break;
                case "-f":
                    main.fullStatistics = true;
                    break;
                default:
                    if (args[i].contains(".txt")) {
                        main.filesNames.add(args[i]);
                    }
            }
        }
        if (!main.filesNames.isEmpty()) {
            breakdown.breakdown(main.addToFile, main.addPath, main.prefix, main.filesNames, main.shortStatistics, main.fullStatistics);
        } else {System.out.println("No files for reading"); log.error("No files for reading");}
    }
}