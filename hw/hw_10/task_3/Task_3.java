package com.hw.hw_10.task_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        File file = new File("hw/hw_10/task_3/words.txt");
        try(Scanner scan = new Scanner(file)){
            //вносимо слова (ключ) та частоту (значення) в Map
            Map<String, Integer> mapWords = new HashMap<>();
            while(scan.hasNext()){
                String str = scan.nextLine();
                String[] arrayWords = str.split(" ");
                for (String word : arrayWords) {
                    if(word.length() > 0){
                        if(mapWords.containsKey(word)) {
                            mapWords.put(word, mapWords.get(word) + 1);
                        }
                        else {
                            mapWords.put(word, 0);
                        }
                    }
                }
            }
            // значення вносимо в массив
            int[]arrayCountWord = new int[mapWords.size()];
            int iMap = 0;
            for (Map.Entry<String, Integer> map : mapWords.entrySet()) {
                arrayCountWord[iMap++] = map.getValue();
            }
            // робимо сортування масиву
            Arrays.sort(arrayCountWord);
            //значення що дублюються робимо відємними (-1)
            for (int i = 0; i < arrayCountWord.length ; i++) {
                if(!(arrayCountWord[i] < 0)) {
                    for (int j = i + 1; j < arrayCountWord.length; j++) {
                        if (arrayCountWord[i] == arrayCountWord[j]) arrayCountWord[j] = -1;
                        else{
                            i = j - 1;
                            break;
                        }
                    }
                }
            }
            //сортуємо ще раз
            Arrays.sort(arrayCountWord);
            //виводимо слово та частоту в консоль для значень що є позитивними
            for (int i = arrayCountWord.length - 1; i >= 0 ; i--) {
                if(arrayCountWord[i] < 0) break;
                for (Map.Entry<String, Integer> map : mapWords.entrySet()) {
                    if(map.getValue() == arrayCountWord[i]){
                        System.out.println(map.getKey() + " " + map.getValue());
                    }
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
