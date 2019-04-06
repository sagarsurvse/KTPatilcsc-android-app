package com.bcs.osm.ktpatilofbcsobad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Subject extends AppCompatActivity {


    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        button = (Button) findViewById(R.id.bcs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Bcs.class);
                view.getContext().startActivity(intent);
            }
        });



        button1 = (Button) findViewById(R.id.mcs);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Mcs.class);
                view.getContext().startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.crat);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Criateria.class);
                view.getContext().startActivity(intent);
            }
        });

    }
}