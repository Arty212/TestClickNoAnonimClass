package com.example.arturbaboskin.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private ImageView image;
    private int score;
    private boolean flag;

    private static final String SCORE_KEY = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        image = findViewById(R.id.btn);

        image.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_KEY, score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt(SCORE_KEY);
        text.setText(String.valueOf(score));
    }

    @Override
    public void onClick(View v) {
        Log.d("MyLog", "меня таки нажали, да...");
        score++;

        if (flag)
            image.setImageDrawable(getResources().getDrawable(R.drawable.starfish));
        else
            image.setImageDrawable(getResources().getDrawable(R.drawable.crab));

        flag = !flag;
        text.setText(String.valueOf(score));
    }
}
