package com.moringaschool.musicmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//    declare button view variable
    private Button mButtontoptenartists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setting the variable

        mButtontoptenartists = (Button)findViewById(R.id.buttontoptenartists);
    }
}