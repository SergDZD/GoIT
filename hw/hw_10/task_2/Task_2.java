package com.hw.hw_10.task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args)  {
        ArrayList<User> listUser = new ArrayList<User>();
        File inputFile = new File("hw/hw_10/task_2/text.txt");
        File outFile = new File("hw/hw_10/task_2/user.json");
        try{
            Scanner scan = new Scanner(inputFile);
            String str = scan.nextLine().trim();
            while (scan.hasNext()) {
                str = scan.nextLine().trim();
                int numbSpace = str.indexOf(" ");
                listUser.add(new User(str.substring(0, numbSpace), Integer.parseInt(str.substring(numbSpace + 1))));
            }
            scan.close();
            Gson gson = new Gson();
            String strJson = gson.toJson(listUser);
            FileWriter fileWriter = new FileWriter(outFile);
            fileWriter.write(strJson);
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
