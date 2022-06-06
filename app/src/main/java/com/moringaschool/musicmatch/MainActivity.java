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
        if(v == mButtontoptenartists){
            String artist = martistEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
            intent.putExtra("artist", artist);
            startActivity(intent);
        }
    }
}