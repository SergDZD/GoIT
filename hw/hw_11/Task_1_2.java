package com.hw.hw_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task_1_2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(){};
        names.add("name0");
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name6");
        List<String> names1 = new ArrayList<>(){};
        names1.add("name10");
        names1.add("name11");
        names1.add("name12");
        names1.add("name13");
        names1.add("name14");
        names1.add("name15");
        names1.add("name16");
        names1.add("name17");
        names1.add("name18");
        System.out.println(task1(names));
        System.out.println(task2(names).toString());
        zip(names.stream(), names1.stream()).forEach(System.out::println);
    }

    public static String task1(List<String> nameList) {
        return IntStream.range(0, nameList.size())
                .boxed()
                .filter(x -> x%2 != 0)
                .map(x -> x + ". " + nameList.get(x))
                //.forEach(System.out::print);
                .collect(Collectors.joining(", "));
    }

    static List task2(List<String> list) {
        return list.stream().sorted((s1, s2)-> s2.compareTo(s1))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void zip(Stream<T> first, Stream<T> second) {
        //long max = Math.min(first.count(), second.count());
       //Stream.concat(first.limit(max), second.limit(max));
        Stream<T> concat = Stream.concat(first.limit(second.count()), second.limit(first.count()));
        concat.
    }
}


