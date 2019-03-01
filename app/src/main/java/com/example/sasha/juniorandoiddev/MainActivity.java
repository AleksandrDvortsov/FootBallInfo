package com.example.sasha.juniorandoiddev;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    LinearLayout llMain;
    static Controller controller;
    HashMap<Integer,String> hmAllLeague;
    LeagueProfile lp;
    Players players;
    static Context context;

    int wrapContent = FrameLayout.LayoutParams.WRAP_CONTENT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lp = new LeagueProfile();
        players = new Players();
        context = getApplicationContext();

        controller = new Controller();
        hmAllLeague = new HashMap<>();

        llMain = findViewById(R.id.llMain);
        controller.throwClass(lp, players);

        controller.setParam(0, null, hmAllLeague, 0);

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

        for (Map.Entry<Integer, String> entry : hmAllLeague.entrySet()) {
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    wrapContent, wrapContent);

            final Button btnNew = new Button(this);
            btnNew.setText(entry.getValue());
            btnNew.setId(entry.getKey());
            btnNew.setWidth(width);
            btnNew.setBackgroundColor(Color.rgb(204, 255, 255));
            // костыль так как работають только эти ID
            if (entry.getKey() == 2000 || entry.getKey() == 2018 || entry.getKey() == 2002 || entry.getKey() == 2013 || entry.getKey() == 2014) {
                btnNew.setBackgroundColor(Color.LTGRAY);
            }

            btnNew.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getBaseContext(), LeagueProfile.class);
                    startActivity(intent);

                    lp.setParam(btnNew.getId(), btnNew.getText().toString(), hmAllLeague, controller, lp);
//                    Toast.makeText(getApplicationContext(), "Click " + btnNew.getId(), Toast.LENGTH_SHORT).show();
                }
            });
            llMain.addView(btnNew, lParams);
        }
    }
    public static void error(){
        Toast toast = Toast.makeText(context, " ~ php: Error! ~ ", Toast.LENGTH_LONG);
        toast.show();
    }
}
