package com.frete.listapedidos.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private static final String BASE_URL = "http://10.0.2.2:XXXX"; // XXXX Colocar a porta Criada na API .NET

    private static final Gson gson = new GsonBuilder().create();

    private static final OkHttpClient okHttp = new OkHttpClient.Builder().build();

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static OrderService getOrderService() {
        return retrofit.create(OrderService.class);
    }
}
