package com.frete.listapedidos.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.frete.listapedidos.databinding.FragmentMyOrderBinding;
import com.frete.listapedidos.viewmodel.OrderViewModel;

public class MyOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private OrderViewModel orderViewModel;
    private FragmentMyOrderBinding binding;
    private TextView txtNotifier;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyOrderBinding.inflate(inflater, container, false);

        recyclerView = binding.recyclerViewOrders;
        txtNotifier = binding.txtNotifier;

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderAdapter = new OrderAdapter(null);
        recyclerView.setAdapter(orderAdapter);

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        orderViewModel.getOrdersLiveData().observe(getViewLifecycleOwner(), orders -> {
            if (orders != null && !orders.isEmpty()) {
                recyclerView.setVisibility(View.VISIBLE);
                txtNotifier.setVisibility(View.GONE);
                orderAdapter.updateOrders(orders);
            } else {
                recyclerView.setVisibility(View.GONE);
                txtNotifier.setVisibility(View.VISIBLE);
            }
        });

        orderViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), errorMessage -> {
            if (errorMessage != null) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        orderViewModel.fetchOrders();

        return binding.getRoot();
    }
}