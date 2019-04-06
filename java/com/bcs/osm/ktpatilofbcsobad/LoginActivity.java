package com.bcs.osm.ktpatilofbcsobad;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Mark on 25/11/2018.
 */

public class LoginActivity  extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private Button btnLogin;

    String currentDeviceId;

    User user = User.getInstance();

    EditText editTextUsername;


    FirebaseDatabase database;
    DatabaseReference usersRef;

    private static final Intent[] AUTO_START_INTENTS = {
            new Intent().setComponent(new ComponentName("com.samsung.android.lool",
                    "com.samsung.android.sm.ui.battery.BatteryActivity")),
            new Intent("miui.intent.action.OP_AUTO_START").addCategory(Intent.CATEGORY_DEFAULT),
            new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")),
            new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")),
            new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")),
            new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")),
            new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")),
            new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")),
            new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")),
            new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")),
            new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")),
            new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity")).setData(
                    Uri.parse("mobilemanager://function/entry/AutoStart"))
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_login);


        for (Intent intent : AUTO_START_INTENTS)
            if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                new MaterialDialog.Builder(this).title("Enable AutoStart")
                        .content(
                                "Please allow App to always run in the background,else our services can't be accessed when you are in distress")
                        .theme(Theme.LIGHT)
                        .positiveText("ALLOW")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                try {
                                    for (Intent intent : AUTO_START_INTENTS)
                                        if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                                            startActivity(intent);
                                            break;
                                        }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .show();
                break;
            }



        SharedPreferences sharedpreferences = getSharedPreferences(user.appPreferences, Context.MODE_PRIVATE);
        user.sharedpreferences = sharedpreferences;

        currentDeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        database = FirebaseDatabase.getInstance();
        usersRef = database.getReference("users");

        final ProgressDialog Dialog = new ProgressDialog(this);
        Dialog.setMessage("Please wait..");
        Dialog.setCancelable(false);
        Dialog.show();

        usersRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                Dialog.dismiss();

                for (com.google.firebase.database.DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    FirebaseUserModel firebaseUserModel = userSnapshot.getValue(FirebaseUserModel.class);

                    if (firebaseUserModel.getDeviceId().equals(currentDeviceId)) {
                        firebaseUserModel.setDeviceToken(FirebaseInstanceId.getInstance().getToken());
                        user.login(firebaseUserModel);
                        user.saveFirebaseKey(userSnapshot.getKey());
                        moveToChattingScreen();




                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Dialog.dismiss();
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);




    }



    public void moveToChattingScreen() {

        Intent intent = new Intent(this, SuccessActivity.class);
        startActivity(intent);
        finish();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Welcome " +user.name)
                .setContentText("Welcome to at KT Patil College Of Computer Science From Osmanabad ")
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setDefaults(Notification.FLAG_ONLY_ALERT_ONCE);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        MediaPlayer mp= MediaPlayer.create(LoginActivity.this, R.raw.ring);
        mp.start();
        manager.notify(73195, builder.build());


    }





    public void showMessage(String strTitle, String strMessage) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(strTitle)
                .setMessage(strMessage)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

    }

    public void btnLoginTapped(View view) {
        String strUsername = editTextUsername.getText().toString().trim();
        if (strUsername.isEmpty()) {
            showMessage("Invalid", "Please enter name");
        } else {
            final FirebaseUserModel firebaseUserModel = new FirebaseUserModel();
            firebaseUserModel.setUsername(strUsername);
            firebaseUserModel.setDeviceId(currentDeviceId);
            firebaseUserModel.setDeviceToken(FirebaseInstanceId.getInstance().getToken());

            final ProgressDialog Dialog = new ProgressDialog(this);
            Dialog.setMessage("Please wait..");
            Dialog.setCancelable(false);
            Dialog.show();



            final DatabaseReference newRef = usersRef.push();
            newRef.setValue(firebaseUserModel, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    Dialog.dismiss();


                    if (user.login(firebaseUserModel)) {
                        moveToChattingScreen();

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this)
                                .setContentTitle("Thank for login  " +user.name)
                                .setContentText("Welcome to at KT Patil College Of Computer Science From Osmanabad ")
                                .setSmallIcon(R.drawable.icon)
                                .setAutoCancel(true)
                                .setDefaults(Notification.FLAG_ONLY_ALERT_ONCE);
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        MediaPlayer mp= MediaPlayer.create(LoginActivity.this, R.raw.ring);
                        mp.start();
                        manager.notify(73195, builder.build());
                    }
                }
            });
        }
    }
}
