package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int teamAPoints=0;
    int teamBPoints=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3pointsA(View view) {
        teamAPoints+=3;
        displayForTeamA(teamAPoints);
    }

    public void add2pointsA(View view) {
        teamAPoints+=2;
        displayForTeamA(teamAPoints);
    }

    public void add1pointA(View view) {
        teamAPoints+=1;
        displayForTeamA(teamAPoints);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void add3pointsB(View view) {
        teamBPoints+=3;
        displayForTeamB(teamBPoints);
    }

    public void add2pointsB(View view) {
        teamBPoints+=2;
        displayForTeamB(teamBPoints);
    }

    public void add1pointB(View view) {
        teamBPoints+=1;
        displayForTeamB(teamBPoints);
    }

    public void resetScore(View view) {
        teamAPoints=0;
        teamBPoints=0;
        displayForTeamA(teamAPoints);
        displayForTeamB(teamBPoints);

    }
}
