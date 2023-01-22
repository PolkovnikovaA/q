package com.example.final5;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitPostAPI {
    @POST ("Dogs")
    Call<Modal> createPost(@Body Modal modal);
}
