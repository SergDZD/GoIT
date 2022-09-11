package com.hw.hw_11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_3 {
    public static void main(String[] args) {
        String str = "1, 2, 0";
        //int[] arrayStr = Integer.parseInt(str.split(","));
        String[] array = new String[]{"1, 2, 0", "4, 5"};
        Stream<String> strStream = Arrays.stream(array);
        System.out.println(strStream.flatMap(p -> Arrays.stream(p.split( ", " )))
                //.map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
