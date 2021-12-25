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

public class Day02 {
    public static List<String> movement = new ArrayList<>();

    public static void main() {
        System.out.println("--- Day 2: Dive! ---");
        getMovement();

        //Part1
        int positionForward = 0;
        int positionDepth = 0;

        for (String move : movement) {
            String[] splitMove = move.split(" ");
            switch (splitMove[0].toLowerCase()){
                case "forward" -> positionForward += Integer.parseInt(splitMove[1]);
                case "down" -> positionDepth += Integer.parseInt(splitMove[1]);
                case "up" -> positionDepth -= Integer.parseInt(splitMove[1]);
            }
        }
        System.out.println("Part1: The submarine is at position " + positionForward * positionDepth);

        //Part2
        int aim = 0;
        positionForward = 0;
        positionDepth = 0;
        for (String move : movement){
            String[] splitMove = move.split(" ");
            int i = Integer.parseInt(splitMove[1]);

            if(splitMove[0].equalsIgnoreCase("down")) aim += i;
            if (splitMove[0].equalsIgnoreCase("up")) aim -= i;
            if(splitMove[0].equalsIgnoreCase("forward")){
                positionForward += i;
                positionDepth += i * aim;
            }
        }
        System.out.println("Part2: The submarine is at position " + positionForward * positionDepth);
        System.out.println();
    }

    public static void getMovement(){
        try {
            movement.addAll(Files.readAllLines(Path.of("src/input_txt/day02_input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
