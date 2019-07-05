package com.developeronrent.yapnaaAgent.Service;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.developeronrent.yapnaaAgent.Activity.DialUp;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class MyFirebaseMessagingClass extends FirebaseMessagingService {
    public static String numberdial;
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        {
            Log.e("dataChat",remoteMessage.getData().toString());
            Map<String, String> params = remoteMessage.getData();
            JSONObject object = new JSONObject(params);
            Log.e("JSON_OBJECT", object.toString());
            try {
                if(object.getString("type").equals("silent_call"))
                {
                    numberdial = object.getString("number");
                    Log.e("numberdial ", numberdial);
                    Intent backgroundIntent = new Intent(getApplicationContext(), DialUp.class);
                    backgroundIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, backgroundIntent,
                            PendingIntent.FLAG_ONE_SHOT);
                    try {
                        pendingIntent.send();
                    } catch (PendingIntent.CanceledException e) {
                        e.printStackTrace();
                    }
                }

            } catch(JSONException e)
            {
                e.printStackTrace();
            }
        }

        //if the message contains data payload
        //It is a map of custom keyvalues
        //we can read it easily
        if(remoteMessage.getData().size() > 0){
            //handle the data message here
        }

        //getting the title and the body

     /*   String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        Log.d(TAG, "title is "+title);
        Log.d(TAG, "body is "+body);*/

        //then here we can use the title and body to build a notification
    }

}
