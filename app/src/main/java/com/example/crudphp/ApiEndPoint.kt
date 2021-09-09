package com.example.crudphp

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndPoint {

    @GET("data.php")
    fun data():Call<NoteModel>

    @FormUrlEncoded
    @POST("post%20data.php")
    fun Crate(@Field("note")note: String):Call<SubmitModel>

    @FormUrlEncoded
    @POST("update.php")
    fun update(
            @Field("id") id: String,
            @Field("note")note: String
    ):Call<SubmitModel>

    @FormUrlEncoded
    @POST("Delete.php")
    fun delete(
            @Field("id") id: String,
    ):Call<SubmitModel>
}