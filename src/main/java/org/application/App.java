package org.application;

import org.model.Game;
import org.model.NBB;
import org.model.Team;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        File file = new File("/home/victormoreira/NBB-Games/src/main/java/org/nbb.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            NBB nbb = new NBB();
            HashMap<Team,Integer> teamScore = new HashMap<Team, Integer>();


            while((line = br.readLine()) != null){
                String[] lineEdit = line.split("/");
                

                Team team1 = new Team(lineEdit[1]);
                Team team2 = new Team(lineEdit[2]);


                teamScore.put(team1, Integer.valueOf(lineEdit[3]));
                teamScore.put(team2, Integer.valueOf(lineEdit[4]));


                nbb.addGames(new Game(LocalDateTime.now(),teamScore));
                nbb.addTeams(team1);
                nbb.addTeams(team2);


            }

            System.out.println(nbb.getGames().get(0).toString());

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
