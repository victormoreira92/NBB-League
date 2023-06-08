package org.application;

import org.model.NBB;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App {

    private static NBB nbb;
    public static void main(String[] args) {
        File file = new File("/home/victormoreira/NBB-Games/src/main/java/org/nbb.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            nbb = new NBB();


            while((line = br.readLine()) != null){
                String[] lineEdit = line.split("/");
                nbb.createChampionship(lineEdit);
            }
            List<String> dayAfter = Arrays.asList("4","3");
            List<String> dayBefore = Arrays.asList("7","3");

            nbb.findGame(Arrays.asList(dayAfter,dayBefore));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> addData(String[] listData){
        HashMap<String, String> hashData = new HashMap<String, String>();
        hashData.put("date", listData[0]);
        hashData.put("team1", listData[1]);
        hashData.put("team2", listData[2]);
        hashData.put("scoreTeam1", listData[3]);
        hashData.put("scoreTeam2", listData[4]);

        return hashData;

    }
}
