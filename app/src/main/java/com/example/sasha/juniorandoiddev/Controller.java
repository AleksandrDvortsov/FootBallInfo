package com.example.sasha.juniorandoiddev;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Controller {

    private String ipLocalHost = "192.168.0.105";
    private Pojo pojo;
    private HashMap<Integer,String> hmAllLeague;
    private int check = 0;
    private HashMap<Integer,Team> hmTeams;
    LeagueProfile lp;
    Players players;
    private ArrayList<Squad> squads;

    void throwClass(LeagueProfile lp, Players p){
        this.lp = lp;
        this.players = p;
    }

    void setParam(int check, Pojo pojo, HashMap<Integer, String> hm, int id) {

        this.check = check;

        if (this.check == 0) {
            this.pojo = pojo;
            this.hmAllLeague = hm;
            new LoadApi().execute("http://" + ipLocalHost + "/php/connectTo.php?str=0&param=competitions");
        }
        if (this.check == 1) {
            this.pojo = pojo;
            new LoadApi().execute("http://"+ ipLocalHost +"/php/connectTo.php?str=1&param=competitions/" + id);
        }
        if (this.check == 2){
            this.pojo = pojo;
            this.hmTeams = new HashMap<>();
            new LoadApi().execute("http://"+ ipLocalHost +"/php/connectTo.php?str=2&param=competitions/" + id +"/teams");
        }
        if (this.check == 3) {
            this.pojo = pojo;
            squads = new ArrayList<>();
            new LoadApi().execute("http://"+ ipLocalHost +"/php/connectTo.php?str=3&param=teams/" + id);
        }

    }

    private class LoadApi extends AsyncTask<String, Void, String> {

        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 1500;
        public static final int CONNECTION_TIMEOUT = 1500;

        @Override
        protected String doInBackground(String... strings)
        {
            String stringUrl = strings[0];
            String result = "no result";
            String inputLine;
            try {
                URL myUrl = new URL(stringUrl);
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                connection.connect();
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        @Override
        protected void onPostExecute(String str) {
            if (str.equals("no result")) {
                MainActivity.error();
                return;
            }
            if (check == 0){
                String string = "";
                String keyword = "Liga";
                String keyword2 = "League";
                String keyword3 = "liga";

                Gson gson = new Gson();
                pojo = gson.fromJson(str, Pojo.class);

                int index = 0;
                for (int i = 0; i < pojo.competitions.size(); i++){
                    string = pojo.competitions.get(i).getName();
                    // костыль, так как только в этих кубках есть каманды
                    Boolean found = Arrays.asList(string.split(" ")).contains(keyword);
                    Boolean found2 = Arrays.asList(string.split(" ")).contains(keyword2);
                    index = string.indexOf(keyword3);
                    if(found || found2 || index > 0){
                        hmAllLeague.put(pojo.competitions.get(i).getId(), string);
                    }
                    index = 0;
                    int id = pojo.competitions.get(i).getId();
                    if (id == 2000 || id == 2018 || id == 2001 || id == 2002 || id == 2003 || id == 2013 || id == 2014 || id == 2015){
                        hmAllLeague.put(pojo.competitions.get(i).getId(), pojo.competitions.get(i).getCode());
                    }
                }
            }
            if (check == 1) {
                String newStr = "{\"count\":0,\"filters\":{},\"competitions\":[" + str + "]}";
                Gson gson = new Gson();
                pojo = gson.fromJson(newStr, Pojo.class);
                System.out.println(pojo.toString());
                String nameTeam;
                String img;
                if (pojo.getCompetitions().get(0).getCurrentSeason().getWinner() != null){
                    nameTeam = pojo.getCompetitions().get(0).getCurrentSeason().getWinner().getName();
                    img = pojo.getCompetitions().get(0).getCurrentSeason().getWinner().getCrestUrl();
                }else {
                    nameTeam = "no winner!";
                    img = null;
                }

                String data = pojo.getCompetitions().get(0).getCurrentSeason().getEndDate();
                LeagueProfile.setParamLiga(nameTeam, data, img);
            }
            if (check == 2) {
                Gson gson = new Gson();
                pojo = gson.fromJson(str, Pojo.class);
                for (int i = 0; i < pojo.getTeams().size(); i++){
                    hmTeams.put(pojo.getTeams().get(i).getId(), pojo.getTeams().get(i));
                }
                lp.setHm(hmTeams);
            }
            if (check == 3) {
                Gson gson = new Gson();
                pojo = gson.fromJson(str, Pojo.class);
                for (int i = 0; i < pojo.getSquad().size(); i++){
                    squads.add(pojo.getSquad().get(i));
                }
                players.setArr(squads);
            }
        }
    }
}
