package com.bcs.osm.ktpatilofbcsobad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;


public class About extends AppCompatActivity {

    PDFView pdfView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        pdfView=(PDFView)findViewById(R.id.about);
        pdfView.fromAsset("about.pdf").load();


    }
}

