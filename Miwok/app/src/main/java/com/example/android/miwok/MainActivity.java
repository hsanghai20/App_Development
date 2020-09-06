package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // number category
        TextView numbers= (TextView) findViewById(R.id.numbers);
        // either we make new package which implements OnClickListener and then import and use it here or we direct
        // write the fnc to optimize the code
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // this is explicit intent bcz we know that which activity to open
                // In just java app we use implicit intent bcz we are not sure that particular user has that app present or not
                Intent i = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(i);
            }
        });

        // family category
        final TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(i);
            }
        });

        // phrases category
        final TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(i);
            }
        });

        // colors category
        final TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });

    }

}