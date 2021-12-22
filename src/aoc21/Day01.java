package aoc21;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
* This is a program for solving the task from day 1 from the website AdventOfCode2021.
*
* @author Da-Br-91
* @version 1.0
*/

public class Day01 {

    static List<Integer> measurementsInput = new ArrayList<>();

    public static void main() {
        int counter1 = 0, counter2 = 0;
        getMeasurements();
        System.out.println("--- Day 1: Sonar Sweep ---");

        //calc of part 1:
        for (int i = 0; i < measurementsInput.size(); i++) {
            if(i != 0){
                if(measurementsInput.get(i) > measurementsInput.get(i-1)) counter1++;
            }
        }
        System.out.println("Part1: There are " + counter1 + " measurements that are larger than the previous measurement.");

        //calc of part 2:
        int window1;
        int window2 = -1;

        for (int i = 0; i < measurementsInput.size(); i++) {
            if(i+2 >= measurementsInput.size()) break;
            window1 = measurementsInput.get(i) + measurementsInput.get(i+1) + measurementsInput.get(i+2);
            if(window1 > window2 && window2 != -1) counter2++;

            window2 = window1;

        }
        System.out.println("Part2: There are " + counter2 + " sums that are larger than the previous sum.");
        System.out.println();
    }
    private static void getMeasurements(){
        try {
            for (String line : Files.readAllLines(Path.of("src/input_txt/day01_input.txt"))) {
                measurementsInput.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
