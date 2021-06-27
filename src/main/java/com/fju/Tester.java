package com.fju;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("這邊能提供給您一些洗衣服的偏方，願意先瀏覽請按 4 ,不願者可按其他鍵直接進入下一步");
        Scanner scanner = new Scanner(System.in);
        String s1 =scanner.next();
        if(s1.equals("4")){
            try{
                FileInputStream fis = new FileInputStream("src/main/java/com/fju/Knowledge");
                InputStreamReader isr =new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                String string = br.readLine();
                while (string != null){
                    System.out.println(string);
                    string = br.readLine();
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                System.out.println("Error reading");
            }
            System.out.println();
        }
        System.out.println("妳需要洗哪些項目呢?(a:大型衣物，b:一般衣物，c:襪子)");
        int coins=0;
        LargeClothing l = new LargeClothing();
        GeneralClothing g = new GeneralClothing();
        Socks socks = new Socks();

        String s = scanner.next();
        while (true){
            if(s.startsWith("a")||s.startsWith("b")||s.startsWith("c")||s.startsWith("0")){
                if (s.equals("a")) {
                    coins += l.price;
                    System.out.println("累積: $" + coins);
                }
                if (s.equals("b")) {
                    coins += g.price;
                    System.out.println("累積: $" + coins);
                }
                if (s.equals("c")) {
                    coins += socks.price;
                    System.out.println("累積: $" + coins);
                }
                if(s.equals("0")){
                    if(coins==0){
                        System.out.println("無選取之物，無須投幣，謝謝惠顧!");
                        System.exit(0);
                    }else {
                        System.out.println("總共:"+coins);
                        break;
                    }
                }
                System.out.println("還有要加的選項嗎? 無 請按0，有 請繼續按您所要的選項");
                s = scanner.next();
            }else {
                System.out.println("請按 a , b , c 或 0 ，才得以繼續喔~");
                s = scanner.next();
            }

        };
        System.out.println("請投入您的硬幣:(直接打自己投入的金額)");
        s = scanner.next();
        int money = Integer.parseInt(s);
        int surplus = money-coins;
        if(surplus<0){
            System.out.println("餘額不足!! 退還: " + money+"，下次再蒞臨!");
            System.exit(0);
        }else {
            System.out.println("退還:");
            if(surplus==0){
                System.out.println("0元");
            }
            int[] divisor = {50,10,5,1};
            for (int i = 0; i < 4; i++) {
                if(surplus>=divisor[i]){
                    System.out.println(surplus/divisor[i]+"個 "+divisor[i]+"元");
                    surplus%=divisor[i];
                }
            }
            System.out.println("謝謝光臨!");
        }

        System.out.println("最後警示，請按照規矩來，勿偷取店內之物，按1可看以下附近監視器資訊!");
        s = scanner.next();
        if(s.equals("1")){
            try {
                URL url = new URL("https://odws.hccg.gov.tw/001/Upload/25/opendataback/9059/155/b08e0903-9ed7-4017-a405-9a4e556a4f8d.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line = in.readLine();
                StringBuffer sb = new StringBuffer();
                while (line != null){
                    System.out.println(line);
                    sb.append(line);
                    line = in.readLine();
                }
//            System.out.print(sb.toString());
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
