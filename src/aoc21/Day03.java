package aoc21;

import java.io.IOException;
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

public class Day03 {
    static List<String> binaryInput = new ArrayList<>();

    public static void main() {
        System.out.println("--- Day 3: Binary Diagnostic ---");
        getBinary();

        System.out.println("Part1: The submarine has an energy consumption of " + calculateConsumption(binaryInput) + ".");
        System.out.println();

        System.out.println("Part2: The submarine has an energy consumption of " + calculateConsumption(binaryInput) + ".");
        System.out.println();
    }
    //part1
    private static int calculateConsumption(List<String> input) {
        int gamma = 0;
        int epsilon = 0;


        int bitSize = input.get(0).length();
        int dataSize = input.size();
        for (int i = 0; i < bitSize; i++) {
            int c = 0;
            for (String line : input) {
                c += Character.getNumericValue(line.charAt(i));
            }
            int i1 = 1 << Math.abs(i - bitSize + 1);
            if (c > (dataSize/2))   gamma   |= i1;
            else                    epsilon |= i1;
        }

        return gamma*epsilon;
    }
    //part2
    private static int calculateLifeSupportRating(List<String> input){
        return 1;
    }

    private static void getBinary() {
        try {
            binaryInput.addAll(Files.readAllLines(Path.of("src/input_txt/day03_input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
