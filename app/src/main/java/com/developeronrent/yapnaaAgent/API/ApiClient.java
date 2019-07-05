package com.developeronrent.yapnaaAgent.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //https://yapnaa.com/movilo/mobi_index.php?page=user

    public static final String BASE_URL = "https://yapnaa.com/";
    //   /movilo/mobi_index.php?page=user";


    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
