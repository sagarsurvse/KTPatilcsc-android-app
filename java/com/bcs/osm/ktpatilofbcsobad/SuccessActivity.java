package com.bcs.osm.ktpatilofbcsobad;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class SuccessActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=5500;
    private Button button1;
    private Button button12;
    private Intent subject;
    private Intent PriviousQuestion;
    Intent mServiceIntent;
    private YourService mYourService;


    User user = User.getInstance();
    String currentDeviceId;




    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    String text;
    EditText et;
    TextToSpeech tts;





    FirebaseDatabase database;
    DatabaseReference usersRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);




        AppRater.app_launched(this);

        currentDeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        database = FirebaseDatabase.getInstance();
        usersRef = database.getReference("users");

        mYourService = new YourService();
        mServiceIntent = new Intent(this, mYourService.getClass());
        if (!isMyServiceRunning(mYourService.getClass())) {
            startService(mServiceIntent);
        }

            button1 = (Button) findViewById(R.id.chat);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChattingActivity.class);
                view.getContext().startActivity(intent);
            }
        });


        FloatingActionButton fab = findViewById(R.id.callnow);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:09822596823"));
                startActivity(intent1);

            }
        });








        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        nv = (NavigationView)findViewById(R.id.nv);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {



            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {

                    case R.id.google:
                        Intent myWebLink8 = new Intent(Intent.ACTION_VIEW);
                        myWebLink8.setData(Uri.parse("http://www.ktpatilcscosmanabad.tk/"));
                        startActivity(myWebLink8);

                        break;
                    case R.id.ID:

                        item.setTitle(user.name);

                        break;

                    case R.id.message:

                        Intent intent = new Intent(SuccessActivity.this, ChattingActivity.class);
                        startActivity(intent);

                        break;

                    case R.id.myface:
                        Intent myWebLink0 = new Intent(Intent.ACTION_VIEW);
                        myWebLink0.setData(Uri.parse("https://www.facebook.com/KT-patil-college-of-BCS-from-Osmanabad-476666916185097/?ref=bookmarks"));
                        startActivity(myWebLink0);


                        break;


                    case R.id.insta:

                        Intent myWebLink2 = new Intent(Intent.ACTION_VIEW);
                        myWebLink2.setData(Uri.parse("https://www.instagram51.com/kt_patil_clg_osmanabad/?hl=en"));
                        startActivity(myWebLink2);

                        break;




                    case R.id.phone:

                        Intent intent1 = new Intent(Intent.ACTION_DIAL);
                        intent1.setData(Uri.parse("tel:09822596823"));
                        startActivity(intent1);

                        break;

                    case R.id.rate:


                        Intent myWebLink02 = new Intent(Intent.ACTION_VIEW);
                        myWebLink02.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.bcs.osm.ktpatilofbcsobad"));
                        startActivity(myWebLink02);
                        break;

                    case R.id.share:

                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        String shareSubText = "KTPatilcsc - The Great education APP";
                        String shareBodyText = "https://play.google.com/store/apps/details?id=com.bcs.osm.ktpatilofbcsobad";
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                        startActivity(Intent.createChooser(shareIntent, "Share With"));

                        break;


                    default:
                        return onNavigationItemSelected(item);

                }

                return true;

            }
        });










        Button butt10 = (Button) findViewById(R.id.button10);
        Button butt7 = (Button) findViewById(R.id.button7);
        Button butt11 = (Button) findViewById(R.id.button11);
        Button butt8 = (Button) findViewById(R.id.button8);
        Button butt6 = (Button) findViewById(R.id.button6);





        butt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(SuccessActivity.this, Subject.class);
                startActivity(int6);
            }
        });


        butt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(SuccessActivity.this, career.class);
                startActivity(int7);
            }
        });


        butt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int10 = new Intent(SuccessActivity.this, program.class);
                startActivity(int10);
            }
        });


        butt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int8 = new Intent(SuccessActivity.this, PriviousQuestion.class);
                startActivity(int8);
            }
        });


        butt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int11 = new Intent(SuccessActivity.this, About.class);
                startActivity(int11);
            }
        });




        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.callnow);
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(floatingActionButton.getContext(), R.anim.shake);

        anim.setDuration(200L);



        floatingActionButton.startAnimation(anim);


    }













    public static class AppRater {
        private final static String APP_TITLE = "KTPatilcsc";// App Name
        private final static String APP_PNAME = "com.bcs.osm.ktpatilofbcsobad";// Package Name

        private final static int DAYS_UNTIL_PROMPT = 1;//Min number of days
        private final static int LAUNCHES_UNTIL_PROMPT = 1;//Min number of launches

        public static void app_launched(Context mContext) {
            SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
            if (prefs.getBoolean("dontshowagain", false)) { return ; }

            SharedPreferences.Editor editor = prefs.edit();

            // Increment launch counter
            long launch_count = prefs.getLong("launch_count", 0) + 1;
            editor.putLong("launch_count", launch_count);

            // Get date of first launch
            Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
            if (date_firstLaunch == 0) {
                date_firstLaunch = System.currentTimeMillis();
                editor.putLong("date_firstlaunch", date_firstLaunch);
            }

            // Wait at least n days before opening
            if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
                if (System.currentTimeMillis() >= date_firstLaunch +
                        (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                    showRateDialog(mContext, editor);
                }
            }

            editor.commit();
        }

        public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
            final Dialog dialog = new Dialog(mContext);
            dialog.setTitle("Rate " + APP_TITLE);

            LinearLayout ll = new LinearLayout(mContext);
            ll.setOrientation(LinearLayout.VERTICAL);

            TextView tv = new TextView(mContext);
            tv.setText("If you enjoy using " + APP_TITLE + ", please take a moment to rate it. Thanks for your support!");
            tv.setWidth(240);
            tv.setPadding(4, 0, 4, 10);
            ll.addView(tv);

            Button b1 = new Button(mContext);
            b1.setText("Rate " + APP_TITLE);
            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                    dialog.dismiss();
                }
            });
            ll.addView(b1);

            Button b2 = new Button(mContext);
            b2.setText("Remind me later");
            b2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            ll.addView(b2);

            Button b3 = new Button(mContext);
            b3.setText("No, thanks");
            b3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (editor != null) {
                        editor.putBoolean("dontshowagain", true);
                        editor.commit();
                    }
                    dialog.dismiss();
                }
            });
            ll.addView(b3);

            dialog.setContentView(ll);
            dialog.show();
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("Service status", "Running");
                return true;
            }
        }
        Log.i ("Service status", "Not running");
        return false;
    }


    @Override
    protected void onDestroy() {
        stopService(mServiceIntent);
        super.onDestroy();
    }









    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) return true;

        return super.onOptionsItemSelected(item);
    }




    public void sub(View view) {
    }












    }


