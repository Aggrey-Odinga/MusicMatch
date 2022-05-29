package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistsActivity extends AppCompatActivity {

    @BindView(R.id.listView) ListView mListView;

    private String [] Artists = new String[] {"Sauti Sol",
            "Nviiri The Storyteller", "Otile Brown",
            "Nyashinski", "Bensoul", "Wakadinali",
            "BURUKLYN BOYZ", "H_art the Band",
            "Mejja", "Khaligraph Jones"};
    private String[] Songs = new String[] {
      "Short n Sweet","Pombe Sigara",
            "Jeraha","Mungu Pekee","Nakufa",
            "Geri Inengi","Shifter","Nikikutazama",
            "Siskii","The O.G"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        ButterKnife.bind(this);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Artists);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Artists = ((TextView)view).getText().toString();
                Log.d("ArtistsActivity.this", "ONITEMCLICK");
                Toast.makeText(ArtistsActivity.this, Artists, Toast.LENGTH_LONG).show();
            }
        });

        };
    }
