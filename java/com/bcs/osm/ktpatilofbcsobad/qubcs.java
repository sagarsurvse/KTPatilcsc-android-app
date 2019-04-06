package com.bcs.osm.ktpatilofbcsobad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class qubcs extends AppCompatActivity {

    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qubcs);



        pdfView=(PDFView)findViewById(R.id.bcs);
        pdfView.fromAsset("Question paper1.pdf").load();

    }
}
