package com.developeronrent.yapnaaAgent.Service;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import static com.developeronrent.yapnaaAgent.Activity.MainActivity.token;

public class MyFirebaseInstanceId extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        if(refreshedToken!=token)
        token = FirebaseInstanceId.getInstance().getToken();
        Log.d("MyFirebaseToken", "Refreshed token: " + refreshedToken);
    }
}

