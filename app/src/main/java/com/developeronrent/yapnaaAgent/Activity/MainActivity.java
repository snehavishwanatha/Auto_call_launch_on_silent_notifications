package com.developeronrent.yapnaaAgent.Activity;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developeronrent.yapnaaAgent.API.ApiClient;
import com.developeronrent.yapnaaAgent.API.ApiInterface;
import com.developeronrent.yapnaaAgent.POJO.Example;
import com.developeronrent.yapnaaAgent.R;
import com.google.firebase.iid.FirebaseInstanceId;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static int Status=0;
    private static int REQUEST_CALL=1;

    public static String adminid,adminname,admineid,adminpw,adminlogin,adminroleid,adminphone,adminaddress,adminfcm;
    public static String token ;

    Button login;
    public static EditText emailid,password;
    String email1,passwordl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Status==1)
        {
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
            finish();
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE)!=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    }


        login = (Button) findViewById(R.id.button);
        emailid = (EditText) findViewById(R.id.EmailId);
        password = (EditText) findViewById(R.id.Password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }

            private void userLogin() {
                email1 = emailid.getText().toString();
                passwordl = password.getText().toString();

                if (email1.isEmpty()) {
                    emailid.setError("Require email id");
                    emailid.requestFocus();
                    return;
                }

                if (passwordl.isEmpty()) {
                    password.setError("enter password");
                    password.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
                    emailid.setError("Please enter a valid email");
                    emailid.requestFocus();
                    return;
                }

                if (passwordl.length() < 6) {
                    password.setError("incorrect password");
                    password.requestFocus();
                    return;
                }


                ApiInterface api = ApiClient.getClient().create(ApiInterface.class);

                token = FirebaseInstanceId.getInstance().getToken();
                Log.e("TokenYapnaa", token);
                String url ="https://yapnaa.com/movilo/mobi_index.php?page=user";
                Call<Example> call2 = api.postUser(url,email1,passwordl,token);


                call2.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Log.e("SuccessRetro", "Success");

                        if(response.isSuccessful()) {
                            Log.e("SuccessRetro", "Yes " + response.body());
                        }

                        if(response.body().getStatus()!=null)
                        {
                            Toast.makeText(getApplicationContext(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();

                            if(response.body().getUserDetails()!=null)
                                if(response.body().getUserDetails().get(0)!=null) {
                                    adminid = response.body().getUserDetails().get(0).getAdminId();
                                    adminaddress = response.body().getUserDetails().get(0).getAdminAddress();
                                    adminfcm=response.body().getUserDetails().get(0).getAdminFcmId();
                                    adminphone=response.body().getUserDetails().get(0).getAdminPhoneNo();
                                    adminroleid=response.body().getUserDetails().get(0).getAdminRoleId();
                                    adminname =response.body().getUserDetails().get(0).getAdminName();
                                    admineid =response.body().getUserDetails().get(0).getAdminEmailId();
                                    adminlogin =  response.body().getUserDetails().get(0).getAdminLastLogin();


                                    Intent intent = new Intent(getApplicationContext(),Profile.class);
                                    startActivity(intent);
                                    Status=1;
                                    finish();
                                }
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.d("FailureRetro", "Failure");

                    }
                });

            }

        });

    }
}
