package com.example.travelguider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsPage extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        String topic = getIntent().getStringExtra("TOPIC");
        int image = getIntent().getIntExtra("IMAGE",0);
        String category4 = getIntent().getStringExtra("NAME1");
        String category5 = getIntent().getStringExtra("NAME2");
        String category6 = getIntent().getStringExtra("NAME3");
        String category7 = getIntent().getStringExtra("NAME4");
        String desc = getIntent().getStringExtra("DESC");

        textView = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView2);
        textView2 = (TextView) findViewById(R.id.textView4);
        textView3 = (TextView) findViewById(R.id.textView5);
        textView4 = (TextView) findViewById(R.id.textView6);
        textView5 = (TextView) findViewById(R.id.textView7);
        textView6 = (TextView) findViewById(R.id.textView3);

        textView.setText(topic);
        imageView.setImageResource(image);
        textView2.setText(category4);
        textView3.setText(category5);
        textView4.setText(category6);
        textView5.setText(category7);
        textView6.setText(desc);
    }
}