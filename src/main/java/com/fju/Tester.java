package com.fju;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("妳需要洗哪些項目呢?(a:大型衣物，b:一般衣物，c:襪子)");
        int coins=0;
        LargeClothing l = new LargeClothing();
        GeneralClothing g = new GeneralClothing();
        Socks socks = new Socks();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        while (s != "0"){
            if (s.equals("a")) {
                coins += l.price;
                System.out.println(coins);
            }
            if (s.equals("b")) {
                coins += g.price;
                System.out.println(coins);
            }
            if (s.equals("c")) {
                coins += socks.price;
                System.out.println(coins);
            }
            System.out.println("還有要加的選項嗎? 無 請按0，有 請繼續按您所要的選項");
            s = scanner.next();
            if(s.startsWith("0")){
                System.out.println("總共:"+coins);
                break;
            }
        };
        System.out.println("請投入您的印幣:(直接打自己投入的金額)");
        s = scanner.next();
        int money = Integer.parseInt(s);
        int surplus = money-coins;
        if(surplus<0){
            System.out.println("餘額不足!! 退還: " + money);
        }else {
            System.out.println("退還:");
            if(surplus>=50){
                System.out.println(surplus/50+"個 50元");
                surplus%=50;
            }if(surplus>=10){
                System.out.println(surplus/10+"個 10元");
                surplus%=10;
            }if(surplus>=5){
                System.out.println(surplus/5+"個 5元");
                surplus%=5;
            }if(surplus>=1){
                System.out.println(surplus+"個 1元");
            }
        }
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
            System.out.print(sb.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
