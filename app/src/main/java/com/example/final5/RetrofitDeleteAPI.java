package com.example.final5;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitDeleteAPI {
    @DELETE("Dogs/")
    Call<Modal> deleteData(@Query("id") int Id);
}
