package com.example.android.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        // Find View that shows "california girls" and Set a click listener on that View
        TextView song = (TextView) findViewById(R.id.song1);
        song.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when "the beach boys" is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
