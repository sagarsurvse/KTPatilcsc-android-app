package com.bcs.osm.ktpatilofbcsobad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class qumcs extends AppCompatActivity {


    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qumcs);




        pdfView=(PDFView)findViewById(R.id.mcs);
        pdfView.fromAsset("msc1.pdf").load();






    }
}
