package com.hw.hw_10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/hw/hw_10/text.txt");
        System.out.println(file.getPath());
        Scanner scan = new Scanner(file);

        while(scan.hasNext()){
            String str = scan.nextLine().trim();
            if(str.length() == 12 || str.length() == 14){
                if(str.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) System.out.println(str);
                else if(str.matches("[(][0-9]{3}[)]\\s{1}[0-9]{3}-[0-9]{4}")) System.out.println(str);
            }
        }
    }
}
