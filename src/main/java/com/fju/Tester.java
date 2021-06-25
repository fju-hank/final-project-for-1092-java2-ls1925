package com.fju;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tester {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://myjson.dit.upm.es/api/bins/1cbw");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line = in.readLine();
            StringBuffer sb = new StringBuffer();
            while (line != null){
                System.out.println(line);
                sb.append(line);
                line = in.readLine();
            }
            System.out.println(line);
            System.out.print(sb.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
