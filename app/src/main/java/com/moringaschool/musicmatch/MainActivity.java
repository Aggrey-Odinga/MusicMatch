package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.buttontoptenartists) Button mButtontoptenartists;
    @BindView(R.id.locationEditText)
    EditText mLocationEditText;
    @BindView(R.id.buttonlisttrendingsongs)
    Button mbuttonlisttrendingsongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtontoptenartists.setOnClickListener(this);
        mbuttonlisttrendingsongs.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mbuttonlisttrendingsongs) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, SongsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
        if(v == mButtontoptenartists){
             Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
            startActivity(intent);
        }
    }
}