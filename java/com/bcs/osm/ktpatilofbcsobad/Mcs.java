package com.bcs.osm.ktpatilofbcsobad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Mcs extends AppCompatActivity {

    PDFView pdfView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcssy);

        pdfView=(PDFView)findViewById(R.id.mcs);
        pdfView.fromAsset("mcs.pdf").load();


    }
}