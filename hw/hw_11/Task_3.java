package com.hw.hw_11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task_3 {
    public static void main(String[] args) {
        String str = "1, 2, 0";
        //int[] arrayStr = Integer.parseInt(str.split(","));
        String[] array = new String[]{"1, 2, 0", "4, 5"};
        //Stream<String> strStream = Stream.of(array);
        Stream<String> strStream = Arrays.stream(array);
        strStream.flatMap(p -> Arrays.stream(p.split( "," )))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(p -> p + ", ")
                .forEach(System.out::print);
    }
}
