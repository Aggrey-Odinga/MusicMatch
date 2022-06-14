package com.moringaschool.musicmatch.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.musicmatch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @BindView(R.id.artistEditText)
    EditText martistEditText;
    @BindView(R.id.buttontoptenartists)
    Button mButtontoptenartists;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtontoptenartists.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            String artist = martistEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
            intent.putExtra("artist", artist);
            startActivity(intent);
    }
    public void onLaunchWebPagebuttonClicked (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/musixmatch/musixmatch-sdk"));
        startActivity(intent);
    }
}
