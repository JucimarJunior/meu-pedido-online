package com.frete.listapedidos.service;

import com.frete.listapedidos.model.Order;
import java.util.List;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OrderService {
    @GET("/api/pedidos")
    Call<List<Order>> getOrders();

    @POST("/api/pedidos")
    Call<Void> createOrder(@Body Order order);
}