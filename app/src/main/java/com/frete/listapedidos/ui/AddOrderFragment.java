package com.frete.listapedidos.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.frete.listapedidos.databinding.FragmentAddOrderBinding;
import com.frete.listapedidos.model.Order;
import com.frete.listapedidos.viewmodel.OrderViewModel;

public class AddOrderFragment extends Fragment {

    private OrderViewModel orderViewModel;
    private FragmentAddOrderBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddOrderBinding.inflate(inflater, container, false);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        setupUI();
        observerViewModel();

        return binding.getRoot();
    }

    private void setupUI() {
        binding.btnCreateData.setOnClickListener(v -> sendOrder());
    }

    private void observerViewModel() {
        orderViewModel.getPostSuccessLiveData().observe(getViewLifecycleOwner(), success -> {
            if (success) {
                Toast.makeText(getContext(), "Pedido criado com sucesso", Toast.LENGTH_SHORT).show();
                clearFields();
                orderViewModel.resetPostSuccess();
            }
        });

        orderViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), error ->
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show()
        );
    }

    private void sendOrder() {
        String nameClient = binding.clientName.getText().toString().trim();
        String nameProduct = binding.productName.getText().toString().trim();
        String quantityInput = binding.quantityProduct.getText().toString().trim();
        String totalInput = binding.totalValue.getText().toString().trim();

        if(nameClient.isEmpty() || nameProduct.isEmpty() || quantityInput.isEmpty() || totalInput.isEmpty()) {
           Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
           return;
        }

        orderViewModel.createOrder(new Order(nameClient, nameProduct, Integer.parseInt(quantityInput), Double.parseDouble(totalInput)));
    }

    public void clearFields() {
        binding.clientName.setText("");
        binding.productName.setText("");
        binding.quantityProduct.setText("");
        binding.totalValue.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}