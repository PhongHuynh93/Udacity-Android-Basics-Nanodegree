package com.example.android.musicappstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find View that shows artists list and Set a click listener on that View
        TextView artists = (TextView) findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the artist category is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ArtistListActivity.class);
                startActivity(intent);
            }
        });

        // Find View that shows albums list and Set a click listener on that View
        TextView albums = (TextView) findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the album category is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlbumListActivity.class);
                startActivity(intent);
            }
        });
        // Find View that shows albums list and Set a click listener on that View
        TextView search = (TextView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the album category is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
