package com.developeronrent.yapnaaAgent.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.developeronrent.yapnaaAgent.R;

import static com.developeronrent.yapnaaAgent.Activity.MainActivity.Status;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminaddress;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.admineid;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminfcm;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminid;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminlogin;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminname;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminphone;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.adminroleid;

public class Profile extends AppCompatActivity {

    TextView details,profile;
    Button Logoff;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile=(TextView )findViewById(R.id.Profile);
        details = (TextView) findViewById(R.id.UserDetails);
        Logoff = (Button) findViewById(R.id.Logoff);

        profile.setText("Welcome "+adminname);

        details.setText("PROFILE\n"+
                "admin_name : " +adminname +"\n"+
                "admin_email_id : " + admineid +"\n" +
                "admin_last_login : "+adminlogin +"\n" +
                "admin_phone_no : "+adminphone +"\n"+
                "admin_address : " + adminaddress);

        Logoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Status = 0;
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
