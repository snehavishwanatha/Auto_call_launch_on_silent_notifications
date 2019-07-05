package com.developeronrent.yapnaaAgent.API;

import com.developeronrent.yapnaaAgent.POJO.Example;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    @FormUrlEncoded
    @POST
    Call<Example> postUser(@Url String url, @Field("admin_email_id") String param1, @Field("admin_password")String param2,
                           @Field("admin_fcm_token") String param3);

}
