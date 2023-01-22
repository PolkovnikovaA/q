package com.example.final5;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitPutAPI {
    @PUT("Dogs/")
    Call<Modal> deleteData(@Query("id") int Id, @Body Modal modal);
}
