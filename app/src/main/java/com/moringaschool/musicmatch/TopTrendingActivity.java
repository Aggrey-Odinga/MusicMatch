package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopTrendingActivity extends AppCompatActivity {

    @BindView(R.id.toptrendingTextView)
    TextView mtoptrendingTextView;
    @BindView(R.id.listView)
    ListView mListview;

    private String [] toptrending = new String[]{
            "1.Nviiri The Storyteller, Bien – Niko Sawa","2. Nikita Kering’ – Ex","3. Bensoul, Mejja, Nviiri The Storyteller, Sauti Sol – Nairobi", "4. H_art the Band, Brizy Annechild – My Jaber (Friday)", "5. Otile Brown, Meddy – Dusuma", "6. Nviiri The Storyteller – Kitenge", "7. Chris Kaiga, Mutoriah – I Want",
            "8. Wakadinali, Geri Inengi", "9. NDOVU KUU, Khaligraph Jones, Boutross Munene – NDOVU NI KUU","10. Chris Kaiga, Nyashinski  – Hapo Tu"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_trending);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, toptrending);

        mListview.setAdapter(adapter);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        mtoptrendingTextView.setText("This are the top ten trending songs in Kenya :" + country);

    }
}