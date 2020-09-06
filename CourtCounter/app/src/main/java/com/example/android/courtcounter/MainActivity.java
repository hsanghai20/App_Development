package com.example.android.courtcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
    }
    /**
     * Increase Score By Three TeamA.
     */
    public void incrementByThreeTeamA(View view){
        increaseScoreTeamA(3);
    }
    /**
     * Increase Score By Two TeamA.
     */
    public void incrementByTwoTeamA(View view){
        increaseScoreTeamA(2);
    }
    /**
     * Increase Score By One TeamA.
     */
    public void incrementByOneTeamA(View view){
        increaseScoreTeamA(1);
    }
    /**
     * Increase Score For TeamA.
     */
    private void increaseScoreTeamA(int score)
    {
        scoreTeamA=scoreTeamA+score;
        displayForTeamA(scoreTeamA);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Increase Score By Three TeamB.
     */
    public void incrementByThreeTeamB(View view){
        increaseScoreTeamB(3);
    }
    /**
     * Increase Score By Two TeamB.
     */
    public void incrementByTwoTeamB(View view){
        increaseScoreTeamB(2);
    }
    /**
     * Increase Score By One TeamB.
     */
    public void incrementByOneTeamB(View view){
        increaseScoreTeamB(1);
    }
    /**
     * Increase Score For TeamB.
     */
    private void increaseScoreTeamB(int score)
    {
        scoreTeamB=scoreTeamB+score;
        displayForTeamB(scoreTeamB);
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view) {
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}