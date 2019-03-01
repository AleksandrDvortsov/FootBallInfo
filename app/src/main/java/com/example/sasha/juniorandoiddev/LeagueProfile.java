package com.example.sasha.juniorandoiddev;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class LeagueProfile extends AppCompatActivity {

    private static String nameL;
    private static Pojo league;
    private static int idL = 0;
    private static Context context;
    LinearLayout llMain;
    int wrapContent = FrameLayout.LayoutParams.WRAP_CONTENT;
    TextView nameLe;
    private static TextView textView3;
    private static TextView textView4;
    private static ImageView imageView;
    private static HashMap<Integer,Team> hmTeams;
    TeamProfile tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_profile);
        hmTeams = new HashMap<>();
        context = getApplicationContext();
        nameLe = findViewById(R.id.textNameLe);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView);
        nameLe.setText(nameL);

        llMain = findViewById(R.id.llMainL);
        league = new Pojo();
        tp = new TeamProfile();

        final int interval = 1000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable(){
            public void run() {
                createBtn();
            }
        };
        handler.postDelayed(runnable, interval);
    }

    private void createBtn() {

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        for (final Map.Entry<Integer, Team> entry : hmTeams.entrySet()) {

            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    wrapContent, wrapContent);

            final Button btnNew = new Button(this);
            btnNew.setText(entry.getValue().getName());
            btnNew.setId(entry.getKey());
            btnNew.setWidth(width);
            btnNew.setBackgroundColor(Color.rgb(204, 255, 255));
            btnNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), TeamProfile.class);
                    startActivity(intent);
                    tp.setParam(entry.getValue());
//                    Toast.makeText(getApplicationContext(), "Click " + btnNew.getId(), Toast.LENGTH_LONG).show();
                }
            });
            llMain.setBackgroundColor(Color.rgb(0, 230, 153));
            llMain.addView(btnNew, lParams);
        }
    }

    private void loadLeague(final Controller controller) {
        // работают только эти ID
        if (idL == 2000 || idL == 2018 || idL == 2002 || idL == 2013 || idL == 2014){
            controller.setParam(1, league, null, idL);
            final int interval = 500;
            Handler handler = new Handler();
            Runnable runnable = new Runnable(){
                public void run() {
                    controller.setParam(2, league, null, idL);
                }
            };
            handler.postDelayed(runnable, interval);
        }
    }

    public void setParam(int id, String name, HashMap<Integer, String> hmAllLeague, Controller controller, LeagueProfile lp) {
        idL = id;
        nameL = name;
        loadLeague(controller);
    }

    public static void setParamLiga(String team, String data, String img) {
        textView3.setText(team);
        textView4.setText(data);
        if (img == null)img = "https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg";
        Utils.fetchSvg(context, img, imageView);
    }

    public void setHm(HashMap<Integer,Team> hm) {
        hmTeams = hm;
    }
}
