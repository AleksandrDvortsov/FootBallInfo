package com.example.sasha.juniorandoiddev;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamProfile extends AppCompatActivity {

    private TextView nameClub;
    private TextView address;
    private TextView phoneNum;
    private TextView webSait;
    private TextView colorClub;
    private Button button;

    private ImageView imageView;
    static Team tm = null;
    private static Context context;
    Players players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);

        context = getApplicationContext();

        nameClub = findViewById(R.id.textNameClub);
        imageView = findViewById(R.id.imageView);
        address = findViewById(R.id.address);
        phoneNum = findViewById(R.id.phoneNam);
        webSait = findViewById(R.id.webSait);
        colorClub = findViewById(R.id.colorClub);
        button = findViewById(R.id.button);

        players = new Players();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Players.class);
                startActivity(intent);

                players.setIdClub(tm.getId());
            }
        });

        int interval = 1000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable(){
            public void run() {
                init();
            }
        };
        handler.postDelayed(runnable, interval);
    }

    private void init() {
        nameClub.setText(tm.getName());
        if (tm.getCrestUrl()!= null) Utils.fetchSvg(context, tm.getCrestUrl(), imageView);
        address.setText(tm.getAddress());
        phoneNum.setText(tm.getPhone());
        webSait.setText(tm.getWebsite());
        colorClub.setText("Color club: " + tm.getClubColors());
    }
    public void setParam(Team team){
        tm = team;
    }
}
