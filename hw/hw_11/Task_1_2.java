package com.hw.hw_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1_2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("name0");
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name6");
        method1(names);
        method2(names);
    }


    static void method1(List list) {
        int skipElement = -1;

        while (skipElement < list.size()) {
            list.stream().skip(skipElement += 2)
                    .limit(1)
                    .forEach(System.out::println);
        }
    }

    static void method2(List<String> list) {

        list.stream().sorted((s1, s2)-> s2.compareTo(s1))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}


