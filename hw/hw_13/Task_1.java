package com.hw.hw_13;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task_1 {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add(5);
        //collection.add(new Event("GREETINGS", "guest"));
       /* String json = gson.toJson(collection);
        System.out.println("Using Gson.toJson() on a raw collection: " + json);
        JsonArray array = JsonParser.parseString(json).getAsJsonArray();
        String message = gson.fromJson(array.get(0), String.class);
        int number = gson.fromJson(array.get(1), int.class);
        Event event = gson.fromJson(array.get(2), Event.class);
        System.out.printf("Using Gson.fromJson() to get: %s, %d, %s", message, number, event);*/

        Geo userGeo = new Geo(-37.3159, 81.1496);
        Address userAddress = new Address("Kulas Light", "Apt. 556", "Gwenborough","92998-3874", userGeo);
        Company userCompany = new Company("Romaguera-Crona","Multi-layered client-server neural-net","harness real-time e-markets");
        User user = new User("Test", "TEST","test@test.com", userAddress, "1-770-736-8031 x56442","hildegard.org",userCompany);
        createUser(user);

        sendGET("https://jsonplaceholder.typicode.com/users");
       // System.out.println(response);
        String response = sendPOST("https://jsonplaceholder.typicode.com/users", "");
        System.out.println(response);
        Gson responseGson = new Gson();
        System.out.println(responseGson.toJson(response).toString());
        JsonArray array = JsonParser.parseString(response).getAsJsonArray();
            //String message =  responseGson.toJson(response).toString().fromJson(array.get(0), String.class);
            //responseGson.fromJson(response, )

        sendPOST("", "");
    }



    public static boolean createUser(User user) throws IOException {
        boolean isCreate = false;
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        String response = sendPOST("https://jsonplaceholder.typicode.com/users", jsonUser);
        if(!response.isEmpty()) {
            Gson responseGson = new Gson();
            responseGson.toJson(response);
            JsonArray array = JsonParser.parseString("["+ response + "]").getAsJsonArray();
           Map message = gson.fromJson(array.get(0), HashMap.class);
           Integer id = Double.valueOf((message.get("id").toString())).intValue();
            //responseGson.fromJson(response, )
            System.out.println();
        }
        return isCreate;
    }

    private static void getAllUser() throws IOException {
        sendGET("https://jsonplaceholder.typicode.com/users");
    }

    private static String sendGET(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("GET response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "";
        }
    }



    private static String sendPOST(String strUrl, String body) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        //URL url = new URL(strUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        //os.write(body.getBytes());
        os.write(Files.readAllBytes(new File( "hw/hw_13/user.json").toPath()));
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("POST response code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            //System.out.println("POST request not worked");
            return "";
        }
    }


    /*
    * "id": 9,
    "name: " +Glenna Reichert",
    "username: " +Delphine",
    "email: " +Chaim_McDermott@dana.io",
    "address": {
      "street: " +Dayna Park",
      "suite: " +Suite 449",
      "city: " +Bartholomebury",
      "zipcode: " +76495-3109",
      "geo": {
        "lat: " +24.6463",
        "lng: " +-168.8889"
      }
    },
    "phone: " +(775)976-6794 x41206",
    "website: " +conrad.com",
    "company": {
      "name: " +Yost and Sons",
      "catchPhrase: " +Switchable contextually-based project",
      "bs: " +aggregate real-time technologies"
    * */
}
