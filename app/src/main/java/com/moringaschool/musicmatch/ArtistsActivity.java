package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArtistsActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.topTenTrendingButton)
    Button mTopTenTrendingButton;
    @BindView(R.id.countryEditText)
    EditText mcountryEditText;
    @BindView(R.id.listView)
    ListView mListView;

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


        mTopTenTrendingButton.setOnClickListener(this);

        ArtistsArrayAdapter adapter = new ArtistsArrayAdapter(this, android.R.layout.simple_list_item_1,Artists,Songs);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Artists);
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
    @Override
    public void onClick(View v) {
        if(v == mTopTenTrendingButton) {
            String country = mcountryEditText.getText().toString();
            Intent intent = new Intent(ArtistsActivity.this, TopTrendingActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        }
    }


}

