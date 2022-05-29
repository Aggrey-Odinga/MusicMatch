package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArtistsActivity extends AppCompatActivity {

    private ListView mListView;
    private String [] Artists = new String[] {"Sauti Sol",
            "Nviiri The Storyteller", "Otile Brown",
            "Nyashinski", "Bensoul", "Wakadinali",
            "BURUKLYN BOYZ", "H_art the Band",
            "Mejja", "Khaligraph Jones"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        mListView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
//        mListView.setAdapter(adapter);
    }
}