package com.frete.listapedidos.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.frete.listapedidos.model.Order;
import com.frete.listapedidos.service.OrderService;
import com.frete.listapedidos.service.RetrofitConfig;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Response;

public class OrderViewModel extends ViewModel {
    private final OrderService orderService;
    private final MutableLiveData<List<Order>> orderLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> postSuccessLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MutableLiveData<Boolean> isLoadingLiveData = new MutableLiveData<>();

    public LiveData<Boolean> getIsLoadingLiveData() {
        return isLoadingLiveData;
    }

    public OrderViewModel() {
        orderService = RetrofitConfig.getOrderService();
    }

    public LiveData<List<Order>> getOrdersLiveData() {
        return orderLiveData;
    }

    public LiveData<Boolean> getPostSuccessLiveData() {
        return postSuccessLiveData;
    }

    public void resetPostSuccess() {
        postSuccessLiveData.postValue(false);
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void fetchOrders() {
        if (orderLiveData.getValue() != null && !orderLiveData.getValue().isEmpty()) {
            return;
        }
        isLoadingLiveData.postValue(true);
        errorLiveData.postValue(null);
        executorService.execute(() -> {
            try {
                Response<List<Order>> response = orderService.getOrders().execute();
                if (response.isSuccessful() && response.body() != null) {
                    orderLiveData.postValue(response.body());
                } else {
                    errorLiveData.postValue("Erro ao carregar pedidos: " + response.code());
                }

            } catch (Exception e) {
                e.printStackTrace();
                errorLiveData.postValue("Falha na conexão: " + e.getMessage());
            } finally {
                isLoadingLiveData.postValue(false);
            }
        });
    }

    public void createOrder(Order order) {
        executorService.execute(() -> {
            try {
                Response<Void> response = orderService.createOrder(order).execute();
                if(response.isSuccessful()) {
                    postSuccessLiveData.postValue(true);
                } else {
                    errorLiveData.postValue("Error ao criar pedido: " + response.code());
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorLiveData.postValue("Falha na conexão: " + e.getMessage());
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }
}
