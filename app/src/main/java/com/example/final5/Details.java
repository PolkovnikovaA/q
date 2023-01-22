package com.example.final5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    Mask mask;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mask = getIntent().getParcelableExtra("Dogs");
        text1 = findViewById(R.id.textView3);
        text1.setText(mask.getDog());
        text2 = findViewById(R.id.textView4);
        text2.setText(mask.getInfo());
    }

    public void Next(View view)
    {
        Intent intent = new Intent(Details.this, MainActivity.class);
        startActivity(intent);
    }
}