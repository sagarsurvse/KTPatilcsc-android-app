package com.bcs.osm.ktpatilofbcsobad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class Criateria extends AppCompatActivity {

    WebView webView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criteria);

       webView=(WebView)findViewById(R.id.crate);
        WebSettings ws=webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/table.html");


    }
}