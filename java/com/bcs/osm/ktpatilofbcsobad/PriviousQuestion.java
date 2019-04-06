package com.bcs.osm.ktpatilofbcsobad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PriviousQuestion extends AppCompatActivity {

    private Button button;
    private Button button1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privious_question);


        button = (Button) findViewById(R.id.bcs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), qubcs.class);
                view.getContext().startActivity(intent);
            }
        });



        button1 = (Button) findViewById(R.id.mcs);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), qumcs.class);
                view.getContext().startActivity(intent);
            }
        });











    }
}
