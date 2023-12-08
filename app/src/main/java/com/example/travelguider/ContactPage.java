package com.example.travelguider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactPage extends AppCompatActivity {

    EditText fullname;
    EditText email;
    EditText message;
    Button btn1;
    Button btn2;
    TextView display1;
    TextView display2;
    TextView display3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        fullname = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        message = (EditText) findViewById(R.id.editText3);
        btn1 = (Button) findViewById(R.id.button2);
        btn2 = (Button) findViewById(R.id.button3);
        display1 = (TextView) findViewById(R.id.textView10);
        display2 = (TextView) findViewById(R.id.textView11);
        display3 = (TextView) findViewById(R.id.textView12);


        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("message", MODE_PRIVATE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor insert = sharedPreferences.edit();

                String fname = fullname.getText().toString();
                String mail = email.getText().toString();
                String msg = message.getText().toString();

                insert.putString("f",fname);
                insert.putString("e",mail);
                insert.putString("m",msg);

                insert.apply();
                fullname.setText("");
                email.setText("");
                message.setText("");
                Toast.makeText(ContactPage.this, "Thank you for contact us", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sharedPreferences.contains("f")){
                    display1.setVisibility(View.VISIBLE);
                    display1.setText(sharedPreferences.getString("f",""));
                }
                if(sharedPreferences.contains("e")){
                    display2.setVisibility(View.VISIBLE);
                    display2.setText(sharedPreferences.getString("e",""));
                }
                if(sharedPreferences.contains("m")){
                    display3.setVisibility(View.VISIBLE);
                    display3.setText(sharedPreferences.getString("m",""));
                }
            }
        });


    }
}