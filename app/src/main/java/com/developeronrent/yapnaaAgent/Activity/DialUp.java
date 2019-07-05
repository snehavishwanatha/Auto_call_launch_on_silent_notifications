package com.developeronrent.yapnaaAgent.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.developeronrent.yapnaaAgent.R;

import static com.developeronrent.yapnaaAgent.Service.MyFirebaseMessagingClass.numberdial;

public class DialUp extends AppCompatActivity {
    private static int REQUEST_CALL=1;
    TextView callstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_up);

        callstatus = (TextView) findViewById(R.id.Call);


        //permission
        if(ContextCompat.checkSelfPermission(DialUp.this, android.Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Yapnaa - You cannot make calls! Provide permissions.", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(DialUp.this,
                    new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }

        makePhoneCall();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        callstatus.setText("Done!");

    }

    private void makePhoneCall() {
        if(numberdial!=null)
            if(numberdial.length()>0)
            {
                if(ContextCompat.checkSelfPermission(DialUp.this, android.Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(DialUp.this,
                            new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                    finish();
                }
                else
                {
                    if(numberdial!=null){
                        String dial = "tel:"+numberdial;
                        numberdial=null;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    finish();}

                }
            }

    }


}
