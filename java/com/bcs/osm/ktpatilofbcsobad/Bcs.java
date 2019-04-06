package com.bcs.osm.ktpatilofbcsobad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;




public class Bcs extends AppCompatActivity {

    PDFView pdfView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bcssy);

        pdfView=(PDFView)findViewById(R.id.bcs);
        pdfView.fromAsset("bcs.pdf").load();


    }
}