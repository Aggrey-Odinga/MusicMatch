package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    declare button view variable
//    view binding to locate button easily
//    private Button mButtontoptenartists;
    @BindView(R.id.buttontoptenartists) Button mButtontoptenartists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        implement butterknife
        ButterKnife.bind(this);
//        setting the variable

//        mButtontoptenartists = (Button)findViewById(R.id.buttontoptenartists);
//      implement a toast msg
//        implement intent tot take us to new page

        mButtontoptenartists.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mButtontoptenartists){
            //                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ArtistsActivity.class);
            startActivity(intent);

        }

    }
}