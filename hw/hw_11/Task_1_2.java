package com.hw.hw_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task_1_2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>() {};
        names.add("name0");
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name6");
        List<String> names1 = new ArrayList<>() {};
        names1.add("name10");
        names1.add("name11");
        names1.add("name12");
        names1.add("name13");
        names1.add("name14");
        names1.add("name15");
        names1.add("name16");
        names1.add("name17");
        names1.add("name18");
        //task 1
        System.out.println(task1(names));
        //task 2
        System.out.println(task2(names).toString());
        //task 3
        String[] array = new String[]{"1, 2, 0", "4, 5"};
        System.out.println(task3(array));
        //task 4
        randomStream(25214903917L, 11, (long) Math.pow(2, 48), 25).limit(25).forEach(System.out::println);
        //task 5
        zip(names.stream(), names1.stream()).forEach(System.out::println);
    }

    public static String task1(List<String> nameList) {
        return IntStream.range(0, nameList.size())
                .boxed()
                .filter(x -> x % 2 != 0)
                .map(x -> x + ". " + nameList.get(x))
                //.forEach(System.out::print);
                .collect(Collectors.joining(", "));
    }

    static List task2(List<String> list) {
        return list.stream().sorted((s1, s2) -> s2.compareTo(s1))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    static String task3(String[] array) {
        Stream<String> strStream = Arrays.stream(array);
        return strStream.flatMap(p -> Arrays.stream(p.split(", ")))
                //.map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    //task4
    public static Stream<Long> randomStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    //task 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        long size = Math.min(firstList.size(), secondList.size());
        Stream.Builder<T> zipStream = Stream.<T>builder();
        for (int i = 0; i < size; i++) {
            zipStream.accept(firstList.get(i));
            zipStream.accept(secondList.get(i));
        }
        return zipStream.build();
    }
}


