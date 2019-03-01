package com.example.sasha.juniorandoiddev;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import static com.example.sasha.juniorandoiddev.MainActivity.controller;

public class Players extends AppCompatActivity {

    LinearLayout llMain;
    private Pojo league;
    static int idClub;
    static ArrayList<Squad> squads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        squads = new ArrayList<>();

        llMain = findViewById(R.id.xzxz);
        league = new Pojo();
        controller.setParam(3, league, null, idClub);

        final int interval = 1000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable(){
            public void run() {
                init();
            }
        };
        handler.postDelayed(runnable, interval);


    }

    private void init() {
        for (int i = 0; i < squads.size(); i++) {

            Display display = getWindowManager().getDefaultDisplay();
            int width = display.getWidth();
            ;

            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

            final TextView textView1 = new TextView(this);
            textView1.setWidth(width);
            String str = "Name: " + squads.get(i).getName() + ".\nPosition: " + squads.get(i).getPosition() + ".\nBirthday: "
                    + squads.get(i).getDateOfBirth() + ".\nNationality: " + squads.get(i).getNationality();
            textView1.setText(str);
            llMain.addView(textView1, lParams);
        }

    }

    public void setIdClub(int id){
        idClub = id;

    }

    public void setArr(ArrayList<Squad> sq) {
        squads = sq;
    }
}
